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

public class TelaCadastro extends Icone {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 490);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/logo.png")));
		lblLogo.setBounds(162, 10, 80, 80);
		contentPane.add(lblLogo);

		JLabel lblTitulo = new JLabel("Criar conta");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitulo.setBounds(50, 110, 310, 30);
		contentPane.add(lblTitulo);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(30, 160, 130, 25);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(160, 160, 210, 25);
		contentPane.add(txtNome);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(30, 195, 130, 25);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(160, 195, 210, 25);
		contentPane.add(txtEmail);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdade.setBounds(30, 230, 130, 25);
		contentPane.add(lblIdade);

		txtIdade = new JTextField();
		txtIdade.setBounds(160, 230, 80, 25);
		contentPane.add(txtIdade);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(30, 265, 130, 25);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(160, 265, 210, 25);
		contentPane.add(txtSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmarSenha.setBounds(30, 300, 130, 25);
		contentPane.add(lblConfirmarSenha);

		txtConfirmarSenha = new JPasswordField();
		txtConfirmarSenha.setBounds(160, 300, 210, 25);
		contentPane.add(txtConfirmarSenha);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(30, 350, 340, 30);
		contentPane.add(btnCadastrar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(30, 390, 340, 30);
		contentPane.add(btnVoltar);
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

	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
