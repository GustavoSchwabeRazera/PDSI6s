package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

import java.time.LocalDateTime;

import java.util.List;

import javax.swing.JOptionPane;

import dao.ExercicioDAO;
import dao.RegistroDAO;
import dao.TreinoDAO;
import dao.UsuarioDAO;

import model.Exercicio;
import model.Registro;
import model.Treino;
import model.Usuario;

import view.TelaAdicionarExercicio;
import view.TelaCadastro;
import view.TelaCriarTreino;
import view.TelaDetalhesTreino;
import view.TelaExercicios;
import view.TelaHome;
import view.TelaInicial;
import view.TelaLogin;
import view.TelaProgresso;
import view.TelaTreinos;

public class controller
        implements ActionListener {


    // =============================================
    // TELAS
    // =============================================

    private TelaInicial telaInicial;

    private TelaLogin telaLogin;

    private TelaCadastro telaCadastro;

    private TelaHome telaHome;

    private TelaTreinos telaTreinos;

    private TelaCriarTreino telaCriarTreino;

    private TelaDetalhesTreino telaDetalhesTreino;

    private TelaAdicionarExercicio telaAdicionarExercicio;

    private TelaExercicios telaExercicios;

    private TelaProgresso telaProgresso;


    // =============================================
    // DAOS
    // =============================================

    private UsuarioDAO usuarioDAO;

    private TreinoDAO treinoDAO;

    private ExercicioDAO exercicioDAO;

    private RegistroDAO registroDAO;


    // =============================================
    // OBJETOS ATUAIS
    // =============================================

    private Usuario usuarioLogado;

    private Treino treinoSelecionado;

    private Exercicio exercicioEditando;


    // =============================================
    // CONSTRUTOR
    // =============================================

    public controller() {

        usuarioDAO =
                new UsuarioDAO();

        treinoDAO =
                new TreinoDAO();

        exercicioDAO =
                new ExercicioDAO();

        registroDAO =
                new RegistroDAO();


        abrirTelaInicial();
    }


    // =============================================
    // TELA INICIAL
    // =============================================

    private void abrirTelaInicial() {

        fecharTelas();


        telaInicial =
                new TelaInicial();


        telaInicial
                .getBtnEntrar()
                .addActionListener(this);


        telaInicial
                .getBtnCadastrar()
                .addActionListener(this);


        telaInicial
                .getBtnSair()
                .addActionListener(this);


        telaInicial.setVisible(
                true
        );
    }


    // =============================================
    // LOGIN
    // =============================================

    private void abrirTelaLogin() {

        fecharTelas();


        telaLogin =
                new TelaLogin();


        telaLogin
                .getBtnEntrar()
                .addActionListener(this);


        telaLogin
                .getBtnCadastrar()
                .addActionListener(this);


        telaLogin
                .getBtnVoltar()
                .addActionListener(this);


        telaLogin.setVisible(
                true
        );
    }


    // =============================================
    // CADASTRO
    // =============================================

    private void abrirTelaCadastro() {

        fecharTelas();


        telaCadastro =
                new TelaCadastro();


        telaCadastro
                .getBtnCadastrar()
                .addActionListener(this);


        telaCadastro
                .getBtnVoltar()
                .addActionListener(this);


        telaCadastro.setVisible(
                true
        );
    }


    // =============================================
    // HOME
    // =============================================

    private void abrirTelaHome(
            Usuario usuario
    ) {

        fecharTelas();


        telaHome =
                new TelaHome();


        telaHome.setNomeUsuario(
                usuario.getNome()
        );


        telaHome
                .getBtnTreinos()
                .addActionListener(this);


        telaHome
                .getBtnExercicios()
                .addActionListener(this);


        telaHome
                .getBtnProgresso()
                .addActionListener(this);


        telaHome
                .getBtnSair()
                .addActionListener(this);


        telaHome.setVisible(
                true
        );
    }


    // =============================================
    // TREINOS
    // =============================================

    private void abrirTelaTreinos() {

        if (usuarioLogado == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum usuário está logado."
            );


            abrirTelaLogin();

            return;
        }


        fecharTelas();


        treinoSelecionado = null;


        telaTreinos =
                new TelaTreinos();


        telaTreinos
                .getBtnNovoTreino()
                .addActionListener(this);


        telaTreinos
                .getBtnAbrir()
                .addActionListener(this);


        telaTreinos
                .getBtnExcluir()
                .addActionListener(this);


        telaTreinos
                .getBtnVoltar()
                .addActionListener(this);


        telaTreinos.setVisible(
                true
        );


        carregarTreinos();
    }


    // =============================================
    // CRIAR TREINO
    // =============================================

    private void abrirTelaCriarTreino() {

        fecharTelas();


        telaCriarTreino =
                new TelaCriarTreino();


        telaCriarTreino
                .getBtnSalvar()
                .addActionListener(this);


        telaCriarTreino
                .getBtnVoltar()
                .addActionListener(this);


        telaCriarTreino.setVisible(
                true
        );
    }


    // =============================================
    // DETALHES DO TREINO
    // =============================================

    private void abrirTelaDetalhesTreino(
            Treino treino
    ) {

        if (treino == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Nenhum treino selecionado."
            );

            return;
        }


        treinoSelecionado =
                treino;


        fecharTelas();


        telaDetalhesTreino =
                new TelaDetalhesTreino(
                        treinoSelecionado
                );


        telaDetalhesTreino
                .getBtnAdicionarExercicio()
                .addActionListener(this);


        telaDetalhesTreino
                .getBtnConcluir()
                .addActionListener(this);


        telaDetalhesTreino
                .getBtnEditar()
                .addActionListener(this);


        telaDetalhesTreino
                .getBtnExcluir()
                .addActionListener(this);


        telaDetalhesTreino
                .getBtnVoltar()
                .addActionListener(this);


        telaDetalhesTreino.setVisible(
                true
        );


        carregarExercicios();
    }


    // =============================================
    // ADICIONAR EXERCÍCIO
    // =============================================

    private void abrirTelaAdicionarExercicio() {

        exercicioEditando =
                null;


        fecharTelas();


        telaAdicionarExercicio =
                new TelaAdicionarExercicio();


        telaAdicionarExercicio
                .getBtnSalvar()
                .addActionListener(this);


        telaAdicionarExercicio
                .getBtnVoltar()
                .addActionListener(this);


        telaAdicionarExercicio.setVisible(
                true
        );
    }


    // =============================================
    // EDITAR EXERCÍCIO
    // =============================================

    private void abrirTelaEditarExercicio(
            Exercicio exercicio
    ) {

        if (exercicio == null) {

            JOptionPane.showMessageDialog(
                    telaDetalhesTreino,
                    "Selecione um exercício."
            );

            return;
        }


        exercicioEditando =
                exercicio;


        fecharTelas();


        telaAdicionarExercicio =
                new TelaAdicionarExercicio();


        telaAdicionarExercicio
                .getTxtNome()
                .setText(
                        exercicio.getNome()
                );


        telaAdicionarExercicio
                .getTxtSeries()
                .setText(
                        String.valueOf(
                                exercicio.getSeries()
                        )
                );


        telaAdicionarExercicio
                .getTxtRepeticoes()
                .setText(
                        String.valueOf(
                                exercicio.getRepeticoes()
                        )
                );


        telaAdicionarExercicio
                .getBtnSalvar()
                .setText(
                        "SALVAR ALTERAÇÕES"
                );


        telaAdicionarExercicio
                .getBtnSalvar()
                .addActionListener(this);


        telaAdicionarExercicio
                .getBtnVoltar()
                .addActionListener(this);


        telaAdicionarExercicio.setVisible(
                true
        );
    }


    // =============================================
    // EXERCÍCIOS (todos os exercícios do usuário)
    // =============================================

    private void abrirTelaExercicios() {

        fecharTelas();


        telaExercicios =
                new TelaExercicios();


        telaExercicios
                .getBtnAbrirTreino()
                .addActionListener(this);


        telaExercicios
                .getBtnVoltar()
                .addActionListener(this);


        telaExercicios.setVisible(
                true
        );


        try {

            telaExercicios.setExercicios(
                    exercicioDAO.listarPorUsuario(
                            usuarioLogado.getId()
                    )
            );


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaExercicios,
                    "Erro ao carregar exercícios:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // ABRIR O TREINO DO EXERCÍCIO SELECIONADO
    // =============================================

    private void abrirTreinoDoExercicio() {

        Exercicio exercicio =
                telaExercicios
                        .getExercicioSelecionado();


        if (exercicio == null) {

            JOptionPane.showMessageDialog(
                    telaExercicios,
                    "Selecione um exercício."
            );

            return;
        }


        try {

            Treino treino =
                    treinoDAO.buscarPorId(
                            exercicio.getTreinoId()
                    );


            abrirTelaDetalhesTreino(
                    treino
            );


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaExercicios,
                    "Erro ao abrir treino:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // PROGRESSO
    // =============================================

    private void abrirTelaProgresso() {

        fecharTelas();


        telaProgresso =
                new TelaProgresso();


        telaProgresso
                .getBtnVoltar()
                .addActionListener(this);


        telaProgresso.setVisible(
                true
        );


        try {

            int treinos =
                    treinoDAO.listarPorUsuario(
                            usuarioLogado.getId()
                    ).size();


            int exercicios =
                    exercicioDAO.listarPorUsuario(
                            usuarioLogado.getId()
                    ).size();


            List<Registro> registros =
                    registroDAO.listarPorUsuario(
                            usuarioLogado.getId()
                    );


            // Treinos concluídos nos últimos 7 dias

            LocalDateTime semanaPassada =
                    LocalDateTime.now().minusDays(7);

            int semana = 0;

            for (Registro registro : registros) {

                if (registro.getData()
                        .isAfter(semanaPassada)) {

                    semana++;
                }
            }


            telaProgresso.setResumo(
                    treinos,
                    exercicios,
                    registros.size(),
                    semana
            );


            telaProgresso.limparHistorico();


            for (Registro registro : registros) {

                telaProgresso.adicionarRegistro(
                        registro
                );
            }


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaProgresso,
                    "Erro ao carregar progresso:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // CONCLUIR TREINO
    // =============================================

    private void concluirTreino() {

        int resposta =
                JOptionPane.showConfirmDialog(
                        telaDetalhesTreino,
                        "Marcar o treino \""
                                + treinoSelecionado.getNome()
                                + "\" como concluído hoje?",
                        "Concluir treino",
                        JOptionPane.YES_NO_OPTION
                );


        if (resposta
                != JOptionPane.YES_OPTION) {

            return;
        }


        try {

            registroDAO.inserir(
                    new Registro(
                            treinoSelecionado.getId()
                    )
            );


            JOptionPane.showMessageDialog(
                    telaDetalhesTreino,
                    "Treino concluído! Veja sua evolução em PROGRESSO."
            );


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaDetalhesTreino,
                    "Erro ao concluir treino:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // CARREGAR TREINOS
    // =============================================

    private void carregarTreinos() {

        if (telaTreinos == null
                || usuarioLogado == null) {

            return;
        }


        try {

            List<Treino> treinos =
                    treinoDAO.listarPorUsuario(
                            usuarioLogado.getId()
                    );


            telaTreinos.limparTreinos();


            for (Treino treino : treinos) {

                telaTreinos.adicionarTreino(
                        treino
                );
            }


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaTreinos,
                    "Erro ao carregar treinos:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // CARREGAR EXERCÍCIOS
    // =============================================

    private void carregarExercicios() {

        if (telaDetalhesTreino == null
                || treinoSelecionado == null) {

            return;
        }


        try {

            List<Exercicio> exercicios =
                    exercicioDAO.listarPorTreino(
                            treinoSelecionado.getId()
                    );


            telaDetalhesTreino
                    .limparExercicios();


            for (Exercicio exercicio
                    : exercicios) {

                telaDetalhesTreino
                        .adicionarExercicio(
                                exercicio
                        );
            }


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaDetalhesTreino,
                    "Erro ao carregar exercícios:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // SALVAR TREINO
    // =============================================

    private void salvarTreino() {

        String nome =
                telaCriarTreino
                        .getTxtNome()
                        .getText()
                        .trim();


        if (nome.isEmpty()) {

            JOptionPane.showMessageDialog(
                    telaCriarTreino,
                    "Digite o nome do treino."
            );

            return;
        }


        if (usuarioLogado == null) {

            JOptionPane.showMessageDialog(
                    telaCriarTreino,
                    "Nenhum usuário está logado."
            );

            abrirTelaLogin();

            return;
        }


        Treino treino =
                new Treino(
                        nome,
                        usuarioLogado.getId()
                );


        try {

            treinoDAO.inserir(
                    treino
            );


            JOptionPane.showMessageDialog(
                    telaCriarTreino,
                    "Treino criado com sucesso!"
            );


            abrirTelaTreinos();


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaCriarTreino,
                    "Erro ao salvar treino:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // EXCLUIR TREINO
    // =============================================

    private void excluirTreino() {

        Treino treino =
                telaTreinos
                        .getTreinoSelecionado();


        if (treino == null) {

            JOptionPane.showMessageDialog(
                    telaTreinos,
                    "Selecione um treino para excluir."
            );

            return;
        }


        int resposta =
                JOptionPane.showConfirmDialog(
                        telaTreinos,
                        "Deseja excluir o treino \""
                                + treino.getNome()
                                + "\"?",
                        "Excluir treino",
                        JOptionPane.YES_NO_OPTION
                );


        if (resposta
                != JOptionPane.YES_OPTION) {

            return;
        }


        try {

            treinoDAO.excluir(
                    treino.getId()
            );


            JOptionPane.showMessageDialog(
                    telaTreinos,
                    "Treino excluído com sucesso!"
            );


            carregarTreinos();


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaTreinos,
                    "Erro ao excluir treino:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // SALVAR EXERCÍCIO
    // =============================================

    private void salvarExercicio() {

        String nome =
                telaAdicionarExercicio
                        .getTxtNome()
                        .getText()
                        .trim();


        String seriesTexto =
                telaAdicionarExercicio
                        .getTxtSeries()
                        .getText()
                        .trim();


        String repeticoesTexto =
                telaAdicionarExercicio
                        .getTxtRepeticoes()
                        .getText()
                        .trim();


        if (nome.isEmpty()
                || seriesTexto.isEmpty()
                || repeticoesTexto.isEmpty()) {

            JOptionPane.showMessageDialog(
                    telaAdicionarExercicio,
                    "Preencha todos os campos."
            );

            return;
        }


        try {

            int series =
                    Integer.parseInt(
                            seriesTexto
                    );


            int repeticoes =
                    Integer.parseInt(
                            repeticoesTexto
                    );


            if (series <= 0
                    || repeticoes <= 0) {

                JOptionPane.showMessageDialog(
                        telaAdicionarExercicio,
                        "Séries e repetições devem ser maiores que zero."
                );

                return;
            }


            // =====================================
            // NOVO EXERCÍCIO
            // =====================================

            if (exercicioEditando == null) {

                Exercicio exercicio =
                        new Exercicio(
                                nome,
                                series,
                                repeticoes,
                                treinoSelecionado.getId()
                        );


                exercicioDAO.inserir(
                        exercicio
                );


                JOptionPane.showMessageDialog(
                        telaAdicionarExercicio,
                        "Exercício adicionado com sucesso!"
                );

            }

            // =====================================
            // EDITANDO
            // =====================================

            else {

                exercicioEditando.setNome(
                        nome
                );


                exercicioEditando.setSeries(
                        series
                );


                exercicioEditando.setRepeticoes(
                        repeticoes
                );


                exercicioDAO.alterar(
                        exercicioEditando
                );


                JOptionPane.showMessageDialog(
                        telaAdicionarExercicio,
                        "Exercício alterado com sucesso!"
                );
            }


            exercicioEditando =
                    null;


            abrirTelaDetalhesTreino(
                    treinoSelecionado
            );


        } catch (NumberFormatException erro) {

            JOptionPane.showMessageDialog(
                    telaAdicionarExercicio,
                    "Séries e repetições devem ser números."
            );


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaAdicionarExercicio,
                    "Erro ao salvar exercício:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // EXCLUIR EXERCÍCIO
    // =============================================

    private void excluirExercicio() {

        Exercicio exercicio =
                telaDetalhesTreino
                        .getExercicioSelecionado();


        if (exercicio == null) {

            JOptionPane.showMessageDialog(
                    telaDetalhesTreino,
                    "Selecione um exercício."
            );

            return;
        }


        int resposta =
                JOptionPane.showConfirmDialog(
                        telaDetalhesTreino,
                        "Deseja excluir \""
                                + exercicio.getNome()
                                + "\"?",
                        "Excluir exercício",
                        JOptionPane.YES_NO_OPTION
                );


        if (resposta
                != JOptionPane.YES_OPTION) {

            return;
        }


        try {

            exercicioDAO.excluir(
                    exercicio.getId()
            );


            JOptionPane.showMessageDialog(
                    telaDetalhesTreino,
                    "Exercício excluído com sucesso!"
            );


            carregarExercicios();


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaDetalhesTreino,
                    "Erro ao excluir exercício:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // LOGIN
    // =============================================

    private void fazerLogin() {

        String email =
                telaLogin
                        .getTxtEmail()
                        .getText()
                        .trim();


        String senha =
                new String(
                        telaLogin
                                .getTxtSenha()
                                .getPassword()
                );


        if (email.isEmpty()
                || senha.isEmpty()) {

            JOptionPane.showMessageDialog(
                    telaLogin,
                    "Preencha o e-mail e a senha."
            );

            return;
        }


        try {

            Usuario usuario =
                    usuarioDAO.buscarPorEmail(
                            email
                    );


            if (usuario == null) {

                JOptionPane.showMessageDialog(
                        telaLogin,
                        "E-mail não cadastrado."
                );

                return;
            }


            if (!usuario
                    .getSenha()
                    .equals(senha)) {

                JOptionPane.showMessageDialog(
                        telaLogin,
                        "Senha incorreta."
                );

                return;
            }


            usuarioLogado =
                    usuario;


            JOptionPane.showMessageDialog(
                    telaLogin,
                    "Login realizado com sucesso!"
            );


            abrirTelaHome(
                    usuarioLogado
            );


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaLogin,
                    "Erro ao acessar o banco:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // CADASTRAR USUÁRIO
    // =============================================

    private void cadastrarUsuario() {

        String nome =
                telaCadastro
                        .getTxtNome()
                        .getText()
                        .trim();


        String email =
                telaCadastro
                        .getTxtEmail()
                        .getText()
                        .trim();


        String idadeTexto =
                telaCadastro
                        .getTxtIdade()
                        .getText()
                        .trim();


        String senha =
                new String(
                        telaCadastro
                                .getTxtSenha()
                                .getPassword()
                );


        String confirmarSenha =
                new String(
                        telaCadastro
                                .getTxtConfirmarSenha()
                                .getPassword()
                );


        if (nome.isEmpty()
                || email.isEmpty()
                || idadeTexto.isEmpty()
                || senha.isEmpty()
                || confirmarSenha.isEmpty()) {

            JOptionPane.showMessageDialog(
                    telaCadastro,
                    "Preencha todos os campos."
            );

            return;
        }


        if (senha.length() < 6) {

            JOptionPane.showMessageDialog(
                    telaCadastro,
                    "A senha deve possuir pelo menos 6 caracteres."
            );

            return;
        }


        if (!senha.equals(
                confirmarSenha
        )) {

            JOptionPane.showMessageDialog(
                    telaCadastro,
                    "As senhas não são iguais."
            );

            return;
        }


        try {

            int idade =
                    Integer.parseInt(
                            idadeTexto
                    );


            if (idade <= 0
                    || idade > 120) {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "Digite uma idade válida."
                );

                return;
            }


            Usuario existente =
                    usuarioDAO.buscarPorEmail(
                            email
                    );


            if (existente != null) {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "Este e-mail já está cadastrado."
                );

                return;
            }


            Usuario usuario =
                    new Usuario(
                            nome,
                            email,
                            senha,
                            idade
                    );


            usuarioDAO.inserir(
                    usuario
            );


            JOptionPane.showMessageDialog(
                    telaCadastro,
                    "Cadastro realizado com sucesso!"
            );


            abrirTelaLogin();


        } catch (NumberFormatException erro) {

            JOptionPane.showMessageDialog(
                    telaCadastro,
                    "A idade deve conter apenas números."
            );


        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(
                    telaCadastro,
                    "Erro ao cadastrar:\n"
                            + erro.getMessage()
            );


            erro.printStackTrace();
        }
    }


    // =============================================
    // ACTION PERFORMED
    // =============================================

    @Override
    public void actionPerformed(
            ActionEvent e
    ) {

        Object botao =
                e.getSource();


        // =========================================
        // TELA INICIAL
        // =========================================

        if (telaInicial != null) {

            if (botao
                    == telaInicial.getBtnEntrar()) {

                abrirTelaLogin();

                return;
            }


            if (botao
                    == telaInicial.getBtnCadastrar()) {

                abrirTelaCadastro();

                return;
            }


            if (botao
                    == telaInicial.getBtnSair()) {

                System.exit(0);

                return;
            }
        }


        // =========================================
        // LOGIN
        // =========================================

        if (telaLogin != null) {

            if (botao
                    == telaLogin.getBtnEntrar()) {

                fazerLogin();

                return;
            }


            if (botao
                    == telaLogin.getBtnCadastrar()) {

                abrirTelaCadastro();

                return;
            }


            if (botao
                    == telaLogin.getBtnVoltar()) {

                abrirTelaInicial();

                return;
            }
        }


        // =========================================
        // CADASTRO
        // =========================================

        if (telaCadastro != null) {

            if (botao
                    == telaCadastro.getBtnCadastrar()) {

                cadastrarUsuario();

                return;
            }


            if (botao
                    == telaCadastro.getBtnVoltar()) {

                abrirTelaInicial();

                return;
            }
        }


        // =========================================
        // HOME
        // =========================================

        if (telaHome != null) {

            if (botao
                    == telaHome.getBtnTreinos()) {

                abrirTelaTreinos();

                return;
            }


            if (botao
                    == telaHome.getBtnExercicios()) {

                abrirTelaExercicios();

                return;
            }


            if (botao
                    == telaHome.getBtnProgresso()) {

                abrirTelaProgresso();

                return;
            }


            if (botao
                    == telaHome.getBtnSair()) {

                usuarioLogado = null;

                treinoSelecionado = null;

                exercicioEditando = null;


                abrirTelaInicial();

                return;
            }
        }


        // =========================================
        // TREINOS
        // =========================================

        if (telaTreinos != null) {

            if (botao
                    == telaTreinos.getBtnNovoTreino()) {

                abrirTelaCriarTreino();

                return;
            }


            if (botao
                    == telaTreinos.getBtnAbrir()) {

                Treino treino =
                        telaTreinos
                                .getTreinoSelecionado();


                if (treino == null) {

                    JOptionPane.showMessageDialog(
                            telaTreinos,
                            "Selecione um treino."
                    );

                    return;
                }


                abrirTelaDetalhesTreino(
                        treino
                );

                return;
            }


            if (botao
                    == telaTreinos.getBtnExcluir()) {

                excluirTreino();

                return;
            }


            if (botao
                    == telaTreinos.getBtnVoltar()) {

                abrirTelaHome(
                        usuarioLogado
                );

                return;
            }
        }


        // =========================================
        // CRIAR TREINO
        // =========================================

        if (telaCriarTreino != null) {

            if (botao
                    == telaCriarTreino.getBtnSalvar()) {

                salvarTreino();

                return;
            }


            if (botao
                    == telaCriarTreino.getBtnVoltar()) {

                abrirTelaTreinos();

                return;
            }
        }


        // =========================================
        // DETALHES DO TREINO
        // =========================================

        if (telaDetalhesTreino != null) {

            if (botao
                    == telaDetalhesTreino
                            .getBtnConcluir()) {

                concluirTreino();

                return;
            }


            if (botao
                    == telaDetalhesTreino
                            .getBtnAdicionarExercicio()) {

                abrirTelaAdicionarExercicio();

                return;
            }


            if (botao
                    == telaDetalhesTreino
                            .getBtnEditar()) {

                Exercicio exercicio =
                        telaDetalhesTreino
                                .getExercicioSelecionado();


                abrirTelaEditarExercicio(
                        exercicio
                );

                return;
            }


            if (botao
                    == telaDetalhesTreino
                            .getBtnExcluir()) {

                excluirExercicio();

                return;
            }


            if (botao
                    == telaDetalhesTreino
                            .getBtnVoltar()) {

                abrirTelaTreinos();

                return;
            }
        }


        // =========================================
        // EXERCÍCIOS
        // =========================================

        if (telaExercicios != null) {

            if (botao
                    == telaExercicios.getBtnAbrirTreino()) {

                abrirTreinoDoExercicio();

                return;
            }


            if (botao
                    == telaExercicios.getBtnVoltar()) {

                abrirTelaHome(
                        usuarioLogado
                );

                return;
            }
        }


        // =========================================
        // PROGRESSO
        // =========================================

        if (telaProgresso != null) {

            if (botao
                    == telaProgresso.getBtnVoltar()) {

                abrirTelaHome(
                        usuarioLogado
                );

                return;
            }
        }


        // =========================================
        // ADICIONAR / EDITAR EXERCÍCIO
        // =========================================

        if (telaAdicionarExercicio != null) {

            if (botao
                    == telaAdicionarExercicio
                            .getBtnSalvar()) {

                salvarExercicio();

                return;
            }


            if (botao
                    == telaAdicionarExercicio
                            .getBtnVoltar()) {

                exercicioEditando = null;


                abrirTelaDetalhesTreino(
                        treinoSelecionado
                );

                return;
            }
        }
    }


    // =============================================
    // FECHAR TELAS
    // =============================================

    private void fecharTelas() {

        if (telaInicial != null) {

            telaInicial.dispose();

            telaInicial = null;
        }


        if (telaLogin != null) {

            telaLogin.dispose();

            telaLogin = null;
        }


        if (telaCadastro != null) {

            telaCadastro.dispose();

            telaCadastro = null;
        }


        if (telaHome != null) {

            telaHome.dispose();

            telaHome = null;
        }


        if (telaTreinos != null) {

            telaTreinos.dispose();

            telaTreinos = null;
        }


        if (telaCriarTreino != null) {

            telaCriarTreino.dispose();

            telaCriarTreino = null;
        }


        if (telaDetalhesTreino != null) {

            telaDetalhesTreino.dispose();

            telaDetalhesTreino = null;
        }


        if (telaAdicionarExercicio != null) {

            telaAdicionarExercicio.dispose();

            telaAdicionarExercicio = null;
        }


        if (telaExercicios != null) {

            telaExercicios.dispose();

            telaExercicios = null;
        }


        if (telaProgresso != null) {

            telaProgresso.dispose();

            telaProgresso = null;
        }
    }
}