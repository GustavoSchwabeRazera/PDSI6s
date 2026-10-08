package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class TelaLogin extends JFrame {

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
		setBounds(100, 100, 400, 370);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Entrar");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setBounds(50, 20, 290, 30);
		contentPane.add(lblTitulo);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(40, 70, 70, 25);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(110, 70, 230, 25);
		contentPane.add(txtEmail);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(40, 110, 70, 25);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(110, 110, 230, 25);
		contentPane.add(txtSenha);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(40, 155, 300, 30);
		contentPane.add(btnEntrar);

		btnEntrarGoogle = new JButton("Entrar com Google");
		btnEntrarGoogle.setBounds(40, 195, 300, 30);
		contentPane.add(btnEntrarGoogle);

		btnCadastrar = new JButton("Não possui conta? Cadastre-se");
		btnCadastrar.setBounds(40, 235, 300, 30);
		contentPane.add(btnCadastrar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(40, 275, 300, 30);
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
