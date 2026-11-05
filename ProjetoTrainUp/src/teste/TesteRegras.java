package teste;

import model.Exercicio;
import model.Treino;
import model.Usuario;

/**
 * TESTE - confere as regras de validar() dos models.
 *
 * Roda sem abrir janela e sem precisar do banco. A duplicidade de e-mail
 * depende do banco e por isso nao esta aqui: teste pela tela de cadastro.
 */
public class TesteRegras {

	private static int numero = 0;
	private static int falhas = 0;

	public static void main(String[] args) {
		System.out.println("=== Usuario ===");
		aceita("usuario valido", () -> usuario("Ana", "ana@email.com", "123456", 25));
		aceita("nome com apostrofo (O'Brien)", () -> usuario("O'Brien", "ob@email.com", "123456", 25));
		aceita("nome com acento (João)", () -> usuario("João", "joao@email.com", "123456", 25));
		recusa("nome vazio", "Preencha todos os campos.", () -> usuario("", "ana@email.com", "123456", 25));
		recusa("nome so com espacos", "Preencha todos os campos.", () -> usuario("   ", "ana@email.com", "123456", 25));
		recusa("nome nulo", "Preencha todos os campos.", () -> usuario(null, "ana@email.com", "123456", 25));
		recusa("e-mail vazio", "Preencha todos os campos.", () -> usuario("Ana", "", "123456", 25));
		recusa("senha vazia", "Preencha todos os campos.", () -> usuario("Ana", "ana@email.com", "", 25));
		recusa("senha com 5 caracteres", "A senha deve ter pelo menos 6 caracteres.", () -> usuario("Ana", "ana@email.com", "12345", 25));
		aceita("senha com 6 caracteres", () -> usuario("Ana", "ana@email.com", "123456", 25));
		recusa("idade 0", "Digite uma idade válida.", () -> usuario("Ana", "ana@email.com", "123456", 0));
		recusa("idade negativa", "Digite uma idade válida.", () -> usuario("Ana", "ana@email.com", "123456", -1));
		aceita("idade 1 (limite menor)", () -> usuario("Ana", "ana@email.com", "123456", 1));
		aceita("idade 120 (limite maior)", () -> usuario("Ana", "ana@email.com", "123456", 120));
		recusa("idade 121", "Digite uma idade válida.", () -> usuario("Ana", "ana@email.com", "123456", 121));

		System.out.println("=== Treino ===");
		aceita("treino valido", () -> new Treino("Treino A", 1).validar());
		recusa("treino sem nome", "Digite o nome do treino.", () -> new Treino("", 1).validar());
		recusa("treino com nome nulo", "Digite o nome do treino.", () -> new Treino(null, 1).validar());

		System.out.println("=== Exercicio ===");
		aceita("exercicio valido", () -> new Exercicio("Supino", 3, 12, 1).validar());
		aceita("1 serie e 1 repeticao (limite)", () -> new Exercicio("Supino", 1, 1, 1).validar());
		recusa("exercicio sem nome", "Digite o nome do exercício.", () -> new Exercicio("", 3, 12, 1).validar());
		recusa("0 series", "Séries e repetições devem ser maiores que zero.", () -> new Exercicio("Supino", 0, 12, 1).validar());
		recusa("repeticoes negativas", "Séries e repetições devem ser maiores que zero.", () -> new Exercicio("Supino", 3, -1, 1).validar());

		System.out.println();
		System.out.println((numero - falhas) + " de " + numero + " testes passaram.");

		if (falhas > 0) {
			System.exit(1); // avisa quem rodou pelo terminal que houve falha
		}
	}

	private static void usuario(String nome, String email, String senha, int idade) {
		new Usuario(nome, email, senha, idade).validar();
	}

	private static void aceita(String caso, Runnable regra) {
		try {
			regra.run();
			registrar(caso, true, "aceito");
		} catch (IllegalArgumentException erro) {
			registrar(caso, false, "recusado: " + erro.getMessage());
		}
	}

	private static void recusa(String caso, String mensagemEsperada, Runnable regra) {
		try {
			regra.run();
			registrar(caso, false, "aceito, mas deveria recusar");
		} catch (IllegalArgumentException erro) {
			registrar(caso, mensagemEsperada.equals(erro.getMessage()), "recusado: " + erro.getMessage());
		}
	}

	private static void registrar(String caso, boolean passou, String obtido) {
		numero++;
		if (!passou) {
			falhas++;
		}
		System.out.printf("T%02d [%s] %s -> %s%n", numero, passou ? "OK" : "FALHOU", caso, obtido);
	}
}
