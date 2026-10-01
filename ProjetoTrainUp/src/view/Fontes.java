package view;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * Fontes padrão do TrainUp. Todas as telas usam estas
 * constantes, para manter o mesmo tamanho e estilo em
 * todo o sistema.
 *
 * Os tamanhos crescem um pouco em monitores maiores
 * (ESCALA), para a tela cheia não ficar com letras pequenas.
 */
public final class Fontes {

    public static final String FAMILIA = "Segoe UI";

    public static final double ESCALA = calcularEscala();

    public static final Font DESTAQUE = criar(Font.BOLD, 64);
    public static final Font LOGO     = criar(Font.BOLD, 28);
    public static final Font TITULO   = criar(Font.BOLD, 34);
    public static final Font SUBTITULO = criar(Font.PLAIN, 17);
    public static final Font ROTULO   = criar(Font.BOLD, 13);
    public static final Font TEXTO    = criar(Font.PLAIN, 17);
    public static final Font BOTAO    = criar(Font.BOLD, 15);
    public static final Font CARD     = criar(Font.BOLD, 20);
    public static final Font PADRAO   = criar(Font.PLAIN, 14);

    private Fontes() {
    }

    /**
     * Converte um tamanho em pixels de acordo com a escala
     * da tela (usado para alturas de campos, margens etc.).
     */
    public static int px(int tamanho) {

        return (int) Math.round(tamanho * ESCALA);
    }

    private static Font criar(int estilo, int tamanho) {

        return new Font(FAMILIA, estilo, px(tamanho));
    }

    private static double calcularEscala() {

        if (GraphicsEnvironment.isHeadless()) {
            return 1.0;
        }

        int altura = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDisplayMode()
                .getHeight();

        double escala = altura / 900.0;

        return Math.max(1.0, Math.min(1.5, escala));
    }

    /**
     * Define a fonte padrão dos componentes que não
     * recebem uma fonte própria (mensagens do JOptionPane etc.).
     */
    public static void aplicarPadrao() {

        FontUIResource padrao = new FontUIResource(PADRAO);

        for (Object chave : UIManager.getLookAndFeelDefaults().keySet()) {

            if (chave.toString().endsWith(".font")) {
                UIManager.put(chave, padrao);
            }
        }
    }
}
