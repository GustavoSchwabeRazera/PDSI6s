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

import model.Treino;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;

public class TelaTreinos extends Icone {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<Treino> modeloLista;
	private JList<Treino> listaTreinos;
	private JButton btnNovoTreino;
	private JButton btnAbrir;
	private JButton btnExcluir;
	private JButton btnVoltar;

	public TelaTreinos() {
		setTitle("TrainUp - Meus Treinos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 425);
		setMinimumSize(new Dimension(420, 345));
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// lista ocupa a coluna 0 (cresce); botoes na coluna 1 com largura fixa
		contentPane.setLayout(new MigLayout("insets 15", "[grow,fill]15[115!]", "[]10[]10[]10[]push[]"));
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Meus treinos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblTitulo, "cell 0 0 2 1");

		modeloLista = new DefaultListModel<>();
		listaTreinos = new JList<>(modeloLista);
		listaTreinos.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane(listaTreinos);
		contentPane.add(scrollPane, "cell 0 1 1 4, grow, push");

		btnNovoTreino = new JButton("Novo treino");
		contentPane.add(btnNovoTreino, "cell 1 1, growx, h 30!");

		btnAbrir = new JButton("Abrir");
		contentPane.add(btnAbrir, "cell 1 2, growx, h 30!");

		btnExcluir = new JButton("Excluir");
		contentPane.add(btnExcluir, "cell 1 3, growx, h 30!");

		btnVoltar = new JButton("Voltar");
		contentPane.add(btnVoltar, "cell 1 4, growx, aligny bottom, h 30!");
	}

	public void limparTreinos() {
		modeloLista.clear();
	}

	public void adicionarTreino(Treino treino) {
		modeloLista.addElement(treino);
	}

	public Treino getTreinoSelecionado() {
		return listaTreinos.getSelectedValue();
	}

	public JButton getBtnNovoTreino() {
		return btnNovoTreino;
	}

	public JButton getBtnAbrir() {
		return btnAbrir;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}
}
