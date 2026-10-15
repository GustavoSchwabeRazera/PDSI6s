package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class TelaLogin extends Icone {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JButton btnEntrar;
	private JButton btnEntrarGoogle;
	private JButton btnCadastrar;
	private JButton btnVoltar;

	public TelaLogin() {
		setTitle("TrainUp - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 460);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/images/logo.png")));
		lblLogo.setBounds(152, 10, 80, 80);
		contentPane.add(lblLogo);

		JLabel lblTitulo = new JLabel("Entrar");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setBounds(50, 110, 290, 30);
		contentPane.add(lblTitulo);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(40, 160, 70, 25);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(110, 160, 230, 25);
		contentPane.add(txtEmail);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(40, 200, 70, 25);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(110, 200, 230, 25);
		contentPane.add(txtSenha);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(40, 245, 300, 30);
		contentPane.add(btnEntrar);

		btnEntrarGoogle = new JButton("Entrar com Google");
		btnEntrarGoogle.setBounds(40, 285, 300, 30);
		contentPane.add(btnEntrarGoogle);

		btnCadastrar = new JButton("Não possui conta? Cadastre-se");
		btnCadastrar.setBounds(40, 325, 300, 30);
		contentPane.add(btnCadastrar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(40, 365, 300, 30);
		contentPane.add(btnVoltar);
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public JButton getBtnEntrarGoogle() {
		return btnEntrarGoogle;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
