package controller;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import dao.ExercicioDAO;
import dao.TreinoDAO;
import dao.UsuarioDAO;
import model.Exercicio;
import model.Treino;
import model.Usuario;
import service.GoogleAuth;
import view.TelaAdicionarExercicio;
import view.TelaCadastro;
import view.TelaCriarTreino;
import view.TelaDetalhesTreino;
import view.TelaHome;
import view.TelaInicial;
import view.TelaLogin;
import view.TelaTreinos;

public class controller {

	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private TreinoDAO treinoDAO = new TreinoDAO();
	private ExercicioDAO exercicioDAO = new ExercicioDAO();

	private JFrame telaAtual;

	private TelaLogin telaLogin;
	private TelaCadastro telaCadastro;
	private TelaTreinos telaTreinos;
	private TelaCriarTreino telaCriarTreino;
	private TelaDetalhesTreino telaDetalhesTreino;
	private TelaAdicionarExercicio telaExercicio;

	private Usuario usuarioLogado;
	private Treino treinoSelecionado;
	private Exercicio exercicioEditando;

	public controller() {
		abrirTelaInicial();
	}

	// Fecha a tela atual e mostra a nova
	private void mostrar(JFrame tela) {
		if (telaAtual != null) {
			telaAtual.dispose();
		}
		telaAtual = tela;
		tela.setVisible(true);
	}

	// =============================================
	// ABRIR TELAS
	// =============================================

	private void abrirTelaInicial() {
		TelaInicial tela = new TelaInicial();
		tela.getBtnEntrar().addActionListener(e -> abrirTelaLogin());
		tela.getBtnCadastrar().addActionListener(e -> abrirTelaCadastro());
		tela.getBtnSair().addActionListener(e -> System.exit(0));
		mostrar(tela);
	}

	private void abrirTelaLogin() {
		telaLogin = new TelaLogin();
		telaLogin.getBtnEntrar().addActionListener(e -> fazerLogin());
		telaLogin.getBtnEntrarGoogle().addActionListener(e -> fazerLoginGoogle());
		telaLogin.getBtnCadastrar().addActionListener(e -> abrirTelaCadastro());
		telaLogin.getBtnVoltar().addActionListener(e -> abrirTelaInicial());
		mostrar(telaLogin);
	}

	private void abrirTelaCadastro() {
		telaCadastro = new TelaCadastro();
		telaCadastro.getBtnCadastrar().addActionListener(e -> cadastrarUsuario());
		telaCadastro.getBtnVoltar().addActionListener(e -> abrirTelaInicial());
		mostrar(telaCadastro);
	}

	private void abrirTelaHome() {
		TelaHome tela = new TelaHome();
		tela.setNomeUsuario(usuarioLogado.getNome());
		tela.getBtnTreinos().addActionListener(e -> abrirTelaTreinos());
		tela.getBtnSair().addActionListener(e -> {
			usuarioLogado = null;
			abrirTelaInicial();
		});
		mostrar(tela);
	}

	private void abrirTelaTreinos() {
		telaTreinos = new TelaTreinos();
		telaTreinos.getBtnNovoTreino().addActionListener(e -> abrirTelaCriarTreino());
		telaTreinos.getBtnAbrir().addActionListener(e -> abrirTelaDetalhesTreino(telaTreinos.getTreinoSelecionado()));
		telaTreinos.getBtnExcluir().addActionListener(e -> excluirTreino());
		telaTreinos.getBtnVoltar().addActionListener(e -> abrirTelaHome());

		try {
			for (Treino treino : treinoDAO.listarPorUsuario(usuarioLogado.getId())) {
				telaTreinos.adicionarTreino(treino);
			}
		} catch (SQLException erro) {
			erroBanco(erro);
		}

		mostrar(telaTreinos);
	}

	private void abrirTelaCriarTreino() {
		telaCriarTreino = new TelaCriarTreino();
		telaCriarTreino.getBtnSalvar().addActionListener(e -> salvarTreino());
		telaCriarTreino.getBtnVoltar().addActionListener(e -> abrirTelaTreinos());
		mostrar(telaCriarTreino);
	}

