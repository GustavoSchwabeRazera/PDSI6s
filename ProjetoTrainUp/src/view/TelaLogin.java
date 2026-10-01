package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaLogin extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtEmail;

    private JPasswordField txtSenha;

    private JButton btnEntrar;
    private JButton btnCadastrar;
    private JButton btnVoltar;


    public TelaLogin() {

        setTitle("TrainUp - Login");

        Icone.aplicar(this);

        contentPane = Estilo.criarFundo();

        setContentPane(contentPane);

        criarComponentes();

        Janela.configurar(this);
    }


    private void criarComponentes() {

        // ===========================
        // CABEÇALHO
        // ===========================

        btnVoltar = Estilo.criarBotaoCabecalho("VOLTAR");

        contentPane.add(
                Estilo.criarCabecalho(btnVoltar),
                BorderLayout.NORTH
        );


        // ===========================
        // FORMULÁRIO
        // ===========================

        JPanel formulario = Estilo.criarFormulario();


        // TÍTULO

        JLabel lblTitulo = Estilo.criarTitulo("ENTRAR");

        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        Estilo.adicionar(formulario, lblTitulo);


        // SUBTÍTULO

        JLabel lblSubtitulo =
                Estilo.criarSubtitulo("Entre na sua conta TrainUp");

        lblSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);

        Estilo.adicionar(formulario, lblSubtitulo);

        Estilo.espaco(formulario, 40);


        // EMAIL

        Estilo.adicionar(formulario, Estilo.criarRotulo("E-MAIL"));

        txtEmail = Estilo.criarCampo();

        Estilo.adicionar(formulario, txtEmail);

        Estilo.espaco(formulario, 20);


        // SENHA

        Estilo.adicionar(formulario, Estilo.criarRotulo("SENHA"));

        txtSenha = Estilo.criarCampoSenha();

        Estilo.adicionar(formulario, txtSenha);

        Estilo.espaco(formulario, 35);


        // ENTRAR

        btnEntrar = Estilo.criarBotaoPrimario("ENTRAR");

        Estilo.adicionar(formulario, btnEntrar);

        Estilo.espaco(formulario, 20);


        // CADASTRAR

        btnCadastrar = Estilo.criarBotaoLink(
                "Não possui conta? Cadastre-se",
                Estilo.ROXO
        );

        Estilo.adicionar(formulario, btnCadastrar);

        Estilo.espaco(formulario, 60);


        contentPane.add(
                Estilo.centralizar(formulario),
                BorderLayout.CENTER
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
