package view;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Classe base de todas as telas. Ja aplica o icone da janela (barra de titulo
 * e barra de tarefas). As telas fazem "extends Icone" no lugar de
 * "extends JFrame".
 *
 * O logo no topo das telas e um JLabel normal com "/images/logo.png", para
 * continuar editavel no WindowBuilder.
 */
public class Icone extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String CAMINHO_ICONE = "/images/icone.png";

	public Icone() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// icone da janela (barra de titulo e barra de tarefas)
		ImageIcon icone = carregarIcone(CAMINHO_ICONE, 64, 64);
		if (icone != null) {
			setIconImage(icone.getImage());
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