	private void abrirTelaDetalhesTreino(Treino treino) {
		if (treino == null) {
			JOptionPane.showMessageDialog(telaAtual, "Selecione um treino.");
			return;
		}

		treinoSelecionado = treino;

		telaDetalhesTreino = new TelaDetalhesTreino(treino);
		telaDetalhesTreino.getBtnAdicionarExercicio().addActionListener(e -> abrirTelaExercicio(null));
		telaDetalhesTreino.getBtnEditar().addActionListener(e -> editarExercicio());
		telaDetalhesTreino.getBtnExcluir().addActionListener(e -> excluirExercicio());
		telaDetalhesTreino.getBtnVoltar().addActionListener(e -> abrirTelaTreinos());

		try {
			for (Exercicio exercicio : exercicioDAO.listarPorTreino(treino.getId())) {
				telaDetalhesTreino.adicionarExercicio(exercicio);
			}
		} catch (SQLException erro) {
			erroBanco(erro);
		}

		mostrar(telaDetalhesTreino);
	}

	// exercicio == null: novo exercício / senão: editar
	private void abrirTelaExercicio(Exercicio exercicio) {
		exercicioEditando = exercicio;

		telaExercicio = new TelaAdicionarExercicio();

		if (exercicio != null) {
			telaExercicio.getTxtNome().setText(exercicio.getNome());
			telaExercicio.getTxtSeries().setText(String.valueOf(exercicio.getSeries()));
			telaExercicio.getTxtRepeticoes().setText(String.valueOf(exercicio.getRepeticoes()));
			telaExercicio.getBtnSalvar().setText("Salvar alterações");
		}

		telaExercicio.getBtnSalvar().addActionListener(e -> salvarExercicio());
		telaExercicio.getBtnVoltar().addActionListener(e -> abrirTelaDetalhesTreino(treinoSelecionado));
		mostrar(telaExercicio);
	}

	// =============================================
	// USUÁRIO
	// =============================================

	private void fazerLogin() {
		String email = telaLogin.getTxtEmail().getText().trim();
		String senha = new String(telaLogin.getTxtSenha().getPassword());

		if (email.isEmpty() || senha.isEmpty()) {
			JOptionPane.showMessageDialog(telaLogin, "Preencha o e-mail e a senha.");
			return;
		}

		try {
			Usuario usuario = usuarioDAO.buscarPorEmail(email);

			if (usuario == null || !usuario.getSenha().equals(senha)) {
				JOptionPane.showMessageDialog(telaLogin, "E-mail ou senha incorretos.");
				return;
			}

			usuarioLogado = usuario;
			abrirTelaHome();
		} catch (SQLException erro) {
			erroBanco(erro);
		}
	}

	private void fazerLoginGoogle() {
		telaLogin.getBtnEntrarGoogle().setEnabled(false);

		// O login acontece no navegador: roda em outra thread para a tela não travar
		new Thread(() -> {
			try {
				Usuario conta = GoogleAuth.login();
				Usuario usuario = usuarioDAO.buscarPorEmail(conta.getEmail());

				// Primeiro acesso: cadastra o usuário
				if (usuario == null) {
					usuarioDAO.inserir(conta);
					usuario = conta;
				}

				Usuario logado = usuario;

				SwingUtilities.invokeLater(() -> {
					usuarioLogado = logado;
					abrirTelaHome();
				});
			} catch (Exception erro) {
				SwingUtilities.invokeLater(() -> {
					JOptionPane.showMessageDialog(telaLogin, "Não foi possível entrar com o Google.\n" + erro.getMessage());
					telaLogin.getBtnEntrarGoogle().setEnabled(true);
				});
			}
		}).start();
	}

	private void cadastrarUsuario() {
		String nome = telaCadastro.getTxtNome().getText().trim();
		String email = telaCadastro.getTxtEmail().getText().trim();
		String idadeTexto = telaCadastro.getTxtIdade().getText().trim();
		String senha = new String(telaCadastro.getTxtSenha().getPassword());
		String confirmarSenha = new String(telaCadastro.getTxtConfirmarSenha().getPassword());

		if (nome.isEmpty() || email.isEmpty() || idadeTexto.isEmpty() || senha.isEmpty()) {
			JOptionPane.showMessageDialog(telaCadastro, "Preencha todos os campos.");
			return;
		}

		if (senha.length() < 6) {
			JOptionPane.showMessageDialog(telaCadastro, "A senha deve ter pelo menos 6 caracteres.");
			return;
		}

		if (!senha.equals(confirmarSenha)) {
			JOptionPane.showMessageDialog(telaCadastro, "As senhas não são iguais.");
			return;
		}

		try {
			int idade = Integer.parseInt(idadeTexto);

			if (idade <= 0 || idade > 120) {
				JOptionPane.showMessageDialog(telaCadastro, "Digite uma idade válida.");
				return;
			}

			if (usuarioDAO.buscarPorEmail(email) != null) {
				JOptionPane.showMessageDialog(telaCadastro, "Este e-mail já está cadastrado.");
				return;
			}

			usuarioDAO.inserir(new Usuario(nome, email, senha, idade));

			JOptionPane.showMessageDialog(telaCadastro, "Cadastro realizado com sucesso!");
			abrirTelaLogin();
		} catch (NumberFormatException erro) {
			JOptionPane.showMessageDialog(telaCadastro, "A idade deve conter apenas números.");
		} catch (SQLException erro) {
			erroBanco(erro);
		}
	}

