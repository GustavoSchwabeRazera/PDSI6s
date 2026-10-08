package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class TelaAdicionarExercicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSeries;
	private JTextField txtRepeticoes;
	private JButton btnSalvar;
	private JButton btnVoltar;

	public TelaAdicionarExercicio() {
		setTitle("TrainUp - Exercício");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 290);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Exercício");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(30, 15, 300, 30);
		contentPane.add(lblTitulo);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(30, 60, 100, 25);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(130, 60, 220, 25);
		contentPane.add(txtNome);

		JLabel lblSeries = new JLabel("Séries:");
		lblSeries.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeries.setBounds(30, 95, 100, 25);
		contentPane.add(lblSeries);

		txtSeries = new JTextField();
		txtSeries.setBounds(130, 95, 80, 25);
		contentPane.add(txtSeries);

		JLabel lblRepeticoes = new JLabel("Repetições:");
		lblRepeticoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRepeticoes.setBounds(30, 130, 100, 25);
		contentPane.add(lblRepeticoes);

		txtRepeticoes = new JTextField();
		txtRepeticoes.setBounds(130, 130, 80, 25);
		contentPane.add(txtRepeticoes);

		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(30, 180, 150, 30);
		contentPane.add(btnSalvar);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(200, 180, 150, 30);
		contentPane.add(btnVoltar);
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextField getTxtSeries() {
		return txtSeries;
	}

	public JTextField getTxtRepeticoes() {
		return txtRepeticoes;
	}

	public JButton getBtnSalvar() {
		return btnSalvar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
