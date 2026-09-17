package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaHome extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JButton btnTreinos;
    private JButton btnExercicios;
    private JButton btnProgresso;
    private JButton btnSair;

    private JLabel lblBemVindo;

    private static final Color PRETO =
            new Color(18, 18, 18);

    private static final Color PRETO_CLARO =
            new Color(30, 30, 30);

    private static final Color ROXO =
            new Color(138, 43, 226);

    private static final Color BRANCO =
            new Color(245, 245, 245);

    private static final Color CINZA =
            new Color(180, 180, 180);


    public TelaHome() {

        setTitle("TrainUp - Home");

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setSize(900, 600);

        setResizable(false);

        setLocationRelativeTo(null);

        contentPane = new JPanel();

        contentPane.setBackground(PRETO);

        contentPane.setBorder(
                new EmptyBorder(5, 5, 5, 5)
        );

        contentPane.setLayout(null);

        setContentPane(contentPane);

        criarComponentes();
    }


    private void criarComponentes() {

        // =========================
        // LOGO
        // =========================

        JLabel lblLogo =
                new JLabel("TRAINUP");

        lblLogo.setBounds(
                40, 25, 200, 50
        );

        lblLogo.setForeground(ROXO);

        lblLogo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        contentPane.add(lblLogo);


        // =========================
        // SAIR
        // =========================

        btnSair =
                new JButton("SAIR");

        btnSair.setBounds(
                760, 30, 90, 35
        );

        btnSair.setBackground(
                PRETO_CLARO
        );

        btnSair.setForeground(BRANCO);

        btnSair.setFocusPainted(false);

        contentPane.add(btnSair);


        // =========================
        // BEM-VINDO
        // =========================

        lblBemVindo =
                new JLabel(
                        "Bem-vindo ao TrainUp"
                );

        lblBemVindo.setBounds(
                60, 120, 700, 50
        );

        lblBemVindo.setForeground(BRANCO);

        lblBemVindo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );

        contentPane.add(lblBemVindo);


        JLabel lblSubtitulo =
                new JLabel(
                        "O que você deseja fazer hoje?"
                );

        lblSubtitulo.setBounds(
                60, 170, 500, 30
        );

        lblSubtitulo.setForeground(CINZA);

        contentPane.add(lblSubtitulo);


        // =========================
        // CARDS
        // =========================

        btnTreinos = criarCard(
                "MEUS TREINOS",
                60,
                250
        );

        contentPane.add(btnTreinos);


        btnExercicios = criarCard(
                "EXERCÍCIOS",
                330,
                250
        );

        contentPane.add(btnExercicios);


        btnProgresso = criarCard(
                "PROGRESSO",
                600,
                250
        );

        contentPane.add(btnProgresso);


        JLabel lblFrase =
                new JLabel(
                        "Continue evoluindo. Cada treino conta."
                );

        lblFrase.setBounds(
                60, 470, 700, 30
        );

        lblFrase.setForeground(CINZA);

        contentPane.add(lblFrase);
    }


    private JButton criarCard(
            String texto,
            int x,
            int y
    ) {

        JButton botao =
                new JButton(texto);

        botao.setBounds(
                x, y, 230, 150
        );

        botao.setBackground(
                PRETO_CLARO
        );

        botao.setForeground(BRANCO);

        botao.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        17
                )
        );

        botao.setFocusPainted(false);

        botao.setBorder(
                BorderFactory
                        .createLineBorder(
                                ROXO,
                                2
                        )
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