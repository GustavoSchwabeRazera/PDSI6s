package util;

/**
 * UTIL - as informacoes do software, num lugar so.
 *
 * A janela "Sobre" le tudo daqui. Para trocar o nome de um autor ou a
 * versao, muda-se este arquivo e mais nada.
 */
public final class InfoApp {

	private InfoApp() { } // so constantes: ninguem cria objeto desta classe

	public static final String NOME = "TrainUp";
	public static final String VERSAO = "1.0";
	public static final String DESCRICAO = "Organize seus treinos e exercícios de academia.";

	public static final String[] AUTORES = {
			"Gustavo Schwabe Razera"
	};
	public static final String PROFESSOR = "Timoteo Monteiro Da Silva";

	public static final String INSTITUICAO = "IFSC - Câmpus Gaspar";
	public static final String DISCIPLINA = "Práticas em Desenvolvimento de Sistemas II";
	public static final String ANO = "2026";
	public static final String TECNOLOGIAS = "Java (Swing + MigLayout), padrão MVC, MySQL (JDBC), login com Google";
}
