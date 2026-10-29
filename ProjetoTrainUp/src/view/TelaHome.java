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

public class TelaHome extends Icone {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBemVindo;
	private JButton btnTreinos;
	private JButton btnSair;

	public TelaHome() {
		setTitle("TrainUp - Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 385);
		setMinimumSize(new Dimension(320, 365));
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new MigLayout("insets 20", "[grow,center]", "push[]25[]5[]25[]10[]push"));
		setContentPane(contentPane);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaHome.class.getResource("/images/logo.png")));
		contentPane.add(lblLogo, "cell 0 0");

		lblBemVindo = new JLabel("Bem-vindo ao TrainUp");
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblBemVindo, "cell 0 1");

		JLabel lblPergunta = new JLabel("O que você deseja fazer hoje?");
		lblPergunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPergunta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblPergunta, "cell 0 2");

		btnTreinos = new JButton("Meus treinos");
		btnTreinos.setBackground(new Color(255, 255, 255));
		contentPane.add(btnTreinos, "cell 0 3, growx, wmin 190, wmax 350, h 35!");

		btnSair = new JButton("Sair");
		btnSair.setBackground(new Color(255, 255, 255));
		contentPane.add(btnSair, "cell 0 4, growx, wmin 190, wmax 350, h 30!");
	}

	public void setNomeUsuario(String nome) {
		lblBemVindo.setText("Olá, " + nome + "!");
	}

	public JButton getBtnTreinos() {
		return btnTreinos;
	}

	public JButton getBtnSair() {
		return btnSair;
	}
}