	// =============================================
	// TREINOS
	// =============================================

	private void salvarTreino() {
		String nome = telaCriarTreino.getTxtNome().getText().trim();

		if (nome.isEmpty()) {
			JOptionPane.showMessageDialog(telaCriarTreino, "Digite o nome do treino.");
			return;
		}

		try {
			treinoDAO.inserir(new Treino(nome, usuarioLogado.getId()));
			abrirTelaTreinos();
		} catch (SQLException erro) {
			erroBanco(erro);
		}
	}

	private void excluirTreino() {
		Treino treino = telaTreinos.getTreinoSelecionado();

		if (treino == null) {
			JOptionPane.showMessageDialog(telaTreinos, "Selecione um treino.");
			return;
		}

		if (!confirmar("Deseja excluir o treino \"" + treino.getNome() + "\"?")) {
			return;
		}

		try {
			treinoDAO.excluir(treino.getId());
			abrirTelaTreinos();
		} catch (SQLException erro) {
			erroBanco(erro);
		}
	}

	// =============================================
	// EXERCÍCIOS
	// =============================================

	private void editarExercicio() {
		Exercicio exercicio = telaDetalhesTreino.getExercicioSelecionado();

		if (exercicio == null) {
			JOptionPane.showMessageDialog(telaDetalhesTreino, "Selecione um exercício.");
			return;
		}

		abrirTelaExercicio(exercicio);
	}

	private void salvarExercicio() {
		String nome = telaExercicio.getTxtNome().getText().trim();

		if (nome.isEmpty()) {
			JOptionPane.showMessageDialog(telaExercicio, "Digite o nome do exercício.");
			return;
		}

		try {
			int series = Integer.parseInt(telaExercicio.getTxtSeries().getText().trim());
			int repeticoes = Integer.parseInt(telaExercicio.getTxtRepeticoes().getText().trim());

			if (series <= 0 || repeticoes <= 0) {
				JOptionPane.showMessageDialog(telaExercicio, "Séries e repetições devem ser maiores que zero.");
				return;
			}

			if (exercicioEditando == null) {
				exercicioDAO.inserir(new Exercicio(nome, series, repeticoes, treinoSelecionado.getId()));
			} else {
				exercicioEditando.setNome(nome);
				exercicioEditando.setSeries(series);
				exercicioEditando.setRepeticoes(repeticoes);
				exercicioDAO.alterar(exercicioEditando);
			}

			abrirTelaDetalhesTreino(treinoSelecionado);
		} catch (NumberFormatException erro) {
			JOptionPane.showMessageDialog(telaExercicio, "Séries e repetições devem ser números.");
		} catch (SQLException erro) {
			erroBanco(erro);
		}
	}

	private void excluirExercicio() {
		Exercicio exercicio = telaDetalhesTreino.getExercicioSelecionado();

		if (exercicio == null) {
			JOptionPane.showMessageDialog(telaDetalhesTreino, "Selecione um exercício.");
			return;
		}

		if (!confirmar("Deseja excluir \"" + exercicio.getNome() + "\"?")) {
			return;
		}

		try {
			exercicioDAO.excluir(exercicio.getId());
			abrirTelaDetalhesTreino(treinoSelecionado);
		} catch (SQLException erro) {
			erroBanco(erro);
		}
	}

	// =============================================
	// AUXILIARES
	// =============================================

	private boolean confirmar(String pergunta) {
		return JOptionPane.showConfirmDialog(telaAtual, pergunta, "Confirmar", JOptionPane.YES_NO_OPTION)
				== JOptionPane.YES_OPTION;
	}

	private void erroBanco(SQLException erro) {
		JOptionPane.showMessageDialog(telaAtual, "Erro no banco de dados:\n" + erro.getMessage());
		erro.printStackTrace();
	}
}
