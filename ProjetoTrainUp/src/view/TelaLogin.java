package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaLogin extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtEmail;

    private JPasswordField txtSenha;

    private JButton btnEntrar;
    private JButton btnCadastrar;
    private JButton btnVoltar;

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


    public TelaLogin() {

        setTitle("TrainUp - Login");

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setSize(500, 600);

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

        // ===========================
        // TÍTULO
        // ===========================

        JLabel lblTitulo =
                new JLabel("ENTRAR");

        lblTitulo.setBounds(
                50, 60, 400, 50
        );

        lblTitulo.setHorizontalAlignment(
                JLabel.CENTER
        );

        lblTitulo.setForeground(BRANCO);

        lblTitulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );

        contentPane.add(lblTitulo);


        // ===========================
        // SUBTÍTULO
        // ===========================

        JLabel lblSubtitulo =
                new JLabel(
                        "Entre na sua conta TrainUp"
                );

        lblSubtitulo.setBounds(
                50, 110, 400, 25
        );

        lblSubtitulo.setHorizontalAlignment(
                JLabel.CENTER
        );

        lblSubtitulo.setForeground(CINZA);

        contentPane.add(lblSubtitulo);


        // ===========================
        // EMAIL
        // ===========================

        JLabel lblEmail =
                new JLabel("E-MAIL");

        lblEmail.setBounds(
                75, 180, 350, 20
        );

        lblEmail.setForeground(BRANCO);

        contentPane.add(lblEmail);


        txtEmail = new JTextField();

        txtEmail.setBounds(
                75, 205, 350, 45
        );

        configurarCampo(txtEmail);

        contentPane.add(txtEmail);


        // ===========================
        // SENHA
        // ===========================

        JLabel lblSenha =
                new JLabel("SENHA");

        lblSenha.setBounds(
                75, 275, 350, 20
        );

        lblSenha.setForeground(BRANCO);

        contentPane.add(lblSenha);


        txtSenha =
                new JPasswordField();

        txtSenha.setBounds(
                75, 300, 350, 45
        );

        txtSenha.setBackground(PRETO_CLARO);
        txtSenha.setForeground(BRANCO);
        txtSenha.setCaretColor(BRANCO);

        txtSenha.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        txtSenha.setBorder(
                BorderFactory.createLineBorder(
                        ROXO,
                        1
                )
        );

        contentPane.add(txtSenha);


        // ===========================
        // ENTRAR
        // ===========================

        btnEntrar =
                new JButton("ENTRAR");

        btnEntrar.setBounds(
                75, 385, 350, 50
        );

        btnEntrar.setBackground(ROXO);
        btnEntrar.setForeground(BRANCO);
        btnEntrar.setFocusPainted(false);

        btnEntrar.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        contentPane.add(btnEntrar);


        // ===========================
        // CADASTRAR
        // ===========================

        btnCadastrar =
                new JButton(
                        "Não possui conta? Cadastre-se"
                );

        btnCadastrar.setBounds(
                75, 450, 350, 30
        );

        btnCadastrar.setForeground(ROXO);
        btnCadastrar.setBackground(PRETO);
        btnCadastrar.setBorder(null);
        btnCadastrar.setFocusPainted(false);

        contentPane.add(btnCadastrar);


        // ===========================
        // VOLTAR
        // ===========================

        btnVoltar =
                new JButton("Voltar");

        btnVoltar.setBounds(
                75, 500, 350, 30
        );

        btnVoltar.setForeground(CINZA);
        btnVoltar.setBackground(PRETO);
        btnVoltar.setBorder(null);
        btnVoltar.setFocusPainted(false);

        contentPane.add(btnVoltar);
    }


    private void configurarCampo(
            JTextField campo
    ) {

        campo.setBackground(PRETO_CLARO);

        campo.setForeground(BRANCO);

        campo.setCaretColor(BRANCO);

        campo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        campo.setBorder(
                BorderFactory.createLineBorder(
                        ROXO,
                        1
                )
        );
    }


    // ===========================
    // GETTERS
    // ===========================

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public JButton getBtnEntrar() {
        return btnEntrar;
    }

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }
}