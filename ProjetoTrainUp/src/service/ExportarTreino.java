package service;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;

import model.Exercicio;
import model.Treino;

/**
 * Gera uma imagem PNG com as informacoes de um treino (nome, aluno, data e a
 * tabela de exercicios), nas cores do logo do TrainUp.
 */
public class ExportarTreino {

	private static final Color AZUL_ESCURO = new Color(11, 42, 91);
	private static final Color CIANO = new Color(30, 200, 230);
	private static final Color CIANO_CLARO = new Color(230, 250, 253);
	private static final Color CINZA = new Color(110, 110, 120);
	private static final Color BRANCO = Color.WHITE;

	private static final int LARGURA = 800;
	private static final int MARGEM = 40;
	private static final int ALTURA_LINHA = 44;

	// colunas da tabela: x de inicio de cada uma
	private static final int COL_NUMERO = MARGEM + 16;
	private static final int COL_NOME = MARGEM + 64;
	private static final int COL_SERIES = LARGURA - MARGEM - 250;
	private static final int COL_REPETICOES = LARGURA - MARGEM - 130;

	public static void salvarPng(Treino treino, List<Exercicio> exercicios, String nomeUsuario, File arquivo)
			throws IOException {
		ImageIO.write(gerarImagem(treino, exercicios, nomeUsuario), "png", arquivo);
	}

	public static BufferedImage gerarImagem(Treino treino, List<Exercicio> exercicios, String nomeUsuario) {
		int linhas = Math.max(exercicios.size(), 1);
		int inicioTabela = 250;
		int altura = inicioTabela + ALTURA_LINHA * (linhas + 1) + 90;

		BufferedImage img = new BufferedImage(LARGURA, altura, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = img.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		// fundo
		g.setColor(BRANCO);
		g.fillRect(0, 0, LARGURA, altura);

		// cabecalho: logo + nome do app
		Image logo = carregarLogo();
		if (logo != null) {
			g.drawImage(logo, MARGEM, 24, 90, 90, null);
		}
		g.setColor(AZUL_ESCURO);
		g.setFont(new Font("Tahoma", Font.BOLD, 34));
		g.drawString("TrainUp", MARGEM + 110, 70);
		g.setColor(CINZA);
		g.setFont(new Font("Tahoma", Font.PLAIN, 16));
		g.drawString("Ficha de treino", MARGEM + 112, 96);

		// linha ciano separando o cabecalho
		g.setColor(CIANO);
		g.setStroke(new BasicStroke(4));
		g.drawLine(MARGEM, 135, LARGURA - MARGEM, 135);

		// nome do treino, aluno e data
		g.setColor(AZUL_ESCURO);
		g.setFont(new Font("Tahoma", Font.BOLD, 30));
		g.drawString(cortar(g, treino.getNome(), LARGURA - 2 * MARGEM), MARGEM, 185);

		String data = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		String info = (nomeUsuario != null ? "Aluno: " + nomeUsuario + "     " : "") + "Exportado em " + data;
		g.setColor(CINZA);
		g.setFont(new Font("Tahoma", Font.PLAIN, 16));
		g.drawString(cortar(g, info, LARGURA - 2 * MARGEM), MARGEM, 215);

		// cabecalho da tabela
		int y = inicioTabela;
		g.setColor(AZUL_ESCURO);
		g.fillRoundRect(MARGEM, y, LARGURA - 2 * MARGEM, ALTURA_LINHA, 12, 12);
		g.setColor(BRANCO);
		g.setFont(new Font("Tahoma", Font.BOLD, 16));
		int base = y + 28;
		g.drawString("#", COL_NUMERO, base);
		g.drawString("Exercício", COL_NOME, base);
		g.drawString("Séries", COL_SERIES, base);
		g.drawString("Repetições", COL_REPETICOES, base);

		// linhas da tabela
		g.setFont(new Font("Tahoma", Font.PLAIN, 16));
		if (exercicios.isEmpty()) {
			y += ALTURA_LINHA;
			g.setColor(CINZA);
			g.drawString("Nenhum exercício cadastrado neste treino.", COL_NOME, y + 28);
		}
		for (int i = 0; i < exercicios.size(); i++) {
			Exercicio ex = exercicios.get(i);
			y += ALTURA_LINHA;
			if (i % 2 == 1) {
				g.setColor(CIANO_CLARO);
				g.fillRect(MARGEM, y, LARGURA - 2 * MARGEM, ALTURA_LINHA);
			}
			base = y + 28;
			g.setColor(CIANO);
			g.setFont(new Font("Tahoma", Font.BOLD, 16));
			g.drawString(String.valueOf(i + 1), COL_NUMERO, base);
			g.setColor(AZUL_ESCURO);
			g.setFont(new Font("Tahoma", Font.PLAIN, 16));
			g.drawString(cortar(g, ex.getNome(), COL_SERIES - COL_NOME - 20), COL_NOME, base);
			g.drawString(String.valueOf(ex.getSeries()), COL_SERIES, base);
			g.drawString(String.valueOf(ex.getRepeticoes()), COL_REPETICOES, base);
		}

		// borda da tabela
		g.setColor(CIANO);
		g.setStroke(new BasicStroke(2));
		g.drawRoundRect(MARGEM, inicioTabela, LARGURA - 2 * MARGEM, y + ALTURA_LINHA - inicioTabela, 12, 12);

		// resumo no rodape
		int totalSeries = 0;
		for (Exercicio ex : exercicios) {
			totalSeries += ex.getSeries();
		}
		g.setColor(CINZA);
		g.setFont(new Font("Tahoma", Font.PLAIN, 15));
		g.drawString(exercicios.size() + " exercício(s)   •   " + totalSeries + " séries no total",
				MARGEM, y + ALTURA_LINHA + 45);

		g.dispose();
		return img;
	}

	private static Image carregarLogo() {
		try {
			URL url = ExportarTreino.class.getResource("/images/icone.png");
			return url != null ? ImageIO.read(url) : null;
		} catch (IOException e) {
			return null;
		}
	}

	// corta o texto com "..." se nao couber na largura
	private static String cortar(Graphics2D g, String texto, int larguraMax) {
		FontMetrics fm = g.getFontMetrics();
		if (fm.stringWidth(texto) <= larguraMax) {
			return texto;
		}
		while (texto.length() > 0 && fm.stringWidth(texto + "...") > larguraMax) {
			texto = texto.substring(0, texto.length() - 1);
		}
		return texto + "...";
	}
}
