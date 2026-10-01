package view;

import static view.Fontes.px;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaHome extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JButton btnTreinos;
    private JButton btnExercicios;
    private JButton btnProgresso;
    private JButton btnSair;

    private JLabel lblBemVindo;


    public TelaHome() {

        setTitle("TrainUp - Home");

        Icone.aplicar(this);

        contentPane = Estilo.criarFundo();

        setContentPane(contentPane);

        criarComponentes();

        Janela.configurar(this);
    }


    private void criarComponentes() {

        // =========================
        // CABEÇALHO
        // =========================

        btnSair = Estilo.criarBotaoCabecalho("SAIR");

        contentPane.add(
                Estilo.criarCabecalho(btnSair),
                BorderLayout.NORTH
        );


        // =========================
        // CONTEÚDO
        // =========================

        JPanel conteudo = Estilo.criarPainel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;


        // BEM-VINDO

        JPanel textos = Estilo.criarPainel(null);

        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        lblBemVindo = Estilo.criarTitulo("Bem-vindo ao TrainUp");

        textos.add(lblBemVindo);

        textos.add(Estilo.criarSubtitulo("O que você deseja fazer hoje?"));

        c.gridy = 0;
        c.insets = new Insets(0, 0, px(50), 0);

        conteudo.add(textos, c);


        // CARDS

        JPanel cards = Estilo.criarPainel(new GridLayout(1, 3, px(40), 0));

        btnTreinos = criarCard("MEUS TREINOS");
        btnExercicios = criarCard("EXERCÍCIOS");
        btnProgresso = criarCard("PROGRESSO");

        cards.add(btnTreinos);
        cards.add(btnExercicios);
        cards.add(btnProgresso);

        c.gridy = 1;
        c.ipady = px(220);
        c.insets = new Insets(0, 0, px(50), 0);

        conteudo.add(cards, c);


        // FRASE

        c.gridy = 2;
        c.ipady = 0;
        c.insets = new Insets(0, 0, 0, 0);

        conteudo.add(
                Estilo.criarSubtitulo("Continue evoluindo. Cada treino conta."),
                c
        );


        contentPane.add(conteudo, BorderLayout.CENTER);
    }


    private JButton criarCard(String texto) {

        JButton botao = Estilo.criarBotaoSecundario(texto);

        botao.setFont(Fontes.CARD);

        botao.setBorder(
                BorderFactory.createLineBorder(Estilo.ROXO, 2)
        );

        return botao;
    }


    public void setNomeUsuario(
            String nome
    ) {

        lblBemVindo.setText(
                "Olá, " + nome + "!"
        );
    }


    // =========================
    // GETTERS
    // =========================

    public JButton getBtnTreinos() {
        return btnTreinos;
    }

    public JButton getBtnExercicios() {
        return btnExercicios;
    }

    public JButton getBtnProgresso() {
        return btnProgresso;
    }

    public JButton getBtnSair() {
        return btnSair;
    }
}
