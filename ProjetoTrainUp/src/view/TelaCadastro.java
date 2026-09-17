package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaCadastro extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtIdade;

    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;

    private JButton btnCadastrar;

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


    public TelaCadastro() {

        setTitle("TrainUp - Cadastro");

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setSize(500, 700);

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

        // =============================
        // TÍTULO
        // =============================

        JLabel lblTitulo =
                new JLabel("CRIAR CONTA");

        lblTitulo.setBounds(
                50, 30, 400, 40
        );

        lblTitulo.setHorizontalAlignment(
                JLabel.CENTER
        );

        lblTitulo.setForeground(BRANCO);

        lblTitulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        contentPane.add(lblTitulo);


        // =============================
        // SUBTÍTULO
        // =============================

        JLabel lblSubtitulo =
                new JLabel(
                        "Cadastre-se no TrainUp"
                );

        lblSubtitulo.setBounds(
                50, 70, 400, 25
        );

        lblSubtitulo.setHorizontalAlignment(
                JLabel.CENTER
        );

        lblSubtitulo.setForeground(CINZA);

        contentPane.add(lblSubtitulo);


        // =============================
        // NOME
        // =============================

        JLabel lblNome =
                criarLabel("NOME");

        lblNome.setBounds(
                70, 120, 350, 20
        );

        contentPane.add(lblNome);


        txtNome = criarCampo();

        txtNome.setBounds(
                70, 145, 350, 40
        );

        contentPane.add(txtNome);


        // =============================
        // EMAIL
        // =============================

        JLabel lblEmail =
                criarLabel("E-MAIL");

        lblEmail.setBounds(
                70, 195, 350, 20
        );

        contentPane.add(lblEmail);


        txtEmail = criarCampo();

        txtEmail.setBounds(
                70, 220, 350, 40
        );

        contentPane.add(txtEmail);


        // =============================
        // IDADE
        // =============================

        JLabel lblIdade =
                criarLabel("IDADE");

        lblIdade.setBounds(
                70, 270, 350, 20
        );

        contentPane.add(lblIdade);


        txtIdade = criarCampo();

        txtIdade.setBounds(
                70, 295, 350, 40
        );

        contentPane.add(txtIdade);


        // =============================
        // SENHA
        // =============================

        JLabel lblSenha =
                criarLabel("SENHA");

        lblSenha.setBounds(
                70, 345, 350, 20
        );

        contentPane.add(lblSenha);


        txtSenha =
                new JPasswordField();

        configurarSenha(txtSenha);

        txtSenha.setBounds(
                70, 370, 350, 40
        );

        contentPane.add(txtSenha);


        // =============================
        // CONFIRMAR SENHA
        // =============================

        JLabel lblConfirmar =
                criarLabel(
                        "CONFIRMAR SENHA"
                );

        lblConfirmar.setBounds(
                70, 420, 350, 20
        );

        contentPane.add(lblConfirmar);


        txtConfirmarSenha =
                new JPasswordField();

        configurarSenha(
                txtConfirmarSenha
        );

        txtConfirmarSenha.setBounds(
                70, 445, 350, 40
        );

        contentPane.add(
                txtConfirmarSenha
        );


        // =============================
        // MOSTRAR SENHA
        // =============================

        JCheckBox chkMostrarSenha =
                new JCheckBox(
                        "Mostrar senha"
                );

        chkMostrarSenha.setBounds(
                70, 495, 150, 25
        );

        chkMostrarSenha.setForeground(CINZA);

        chkMostrarSenha.setBackground(PRETO);

        chkMostrarSenha.setFocusPainted(false);


        chkMostrarSenha.addActionListener(
                e -> {

                    if (chkMostrarSenha
                            .isSelected()) {

                        txtSenha.setEchoChar(
                                (char) 0
                        );

                        txtConfirmarSenha
                                .setEchoChar(
                                        (char) 0
                                );

                    } else {

                        txtSenha.setEchoChar('•');

                        txtConfirmarSenha
                                .setEchoChar('•');
                    }
                }
        );

        contentPane.add(chkMostrarSenha);


        // =============================
        // CADASTRAR
        // =============================

        btnCadastrar =
                new JButton("CADASTRAR");

        btnCadastrar.setBounds(
                70, 545, 350, 45
        );

        btnCadastrar.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        btnCadastrar.setForeground(BRANCO);

        btnCadastrar.setBackground(ROXO);

        btnCadastrar.setFocusPainted(false);

        btnCadastrar.setBorder(
                BorderFactory
                        .createEmptyBorder()
        );

        contentPane.add(btnCadastrar);
    }


    private JLabel criarLabel(
            String texto
    ) {

        JLabel label =
                new JLabel(texto);

        label.setForeground(CINZA);

        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );

        return label;
    }


    private JTextField criarCampo() {

        JTextField campo =
                new JTextField();

        campo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        campo.setForeground(BRANCO);

        campo.setBackground(PRETO_CLARO);

        campo.setCaretColor(BRANCO);

        campo.setBorder(
                BorderFactory
                        .createLineBorder(
                                ROXO,
                                1
                        )
        );

        return campo;
    }


    private void configurarSenha(
            JPasswordField campo
    ) {

        campo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        campo.setForeground(BRANCO);

        campo.setBackground(PRETO_CLARO);

        campo.setCaretColor(BRANCO);

        campo.setBorder(
                BorderFactory
                        .createLineBorder(
                                ROXO,
                                1
                        )
        );
    }


    // =============================
    // GETTERS
    // =============================

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtIdade() {
        return txtIdade;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }

    public JPasswordField getTxtConfirmarSenha() {
        return txtConfirmarSenha;
    }

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }
}