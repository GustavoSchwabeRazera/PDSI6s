package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;

public class TelaAdicionarExercicio extends Icone {

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
		setBounds(100, 100, 400, 315);
		setMinimumSize(new Dimension(360, 305));
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// coluna 0 = rotulos, coluna 1 = campos (cresce com a janela)
		contentPane.setLayout(new MigLayout("insets 15 25 15 25", "[100!][grow,fill]", "[]15[]10[]10[]push[]"));
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Exercício");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblTitulo, "cell 0 0 2 1");

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNome, "cell 0 1");

		txtNome = new JTextField();
		contentPane.add(txtNome, "cell 1 1, h 25!");

		JLabel lblSeries = new JLabel("Séries:");
		lblSeries.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblSeries, "cell 0 2");

		txtSeries = new JTextField();
		contentPane.add(txtSeries, "cell 1 2, w 80!, h 25!");

		JLabel lblRepeticoes = new JLabel("Repetições:");
		lblRepeticoes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblRepeticoes, "cell 0 3");

		txtRepeticoes = new JTextField();
		contentPane.add(txtRepeticoes, "cell 1 3, w 80!, h 25!");

		// os dois botoes dividem a largura da linha igualmente
		btnSalvar = new JButton("Salvar");
		contentPane.add(btnSalvar, "cell 0 4 2 1, split 2, growx, sg botoes, h 30!");

		btnVoltar = new JButton("Voltar");
		contentPane.add(btnVoltar, "cell 0 4, growx, sg botoes, h 30!");
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
