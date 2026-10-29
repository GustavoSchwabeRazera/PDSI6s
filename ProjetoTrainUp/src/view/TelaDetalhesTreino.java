package view;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import model.Exercicio;
import model.Treino;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;

public class TelaDetalhesTreino extends Icone {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<Exercicio> modeloLista;
	private JList<Exercicio> listaExercicios;
	private JButton btnAdicionarExercicio;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnExportar;
	private JButton btnVoltar;
	private JLabel lblTitulo;

	public TelaDetalhesTreino() {
		setTitle("TrainUp - Treino");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setMinimumSize(new Dimension(480, 340));
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// lista ocupa a coluna 0 (cresce); botoes na coluna 1 com largura fixa
		contentPane.setLayout(new MigLayout("insets 15", "[grow,fill]15[130!]", "[]5[]5[]10[]10[]10[]push[]"));
		setContentPane(contentPane);

		lblTitulo = new JLabel("Nome do treino");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblTitulo, "cell 0 0 2 1");

		JLabel lblExercicios = new JLabel("Exercícios deste treino:");
		lblExercicios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblExercicios, "cell 0 1 2 1");

		modeloLista = new DefaultListModel<>();
		listaExercicios = new JList<>(modeloLista);
		listaExercicios.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane(listaExercicios);
		contentPane.add(scrollPane, "cell 0 2 1 5, grow, push");

		btnAdicionarExercicio = new JButton("Adicionar");
		contentPane.add(btnAdicionarExercicio, "cell 1 2, growx, h 30!");

		btnEditar = new JButton("Editar");
		contentPane.add(btnEditar, "cell 1 3, growx, h 30!");

		btnExcluir = new JButton("Excluir");
		contentPane.add(btnExcluir, "cell 1 4, growx, h 30!");

		btnExportar = new JButton("Exportar PNG");
		contentPane.add(btnExportar, "cell 1 5, growx, h 30!");

		btnVoltar = new JButton("Voltar");
		contentPane.add(btnVoltar, "cell 1 6, growx, aligny bottom, h 30!");
	}

	public void setTreino(Treino treino) {
		setTitle("TrainUp - " + treino.getNome());
		lblTitulo.setText(treino.getNome());
	}

	public void limparExercicios() {
		modeloLista.clear();
	}

	public void adicionarExercicio(Exercicio exercicio) {
		modeloLista.addElement(exercicio);
	}

	public Exercicio getExercicioSelecionado() {
		return listaExercicios.getSelectedValue();
	}

	public JButton getBtnAdicionarExercicio() {
		return btnAdicionarExercicio;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public JButton getBtnExportar() {
		return btnExportar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
