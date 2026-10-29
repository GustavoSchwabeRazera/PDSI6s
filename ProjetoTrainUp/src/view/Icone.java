package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent;

/**
 * Classe base de todas as telas. Ja aplica o icone da janela (barra de titulo
 * e barra de tarefas) e a barra de menus (Arquivo e Ajuda). As telas fazem
 * "extends Icone" no lugar de "extends JFrame".
 *
 * O logo no topo das telas e um JLabel normal com "/images/logo.png", para
 * continuar editavel no WindowBuilder.
 */
public class Icone extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String CAMINHO_ICONE = "/images/icone.png";

	// Itens do menu: o controller tambem precisa alcanca-los.
	private JMenuItem miLimpar;
	private JMenuItem miSair;
	private JMenuItem miManual;
	private JMenuItem miSobre;

	public Icone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// icone da janela (barra de titulo e barra de tarefas)
		ImageIcon icone = carregarIcone(CAMINHO_ICONE, 64, 64);
		if (icone != null) {
			setIconImage(icone.getImage());
		}

		// ---------- o menu ----------
		setJMenuBar(criarMenu());
	}

	/** Monta a barra de menus: Arquivo e Ajuda. */
	private JMenuBar criarMenu() {
		JMenuBar barra = new JMenuBar();

		// ---- menu Arquivo ----
		JMenu menuArquivo = new JMenu("Arquivo");
		menuArquivo.setMnemonic(KeyEvent.VK_A); // Alt+A abre o menu

		miLimpar = new JMenuItem("Limpar campos");
		miLimpar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		menuArquivo.add(miLimpar);

		menuArquivo.addSeparator(); // linha divisoria

		miSair = new JMenuItem("Sair");
		miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		menuArquivo.add(miSair);

		// ---- menu Ajuda ----
		JMenu menuAjuda = new JMenu("Ajuda");
		menuAjuda.setMnemonic(KeyEvent.VK_J); // o A ja e do Arquivo

		miManual = new JMenuItem("Manual de uso");
		miManual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menuAjuda.add(miManual);

		miSobre = new JMenuItem("Sobre");
		menuAjuda.add(miSobre);

		barra.add(menuArquivo);
		barra.add(menuAjuda);
		return barra;
	}

	public JMenuItem getMiLimpar() {
		return miLimpar;
	}

	public JMenuItem getMiSair() {
		return miSair;
	}

	public JMenuItem getMiManual() {
		return miManual;
	}

	public JMenuItem getMiSobre() {
		return miSobre;
	}

	public void mostrarSobre() {
		new JanelaSobre(this).setVisible(true);
	}

	public void mostrarManual() {
		new JanelaManual(this).setVisible(true);
	}

	/** Esvazia todos os campos de texto da tela (serve para qualquer tela). */
	public void limparCampos() {
		limparCampos(getContentPane());
	}

	private void limparCampos(Container painel) {
		for (Component c : painel.getComponents()) {
			if (c instanceof JTextComponent campo && campo.isEditable()) {
				campo.setText("");
			} else if (c instanceof Container filho) {
				limparCampos(filho);
			}
		}
	}

	/**
	 * Carrega uma imagem de dentro do projeto e ajusta ao tamanho pedido,
	 * mantendo a proporcao. Devolve null se o arquivo nao for encontrado.
	 */
	protected ImageIcon carregarIcone(String caminho, int largura, int altura) {
		URL url = Icone.class.getResource(caminho);
		if (url == null) {
			System.err.println("Imagem nao encontrada: " + caminho);
			return null;
		}
		ImageIcon original = new ImageIcon(url);
		double escala = Math.min((double) largura / original.getIconWidth(),
				(double) altura / original.getIconHeight());
		int w = (int) (original.getIconWidth() * escala);
		int h = (int) (original.getIconHeight() * escala);
		Image reduzida = original.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		return new ImageIcon(reduzida);
	}
}
