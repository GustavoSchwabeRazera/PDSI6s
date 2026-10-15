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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaHome extends Icone {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBemVindo;
	private JButton btnTreinos;
	private JButton btnSair;

	public TelaHome() {
		setTitle("TrainUp - Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 360);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaHome.class.getResource("/images/logo.png")));
		lblLogo.setBounds(152, 10, 80, 80);
		contentPane.add(lblLogo);

		lblBemVindo = new JLabel("Bem-vindo ao TrainUp");
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBemVindo.setBounds(20, 120, 350, 30);
		contentPane.add(lblBemVindo);

		JLabel lblPergunta = new JLabel("O que você deseja fazer hoje?");
		lblPergunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPergunta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPergunta.setBounds(20, 155, 350, 20);
		contentPane.add(lblPergunta);

		btnTreinos = new JButton("Meus treinos");
		
		btnTreinos.setBackground(new Color(255, 255, 255));
		btnTreinos.setBounds(100, 200, 190, 35);
		contentPane.add(btnTreinos);

		btnSair = new JButton("Sair");
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setBounds(100, 245, 190, 30);
		contentPane.add(btnSair);
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
