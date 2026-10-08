package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnEntrar;
	private JButton btnCadastrar;
	private JButton btnSair;

	public TelaInicial() {
		setTitle("TrainUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 320);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("TrainUp");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblTitulo.setBounds(50, 30, 290, 40);
		contentPane.add(lblTitulo);

		JLabel lblFrase = new JLabel("Evolua seu treino.");
		lblFrase.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrase.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFrase.setBounds(50, 75, 290, 20);
		contentPane.add(lblFrase);

		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(100, 120, 190, 30);
		contentPane.add(btnEntrar);

		btnCadastrar = new JButton("Criar conta");
		btnCadastrar.setBounds(100, 160, 190, 30);
		contentPane.add(btnCadastrar);

		btnSair = new JButton("Sair");
		btnSair.setBounds(100, 200, 190, 30);
		contentPane.add(btnSair);
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
