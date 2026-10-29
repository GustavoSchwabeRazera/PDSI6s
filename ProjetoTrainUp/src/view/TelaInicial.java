package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;

public class TelaInicial extends Icone {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEntrar;
	private JButton btnCadastrar;
	private JButton btnSair;

	public TelaInicial() {
		setTitle("TrainUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 410);
		setMinimumSize(new Dimension(320, 380));
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// coluna unica centralizada; "push" em cima e embaixo centraliza na vertical
		contentPane.setLayout(new MigLayout("insets 20", "[grow,center]", "push[]20[]5[]25[]10[]10[]push"));
		setContentPane(contentPane);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaInicial.class.getResource("/images/logo.png")));
		contentPane.add(lblLogo, "cell 0 0");

		JLabel lblTitulo = new JLabel("TrainUp");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
		contentPane.add(lblTitulo, "cell 0 1");

		JLabel lblFrase = new JLabel("Evolua seu treino.");
		lblFrase.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblFrase, "cell 0 2");

		btnEntrar = new JButton("Entrar");
		contentPane.add(btnEntrar, "cell 0 3, growx, wmin 190, wmax 350, h 30!");

		btnCadastrar = new JButton("Criar conta");
		contentPane.add(btnCadastrar, "cell 0 4, growx, wmin 190, wmax 350, h 30!");

		btnSair = new JButton("Sair");
		contentPane.add(btnSair, "cell 0 5, growx, wmin 190, wmax 350, h 30!");
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnSair() {
		return btnSair;
	}
}
