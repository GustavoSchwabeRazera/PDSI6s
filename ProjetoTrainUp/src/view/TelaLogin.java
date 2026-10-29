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
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;

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
		setBounds(100, 100, 400, 485);
		setMinimumSize(new Dimension(360, 465));
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// coluna 0 = rotulos, coluna 1 = campos (cresce com a janela)
		contentPane.setLayout(new MigLayout("insets 20 35 20 35", "[70!][grow,fill]",
				"push[]20[]20[]10[]20[]10[]10[]10[]push"));
		setContentPane(contentPane);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/images/logo.png")));
		contentPane.add(lblLogo, "cell 0 0 2 1, alignx center");

		JLabel lblTitulo = new JLabel("Entrar");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblTitulo, "cell 0 1 2 1, alignx center");

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblEmail, "cell 0 2");

		txtEmail = new JTextField();
		contentPane.add(txtEmail, "cell 1 2, h 25!");

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblSenha, "cell 0 3");

		txtSenha = new JPasswordField();
		contentPane.add(txtSenha, "cell 1 3, h 25!");

		btnEntrar = new JButton("Entrar");
		contentPane.add(btnEntrar, "cell 0 4 2 1, growx, h 30!");

		btnEntrarGoogle = new JButton("Entrar com Google");
		contentPane.add(btnEntrarGoogle, "cell 0 5 2 1, growx, h 30!");

		btnCadastrar = new JButton("Não possui conta? Cadastre-se");
		contentPane.add(btnCadastrar, "cell 0 6 2 1, growx, h 30!");

		btnVoltar = new JButton("Voltar");
		contentPane.add(btnVoltar, "cell 0 7 2 1, growx, h 30!");
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
