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

public class TelaDetalhesTreino extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<Exercicio> modeloLista;
	private JList<Exercicio> listaExercicios;
	private JButton btnAdicionarExercicio;
	private JButton btnEditar;
	private JButton btnExcluir;
	private JButton btnVoltar;

	public TelaDetalhesTreino(Treino treino) {
		setTitle("TrainUp - " + treino.getNome());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel(treino.getNome());
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(20, 15, 400, 30);
		contentPane.add(lblTitulo);

		JLabel lblExercicios = new JLabel("Exercícios deste treino:");
		lblExercicios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExercicios.setBounds(20, 50, 300, 20);
		contentPane.add(lblExercicios);

		modeloLista = new DefaultListModel<>();
		listaExercicios = new JList<>(modeloLista);
		listaExercicios.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane(listaExercicios);
		scrollPane.setBounds(20, 75, 400, 260);
		contentPane.add(scrollPane);

		btnAdicionarExercicio = new JButton("Adicionar");
		btnAdicionarExercicio.setBounds(435, 75, 130, 30);
		contentPane.add(btnAdicionarExercicio);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(435, 115, 130, 30);
		contentPane.add(btnEditar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(435, 155, 130, 30);
		contentPane.add(btnExcluir);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(435, 305, 130, 30);
		contentPane.add(btnVoltar);
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

	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
