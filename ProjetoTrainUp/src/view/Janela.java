package view;

import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

/**
 * Abre as telas ocupando o monitor inteiro.
 */
public final class Janela {

    /**
     * true  = tela cheia, sem barra de título (ESC fecha o sistema).
     * false = apenas maximizada, com barra de título.
     */
    public static final boolean TELA_CHEIA = true;

    private Janela() {
    }

    /**
     * Deve ser chamado no fim do construtor de cada tela.
     */
    public static void configurar(JFrame frame) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setResizable(true);

        if (TELA_CHEIA) {

            frame.setUndecorated(true);

            frame.getRootPane()
                    .getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                    .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "fechar");

            frame.getRootPane()
                    .getActionMap()
                    .put("fechar", new AbstractAction() {

                        private static final long serialVersionUID = 1L;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            frame.dispatchEvent(
                                    new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)
                            );
                        }
                    });
        }

        GraphicsEnvironment ge =
                GraphicsEnvironment.getLocalGraphicsEnvironment();

        frame.setBounds(
                TELA_CHEIA
                        ? ge.getDefaultScreenDevice()
                                .getDefaultConfiguration().getBounds()
                        : ge.getMaximumWindowBounds()
        );

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
