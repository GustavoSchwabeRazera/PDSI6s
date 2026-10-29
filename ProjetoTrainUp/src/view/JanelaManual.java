package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

/**
 * VIEW - janela do manual de uso.
 *
 * O texto do manual NAO esta aqui: esta no arquivo manual/manual.html,
 * dentro do projeto. Para corrigir o manual, edita-se o HTML.
 */
public class JanelaManual extends JDialog {

	private static final long serialVersionUID = 1L;

	private static final String ARQUIVO = "/manual/manual.html";

	public JanelaManual(JFrame dono) {
		super(dono, "Manual de uso", true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(600, 500);
		setMinimumSize(new Dimension(400, 300));
		setLocationRelativeTo(dono);

		JPanel contentPane = new JPanel(new BorderLayout(0, 10));
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);

		// ---------- CENTER: o manual, com barra de rolagem ----------
		JEditorPane editor = new JEditorPane();
		editor.setEditable(false); // so leitura
		carregar(editor);
		contentPane.add(new JScrollPane(editor), BorderLayout.CENTER);

		// ---------- SOUTH: botao ----------
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(e -> dispose());
		JPanel painelBotao = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		painelBotao.setOpaque(false);
		painelBotao.add(btnFechar);
		contentPane.add(painelBotao, BorderLayout.SOUTH);

		getRootPane().registerKeyboardAction(e -> dispose(),
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
				JComponent.WHEN_IN_FOCUSED_WINDOW);
	}

	/** Carrega o HTML de dentro do projeto; se falhar, mostra um aviso. */
	private void carregar(JEditorPane editor) {
		URL url = JanelaManual.class.getResource(ARQUIVO);
		if (url == null) {
			editor.setContentType("text/plain");
			editor.setText("Manual não encontrado: " + ARQUIVO);
			return;
		}
		// o HTML carrega em segundo plano; quando terminar, volta para o topo
		editor.addPropertyChangeListener("page", e -> editor.setCaretPosition(0));
		try {
			editor.setPage(url); // detecta que e HTML pela extensao
		} catch (IOException erro) {
			editor.setContentType("text/plain");
			editor.setText("Não foi possível abrir o manual: " + erro.getMessage());
		}
	}
}
