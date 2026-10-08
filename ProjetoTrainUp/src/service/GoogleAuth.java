package service;

import java.awt.Desktop;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.net.httpserver.HttpServer;

import model.Usuario;

/**
 * Login com Google.
 *
 * 1. Abre o navegador na página de login do Google.
 * 2. O Google devolve um código para um servidor local (127.0.0.1).
 * 3. O código é trocado por um token.
 * 4. Com o token, busca o nome e o e-mail do usuário.
 *
 * As credenciais ficam no arquivo "google.properties" na pasta do projeto.
 */
public class GoogleAuth {

    public static Usuario login() throws Exception {

        // CREDENCIAIS

        Properties config = new Properties();

        try (FileInputStream arquivo = new FileInputStream("google.properties")) {
            config.load(arquivo);
        } catch (IOException erro) {
            throw new Exception("Arquivo \"google.properties\" não encontrado na pasta do projeto.");
        }

        String clientId = config.getProperty("client_id");
        String clientSecret = config.getProperty("client_secret");


        // SERVIDOR LOCAL QUE RECEBE A RESPOSTA DO GOOGLE

        CompletableFuture<String> resposta = new CompletableFuture<>();

        HttpServer servidor = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);

        servidor.createContext("/", troca -> {

            byte[] pagina = "<h2>Pronto! Pode voltar ao TrainUp.</h2>"
                    .getBytes(StandardCharsets.UTF_8);

            troca.getResponseHeaders().add("Content-Type", "text/html; charset=utf-8");
            troca.sendResponseHeaders(200, pagina.length);

            try (OutputStream saida = troca.getResponseBody()) {
                saida.write(pagina);
            }

            resposta.complete(troca.getRequestURI().getQuery());
        });

        servidor.start();

        String redirect = "http://127.0.0.1:" + servidor.getAddress().getPort();

        // Valor aleatório para conferir que a resposta é deste login
        String state = UUID.randomUUID().toString();

        try {

            // ABRE O NAVEGADOR

            Desktop.getDesktop().browse(URI.create(
                    "https://accounts.google.com/o/oauth2/v2/auth"
                    + "?client_id=" + codificar(clientId)
                    + "&redirect_uri=" + codificar(redirect)
                    + "&response_type=code"
                    + "&scope=" + codificar("openid email profile")
                    + "&state=" + state
                    + "&prompt=select_account"
            ));


            // ESPERA O USUÁRIO FAZER LOGIN (até 3 minutos)

            String query = resposta.get(3, TimeUnit.MINUTES);

            String code = lerParametro(query, "code");

            if (code == null || !state.equals(lerParametro(query, "state"))) {
                throw new Exception("Login cancelado.");
            }


            // TROCA O CÓDIGO PELO TOKEN

            HttpClient http = HttpClient.newHttpClient();

            HttpRequest pedidoToken = HttpRequest.newBuilder(
                            URI.create("https://oauth2.googleapis.com/token"))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(
                            "code=" + codificar(code)
                            + "&client_id=" + codificar(clientId)
                            + "&client_secret=" + codificar(clientSecret)
                            + "&redirect_uri=" + codificar(redirect)
                            + "&grant_type=authorization_code"))
                    .build();

            String jsonToken = http.send(pedidoToken, HttpResponse.BodyHandlers.ofString()).body();

            String token = lerJson(jsonToken, "access_token");

            if (token == null) {
                throw new Exception("O Google recusou o login:\n" + jsonToken);
            }


            // BUSCA NOME E E-MAIL

            HttpRequest pedidoDados = HttpRequest.newBuilder(
                            URI.create("https://openidconnect.googleapis.com/v1/userinfo"))
                    .header("Authorization", "Bearer " + token)
                    .build();

            String jsonDados = http.send(pedidoDados, HttpResponse.BodyHandlers.ofString()).body();

            String nome = lerJson(jsonDados, "name");
            String email = lerJson(jsonDados, "email");

            if (nome == null) {
                nome = email;
            }

            // A senha é aleatória: essa conta só entra pelo Google
            return new Usuario(nome, email, UUID.randomUUID().toString(), 0);

        } finally {

            servidor.stop(0);
        }
    }


    private static String codificar(String texto) {
        return URLEncoder.encode(texto, StandardCharsets.UTF_8);
    }


    // Pega um valor de "a=1&b=2"
    private static String lerParametro(String query, String nome) {

        Matcher m = Pattern.compile("(?:^|&)" + nome + "=([^&]*)").matcher(query == null ? "" : query);

        return m.find() ? java.net.URLDecoder.decode(m.group(1), StandardCharsets.UTF_8) : null;
    }


    // Pega um valor de texto de um JSON: "campo": "valor"
    private static String lerJson(String json, String campo) {

        Matcher m = Pattern.compile("\"" + campo + "\"\\s*:\\s*\"([^\"]*)\"").matcher(json);

        return m.find() ? m.group(1) : null;
    }
}
