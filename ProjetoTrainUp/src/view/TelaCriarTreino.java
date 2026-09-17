package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaCriarTreino extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtNome;

    private JButton btnSalvar;
    private JButton btnVoltar;


    // =============================================
    // CORES
    // =============================================

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


    // =============================================
    // CONSTRUTOR
    // =============================================

    public TelaCriarTreino() {

        setTitle(
                "TrainUp - Novo Treino"
        );

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setSize(
                600,
                400
        );

        setResizable(false);

        setLocationRelativeTo(null);


        contentPane =
                new JPanel();

        contentPane.setBackground(
                PRETO
        );

        contentPane.setBorder(
                new EmptyBorder(
                        5,
                        5,
                        5,
                        5
                )
        );

        contentPane.setLayout(null);

        setContentPane(
                contentPane
        );


        criarComponentes();
    }


    // =============================================
    // COMPONENTES
    // =============================================

    private void criarComponentes() {


        // =========================================
        // LOGO
        // =========================================

        JLabel lblLogo =
                new JLabel("TRAINUP");

        lblLogo.setBounds(
                30,
                20,
                200,
                40
        );

        lblLogo.setForeground(
                ROXO
        );

        lblLogo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );

        contentPane.add(
                lblLogo
        );


        // =========================================
        // VOLTAR
        // =========================================

        btnVoltar =
                new JButton("VOLTAR");

        btnVoltar.setBounds(
                450,
                25,
                100,
                35
        );

        btnVoltar.setBackground(
                PRETO_CLARO
        );

        btnVoltar.setForeground(
                BRANCO
        );

        btnVoltar.setFocusPainted(
                false
        );

        contentPane.add(
                btnVoltar
        );


        // =========================================
        // TÍTULO
        // =========================================

        JLabel lblTitulo =
                new JLabel(
                        "Criar novo treino"
                );

        lblTitulo.setBounds(
                60,
                100,
                450,
                40
        );

        lblTitulo.setForeground(
                BRANCO
        );

        lblTitulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        contentPane.add(
                lblTitulo
        );


        // =========================================
        // SUBTÍTULO
        // =========================================

        JLabel lblSubtitulo =
                new JLabel(
                        "Dê um nome para seu treino."
                );

        lblSubtitulo.setBounds(
                60,
                140,
                450,
                25
        );

        lblSubtitulo.setForeground(
                CINZA
        );

        contentPane.add(
                lblSubtitulo
        );


        // =========================================
        // LABEL NOME
        // =========================================

        JLabel lblNome =
                new JLabel(
                        "NOME DO TREINO"
                );

        lblNome.setBounds(
                60,
                195,
                450,
                20
        );

        lblNome.setForeground(
                CINZA
        );

        lblNome.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        contentPane.add(
                lblNome
        );


        // =========================================
        // CAMPO NOME
        // =========================================

        txtNome =
                new JTextField();

        txtNome.setBounds(
                60,
                220,
                470,
                45
        );

        txtNome.setBackground(
                PRETO_CLARO
        );

        txtNome.setForeground(
                BRANCO
        );

        txtNome.setCaretColor(
                BRANCO
        );

        txtNome.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        txtNome.setBorder(
                BorderFactory.createLineBorder(
                        ROXO,
                        1
                )
        );

        contentPane.add(
                txtNome
        );


        // =========================================
        // SALVAR
        // =========================================

        btnSalvar =
                new JButton(
                        "SALVAR TREINO"
                );

        btnSalvar.setBounds(
                330,
                295,
                200,
                45
        );

        btnSalvar.setBackground(
                ROXO
        );

        btnSalvar.setForeground(
                BRANCO
        );

        btnSalvar.setFocusPainted(
                false
        );

        btnSalvar.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        contentPane.add(
                btnSalvar
        );
    }


    // =============================================
    // GETTERS
    // =============================================

    public JTextField getTxtNome() {
        return txtNome;
    }


    public JButton getBtnSalvar() {
        return btnSalvar;
    }


    public JButton getBtnVoltar() {
        return btnVoltar;
    }
}