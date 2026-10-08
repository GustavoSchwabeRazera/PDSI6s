package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class TelaCriarTreino extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JButton btnSalvar;
	private JButton btnVoltar;

	public TelaCriarTreino() {
		setTitle("TrainUp - Novo Treino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 220);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Novo treino");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(30, 15, 300, 30);
		contentPane.add(lblTitulo);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(30, 60, 70, 25);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(100, 60, 250, 25);
		contentPane.add(txtNome);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(30, 110, 150, 30);
		contentPane.add(btnSalvar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(200, 110, 150, 30);
		contentPane.add(btnVoltar);
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
