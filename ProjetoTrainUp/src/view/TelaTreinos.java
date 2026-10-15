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
		setBounds(100, 100, 480, 400);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Meus treinos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(20, 15, 300, 30);
		contentPane.add(lblTitulo);

		modeloLista = new DefaultListModel<>();
		listaTreinos = new JList<>(modeloLista);
		listaTreinos.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane(listaTreinos);
		scrollPane.setBounds(20, 55, 300, 280);
		contentPane.add(scrollPane);

		btnNovoTreino = new JButton("Novo treino");
		btnNovoTreino.setBounds(335, 55, 115, 30);
		contentPane.add(btnNovoTreino);

		btnAbrir = new JButton("Abrir");
		btnAbrir.setBounds(335, 95, 115, 30);
		contentPane.add(btnAbrir);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(335, 135, 115, 30);
		contentPane.add(btnExcluir);

		btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(335, 305, 115, 30);
		contentPane.add(btnVoltar);
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
