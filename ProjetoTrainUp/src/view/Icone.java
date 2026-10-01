package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Define o ícone das janelas do TrainUp.
 *
 * Usa a imagem src/images/icone.png. Se ela não existir,
 * desenha um ícone padrão (letra "T" roxa em fundo escuro).
 */
public final class Icone {

    private static final String CAMINHO = "/images/icone.png";

    private static List<Image> imagens;

    private Icone() {
    }

    public static void aplicar(JFrame frame) {

        frame.setIconImages(getImagens());
    }

    private static List<Image> getImagens() {

        if (imagens == null) {

            imagens = new ArrayList<>();

            URL url = Icone.class.getResource(CAMINHO);

            if (url != null) {

                imagens.add(new ImageIcon(url).getImage());

            } else {

                System.err.println("Ícone não encontrado: " + CAMINHO);

                for (int tamanho : new int[] {16, 32, 48, 64, 128}) {
                    imagens.add(desenhar(tamanho));
                }
            }
        }

        return imagens;
    }

    private static Image desenhar(int tamanho) {

        BufferedImage img = new BufferedImage(
                tamanho, tamanho, BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g = img.createGraphics();

        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );

        int arco = tamanho / 4;

        g.setColor(Estilo.PRETO);
        g.fillRoundRect(0, 0, tamanho, tamanho, arco, arco);

        g.setColor(Estilo.ROXO);
        g.setStroke(new BasicStroke(Math.max(1f, tamanho / 16f)));
        g.drawRoundRect(0, 0, tamanho - 1, tamanho - 1, arco, arco);

        g.setFont(new Font("Arial", Font.BOLD, (int) (tamanho * 0.75)));

        FontMetrics fm = g.getFontMetrics();

        String texto = "T";

        int x = (tamanho - fm.stringWidth(texto)) / 2;
        int y = (tamanho - fm.getHeight()) / 2 + fm.getAscent();

        g.drawString(texto, x, y);

        g.dispose();

        return img;
    }
}
