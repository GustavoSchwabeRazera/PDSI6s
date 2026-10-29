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
		setBounds(100, 100, 420, 515);
		setMinimumSize(new Dimension(380, 495));
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// coluna 0 = rotulos, coluna 1 = campos (cresce com a janela)
		contentPane.setLayout(new MigLayout("insets 20 25 20 25", "[130!][grow,fill]",
				"push[]15[]15[]10[]10[]10[]10[]20[]10[]push"));
		setContentPane(contentPane);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/logo.png")));
		contentPane.add(lblLogo, "cell 0 0 2 1, alignx center");

		JLabel lblTitulo = new JLabel("Criar conta");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		contentPane.add(lblTitulo, "cell 0 1 2 1, alignx center");

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNome, "cell 0 2");

		txtNome = new JTextField();
		contentPane.add(txtNome, "cell 1 2, h 25!");

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblEmail, "cell 0 3");

		txtEmail = new JTextField();
		contentPane.add(txtEmail, "cell 1 3, h 25!");

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblIdade, "cell 0 4");

		txtIdade = new JTextField();
		contentPane.add(txtIdade, "cell 1 4, w 80!, h 25!");

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblSenha, "cell 0 5");

		txtSenha = new JPasswordField();
		contentPane.add(txtSenha, "cell 1 5, h 25!");

		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblConfirmarSenha, "cell 0 6");

		txtConfirmarSenha = new JPasswordField();
		contentPane.add(txtConfirmarSenha, "cell 1 6, h 25!");

		btnCadastrar = new JButton("Cadastrar");
		contentPane.add(btnCadastrar, "cell 0 7 2 1, growx, h 30!");

		btnVoltar = new JButton("Voltar");
		contentPane.add(btnVoltar, "cell 0 8 2 1, growx, h 30!");
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
