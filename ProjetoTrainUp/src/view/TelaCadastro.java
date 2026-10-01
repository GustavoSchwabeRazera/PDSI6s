package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaCadastro extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtNome;
    private JTextField txtEmail;
    private JTextField txtIdade;

    private JPasswordField txtSenha;
    private JPasswordField txtConfirmarSenha;

    private JButton btnCadastrar;
    private JButton btnVoltar;


    public TelaCadastro() {

        setTitle("TrainUp - Cadastro");

        Icone.aplicar(this);

        contentPane = Estilo.criarFundo();

        setContentPane(contentPane);

        criarComponentes();

        Janela.configurar(this);
    }


    private void criarComponentes() {

        // =============================
        // CABEÇALHO
        // =============================

        btnVoltar = Estilo.criarBotaoCabecalho("VOLTAR");

        contentPane.add(
                Estilo.criarCabecalho(btnVoltar),
                BorderLayout.NORTH
        );


        // =============================
        // FORMULÁRIO
        // =============================

        JPanel formulario = Estilo.criarFormulario();


        // TÍTULO

        JLabel lblTitulo = Estilo.criarTitulo("CRIAR CONTA");

        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        Estilo.adicionar(formulario, lblTitulo);


        // SUBTÍTULO

        JLabel lblSubtitulo =
                Estilo.criarSubtitulo("Cadastre-se no TrainUp");

        lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);

        Estilo.adicionar(formulario, lblSubtitulo);

        Estilo.espaco(formulario, 25);


        // NOME

        txtNome = Estilo.criarCampo();

        adicionarCampo(formulario, "NOME", txtNome);


        // EMAIL

        txtEmail = Estilo.criarCampo();

        adicionarCampo(formulario, "E-MAIL", txtEmail);


        // IDADE

        txtIdade = Estilo.criarCampo();

        adicionarCampo(formulario, "IDADE", txtIdade);


        // SENHA

        txtSenha = Estilo.criarCampoSenha();

        adicionarCampo(formulario, "SENHA", txtSenha);


        // CONFIRMAR SENHA

        txtConfirmarSenha = Estilo.criarCampoSenha();

        adicionarCampo(formulario, "CONFIRMAR SENHA", txtConfirmarSenha);


        // MOSTRAR SENHA

        JCheckBox chkMostrarSenha = new JCheckBox("Mostrar senha");

        chkMostrarSenha.setForeground(Estilo.CINZA);
        chkMostrarSenha.setOpaque(false);
        chkMostrarSenha.setFocusPainted(false);
        chkMostrarSenha.setFont(Fontes.PADRAO);

        chkMostrarSenha.addActionListener(
                e -> {

                    char eco = chkMostrarSenha.isSelected()
                            ? (char) 0
                            : '•';

                    txtSenha.setEchoChar(eco);
                    txtConfirmarSenha.setEchoChar(eco);
                }
        );

        Estilo.adicionar(formulario, chkMostrarSenha);

        Estilo.espaco(formulario, 20);


        // CADASTRAR

        btnCadastrar = Estilo.criarBotaoPrimario("CADASTRAR");

        Estilo.adicionar(formulario, btnCadastrar);


        contentPane.add(
                Estilo.centralizar(formulario),
                BorderLayout.CENTER
        );
    }


    private void adicionarCampo(
            JPanel formulario,
            String rotulo,
            JTextField campo
    ) {

        Estilo.adicionar(formulario, Estilo.criarRotulo(rotulo));

        Estilo.adicionar(formulario, campo);

        Estilo.espaco(formulario, 12);
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

    public JButton getBtnVoltar() {
        return btnVoltar;
    }
}
