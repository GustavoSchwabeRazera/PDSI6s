package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Usuario;

public class TelaCadastro extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtIdade;

    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;

    private JButton btnCadastrar;
    // CORES
    private static final Color PRETO = new Color(18, 18, 18);
    private static final Color PRETO_CLARO = new Color(30, 30, 30);
    private static final Color ROXO = new Color(138, 43, 226);
    private static final Color BRANCO = new Color(245, 245, 245);
    private static final Color CINZA = new Color(180, 180, 180);

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            try {

                TelaCadastro frame = new TelaCadastro();
                frame.setVisible(true);

            } catch (Exception e) {

                e.printStackTrace();
            }
        });
    }

    public TelaCadastro() {

        setTitle("TrainUp - Cadastro");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 500, 700);

        setResizable(false);

        contentPane = new JPanel();

        contentPane.setBackground(PRETO);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        // IMPORTANTE
        contentPane.setLayout(null);

        criarComponentes();
    }

    private void criarComponentes() {

        // =====================================================
        // TÍTULO
        // =====================================================

        JLabel lblTitulo = new JLabel("CRIAR CONTA");

        lblTitulo.setBounds(50, 30, 400, 40);

        lblTitulo.setHorizontalAlignment(JLabel.CENTER);

        lblTitulo.setForeground(BRANCO);

        lblTitulo.setFont(
            new Font("Segoe UI", Font.BOLD, 28)
        );

        contentPane.add(lblTitulo);


        // =====================================================
        // SUBTÍTULO
        // =====================================================

        JLabel lblSubtitulo = new JLabel(
            "Cadastre-se no TrainUp"
        );

        lblSubtitulo.setBounds(50, 70, 400, 25);

        lblSubtitulo.setHorizontalAlignment(JLabel.CENTER);

        lblSubtitulo.setForeground(CINZA);

        lblSubtitulo.setFont(
            new Font("Segoe UI", Font.PLAIN, 14)
        );

        contentPane.add(lblSubtitulo);


        // =====================================================
        // NOME
        // =====================================================

        JLabel lblNome = criarLabel("NOME");

        lblNome.setBounds(70, 120, 350, 20);

        contentPane.add(lblNome);


        txtNome = criarCampo();

        txtNome.setBounds(70, 145, 350, 40);

        contentPane.add(txtNome);


        // =====================================================
        // EMAIL
        // =====================================================

        JLabel lblEmail = criarLabel("E-MAIL");

        lblEmail.setBounds(70, 195, 350, 20);

        contentPane.add(lblEmail);


        txtEmail = criarCampo();

        txtEmail.setBounds(70, 220, 350, 40);

        contentPane.add(txtEmail);


        // =====================================================
        // IDADE
        // =====================================================

        JLabel lblIdade = criarLabel("IDADE");

        lblIdade.setBounds(70, 270, 350, 20);

        contentPane.add(lblIdade);


        txtIdade = criarCampo();

        txtIdade.setBounds(70, 295, 350, 40);

        contentPane.add(txtIdade);


        // =====================================================
        // SENHA
        // =====================================================

        JLabel lblSenha = criarLabel("SENHA");

        lblSenha.setBounds(70, 345, 350, 20);

        contentPane.add(lblSenha);


        txtSenha = new JPasswordField();

        txtSenha.setBounds(70, 370, 350, 40);

        txtSenha.setFont(
            new Font("Segoe UI", Font.PLAIN, 16)
        );

        txtSenha.setForeground(BRANCO);

        txtSenha.setBackground(PRETO_CLARO);

        txtSenha.setCaretColor(BRANCO);

        txtSenha.setBorder(
            BorderFactory.createLineBorder(ROXO, 1)
        );

        contentPane.add(txtSenha);


        // =====================================================
        // CONFIRMAR SENHA
        // =====================================================

        JLabel lblConfirmarSenha =
            criarLabel("CONFIRMAR SENHA");

        lblConfirmarSenha.setBounds(
            70, 420, 350, 20
        );

        contentPane.add(lblConfirmarSenha);


        txtConfirmarSenha = new JPasswordField();

        txtConfirmarSenha.setBounds(
            70, 445, 350, 40
        );

        txtConfirmarSenha.setFont(
            new Font("Segoe UI", Font.PLAIN, 16)
        );

        txtConfirmarSenha.setForeground(BRANCO);

        txtConfirmarSenha.setBackground(PRETO_CLARO);

        txtConfirmarSenha.setCaretColor(BRANCO);

        txtConfirmarSenha.setBorder(
            BorderFactory.createLineBorder(ROXO, 1)
        );

        contentPane.add(txtConfirmarSenha);


        // =====================================================
        // MOSTRAR SENHA
        // =====================================================

        JCheckBox chkMostrarSenha =
            new JCheckBox("Mostrar senha");

        chkMostrarSenha.setBounds(
            70, 495, 150, 25
        );

        chkMostrarSenha.setForeground(CINZA);

        chkMostrarSenha.setBackground(PRETO);

        chkMostrarSenha.setFont(
            new Font("Segoe UI", Font.PLAIN, 12)
        );

        chkMostrarSenha.setFocusPainted(false);

        chkMostrarSenha.addActionListener(e -> {

            if (chkMostrarSenha.isSelected()) {

                txtSenha.setEchoChar((char) 0);

                txtConfirmarSenha.setEchoChar((char) 0);

            } else {

                txtSenha.setEchoChar('•');

                txtConfirmarSenha.setEchoChar('•');
            }
        });

        contentPane.add(chkMostrarSenha);


        // =====================================================
        // BOTÃO CADASTRAR
        // =====================================================

        btnCadastrar =
            new JButton("CADASTRAR");

        btnCadastrar.setBounds(
            70, 545, 350, 45
        );

        btnCadastrar.setFont(
            new Font("Segoe UI", Font.BOLD, 16)
        );

        btnCadastrar.setForeground(BRANCO);

        btnCadastrar.setBackground(ROXO);

        btnCadastrar.setFocusPainted(false);

        btnCadastrar.setBorder(
            BorderFactory.createEmptyBorder()
        );

        

        contentPane.add(btnCadastrar);
    }


    // =========================================================
    // LABEL
    // =========================================================

    private JLabel criarLabel(String texto) {

        JLabel label = new JLabel(texto);

        label.setForeground(CINZA);

        label.setFont(
            new Font("Segoe UI", Font.BOLD, 12)
        );

        return label;
    }


    // =========================================================
    // CAMPO DE TEXTO
    // =========================================================

    private JTextField criarCampo() {

        JTextField campo = new JTextField();

        campo.setFont(
            new Font("Segoe UI", Font.PLAIN, 16)
        );

        campo.setForeground(BRANCO);

        campo.setBackground(PRETO_CLARO);

        campo.setCaretColor(BRANCO);

        campo.setBorder(
            BorderFactory.createLineBorder(ROXO, 1)
        );

        return campo;
    }


    // =========================================================
    // CADASTRO
    // =========================================================

    private void cadastrar() {

        String nome = txtNome.getText().trim();

        String email = txtEmail.getText().trim();

        String idadeTexto = txtIdade.getText().trim();

        String senha =
            new String(txtSenha.getPassword());

        String confirmarSenha =
            new String(txtConfirmarSenha.getPassword());


        // -----------------------------------------------------
        // NOME
        // -----------------------------------------------------

        if (nome.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Digite seu nome.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            txtNome.requestFocus();

            return;
        }


        // -----------------------------------------------------
        // EMAIL
        // -----------------------------------------------------

        if (email.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Digite seu e-mail.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            txtEmail.requestFocus();

            return;
        }


        // -----------------------------------------------------
        // IDADE
        // -----------------------------------------------------

        if (idadeTexto.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Digite sua idade.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            txtIdade.requestFocus();

            return;
        }

        int idade;

        try {

            idade = Integer.parseInt(idadeTexto);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this,
                "A idade deve conter apenas números.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );

            txtIdade.requestFocus();

            return;
        }


        if (idade <= 0 || idade > 120) {

            JOptionPane.showMessageDialog(
                this,
                "Digite uma idade válida.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );

            txtIdade.requestFocus();

            return;
        }


        // -----------------------------------------------------
        // SENHA
        // -----------------------------------------------------

        if (senha.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Digite uma senha.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            txtSenha.requestFocus();

            return;
        }


        if (senha.length() < 6) {

            JOptionPane.showMessageDialog(
                this,
                "A senha deve possuir pelo menos 6 caracteres.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );

            txtSenha.requestFocus();

            return;
        }


        // -----------------------------------------------------
        // CONFIRMAR SENHA
        // -----------------------------------------------------

        if (confirmarSenha.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Confirme sua senha.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            txtConfirmarSenha.requestFocus();

            return;
        }


        if (!senha.equals(confirmarSenha)) {

            JOptionPane.showMessageDialog(
                this,
                "As senhas não são iguais.",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );

            txtConfirmarSenha.requestFocus();

            return;
        }


        // -----------------------------------------------------
        // CRIAR OBJETO USUARIO
        // -----------------------------------------------------

        Usuario usuario = new Usuario(
            nome,
            email,
            senha,
            idade
        );


        JOptionPane.showMessageDialog(
            this,
            "Cadastro realizado com sucesso!\n\n"
            + "Nome: " + usuario.getNome()
            + "\nE-mail: " + usuario.getEmail()
            + "\nIdade: " + usuario.getIdade(),
            "TrainUp",
            JOptionPane.INFORMATION_MESSAGE
        );


        // -----------------------------------------------------
        // LIMPAR CAMPOS
        // -----------------------------------------------------

        txtNome.setText("");

        txtEmail.setText("");

        txtIdade.setText("");

        txtSenha.setText("");

        txtConfirmarSenha.setText("");

        txtNome.requestFocus();
    }
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