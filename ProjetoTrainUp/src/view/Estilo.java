package view;

import static view.Fontes.px;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 * Cores e componentes padrão do TrainUp. As telas usam
 * estes métodos para ficarem todas com o mesmo visual.
 */
public final class Estilo {

    // =============================================
    // CORES
    // =============================================

    public static final Color PRETO =
            new Color(18, 18, 18);

    public static final Color PRETO_CLARO =
            new Color(30, 30, 30);

    public static final Color ROXO =
            new Color(138, 43, 226);

    public static final Color BRANCO =
            new Color(245, 245, 245);

    public static final Color CINZA =
            new Color(180, 180, 180);

    private Estilo() {
    }

    // =============================================
    // ESTRUTURA DA TELA
    // =============================================

    /**
     * Painel de fundo da tela, que ocupa o monitor inteiro.
     * O cabeçalho vai no NORTH e o conteúdo no CENTER.
     */
    public static JPanel criarFundo() {

        JPanel fundo = new JPanel(new BorderLayout(0, px(30)));

        fundo.setBackground(PRETO);

        fundo.setBorder(
                new EmptyBorder(px(30), px(60), px(40), px(60))
        );

        return fundo;
    }

    /**
     * Cabeçalho com o logo à esquerda e um botão
     * (VOLTAR ou SAIR) à direita.
     */
    public static JPanel criarCabecalho(JButton botaoDireita) {

        JPanel cabecalho = criarPainel(new BorderLayout());

        cabecalho.add(criarLogo(), BorderLayout.WEST);

        if (botaoDireita != null) {
            cabecalho.add(botaoDireita, BorderLayout.EAST);
        }

        return cabecalho;
    }

    /**
     * Painel transparente (deixa aparecer o fundo preto).
     */
    public static JPanel criarPainel(LayoutManager layout) {

        JPanel painel = new JPanel(layout);

        painel.setOpaque(false);

        return painel;
    }

    /**
     * Coluna de formulário (componentes um embaixo do outro).
     * A largura acompanha o tamanho do monitor.
     */
    public static JPanel criarFormulario() {

        JPanel formulario = criarPainel(null);

        formulario.setLayout(
                new BoxLayout(formulario, BoxLayout.Y_AXIS)
        );

        int larguraTela =
                Toolkit.getDefaultToolkit().getScreenSize().width;

        int largura = Math.max(px(420), Math.min(px(720), (int) (larguraTela * 0.38)));

        formulario.putClientProperty("largura", largura);

        return formulario;
    }

    /**
     * Coloca o componente no centro do espaço disponível.
     */
    public static JPanel centralizar(JComponent componente) {

        JPanel centro = criarPainel(new GridBagLayout());

        centro.add(componente);

        return centro;
    }

    /**
     * Adiciona um componente ao formulário, ocupando
     * toda a largura da coluna.
     */
    public static void adicionar(JPanel formulario, JComponent componente) {

        int largura = (Integer) formulario.getClientProperty("largura");

        Dimension tamanho = componente.getPreferredSize();

        componente.setAlignmentX(Component.LEFT_ALIGNMENT);

        componente.setPreferredSize(new Dimension(largura, tamanho.height));
        componente.setMaximumSize(new Dimension(largura, tamanho.height));

        formulario.add(componente);
    }

    /**
     * Espaço vertical entre componentes do formulário.
     */
    public static void espaco(JPanel formulario, int altura) {

        formulario.add(Box.createVerticalStrut(px(altura)));
    }

    // =============================================
    // TEXTOS
    // =============================================

    public static JLabel criarLogo() {

        JLabel lblLogo = new JLabel("TRAINUP");

        lblLogo.setForeground(ROXO);
        lblLogo.setFont(Fontes.LOGO);

        return lblLogo;
    }

    public static JLabel criarTitulo(String texto) {

        JLabel label = new JLabel(texto);

        label.setForeground(BRANCO);
        label.setFont(Fontes.TITULO);

        return label;
    }

    public static JLabel criarSubtitulo(String texto) {

        JLabel label = new JLabel(texto);

        label.setForeground(CINZA);
        label.setFont(Fontes.SUBTITULO);

        return label;
    }

    public static JLabel criarRotulo(String texto) {

        JLabel label = new JLabel(texto);

        label.setForeground(CINZA);
        label.setFont(Fontes.ROTULO);

        label.setBorder(new EmptyBorder(0, 0, px(6), 0));

        return label;
    }

    // =============================================
    // CAMPOS
    // =============================================

    public static JTextField criarCampo() {

        JTextField campo = new JTextField();

        configurarCampo(campo);

        return campo;
    }

    public static JPasswordField criarCampoSenha() {

        JPasswordField campo = new JPasswordField();

        configurarCampo(campo);

        return campo;
    }

    private static void configurarCampo(JTextField campo) {

        campo.setFont(Fontes.TEXTO);
        campo.setForeground(BRANCO);
        campo.setBackground(PRETO_CLARO);
        campo.setCaretColor(BRANCO);

        campo.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(ROXO, 1),
                        new EmptyBorder(0, px(12), 0, px(12))
                )
        );

        campo.setPreferredSize(new Dimension(px(300), px(48)));
    }

    // =============================================
    // BOTÕES
    // =============================================

    /**
     * Botão principal (roxo).
     */
    public static JButton criarBotaoPrimario(String texto) {

        JButton botao = criarBotao(texto, ROXO, BRANCO);

        botao.setBorder(BorderFactory.createLineBorder(ROXO, 1));

        return botao;
    }

    /**
     * Botão secundário (cinza escuro).
     */
    public static JButton criarBotaoSecundario(String texto) {

        JButton botao = criarBotao(texto, PRETO_CLARO, BRANCO);

        botao.setBorder(
                BorderFactory.createLineBorder(new Color(70, 70, 70), 1)
        );

        return botao;
    }

    /**
     * Botão com contorno roxo e fundo preto.
     */
    public static JButton criarBotaoContorno(String texto) {

        JButton botao = criarBotao(texto, PRETO, ROXO);

        botao.setBorder(BorderFactory.createLineBorder(ROXO, 1));

        return botao;
    }

    /**
     * Botão pequeno do cabeçalho (VOLTAR / SAIR).
     */
    public static JButton criarBotaoCabecalho(String texto) {

        JButton botao = criarBotaoSecundario(texto);

        botao.setPreferredSize(new Dimension(px(130), px(40)));

        return botao;
    }

    /**
     * Botão que parece um link (só texto).
     */
    public static JButton criarBotaoLink(String texto, Color cor) {

        JButton botao = criarBotao(texto, PRETO, cor);

        botao.setFont(Fontes.SUBTITULO);
        botao.setBorder(null);
        botao.setContentAreaFilled(false);

        botao.setPreferredSize(new Dimension(px(300), px(32)));

        return botao;
    }

    private static JButton criarBotao(String texto, Color fundo, Color letra) {

        JButton botao = new JButton(texto);

        botao.setFont(Fontes.BOTAO);
        botao.setBackground(fundo);
        botao.setForeground(letra);
        botao.setFocusPainted(false);
        botao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        botao.setPreferredSize(new Dimension(px(220), px(50)));

        return botao;
    }

    // =============================================
    // LISTAS
    // =============================================

    public static <T> JScrollPane criarLista(JList<T> lista) {

        lista.setBackground(PRETO_CLARO);
        lista.setForeground(BRANCO);
        lista.setFont(Fontes.TEXTO);
        lista.setFixedCellHeight(px(54));
        lista.setSelectionBackground(ROXO);
        lista.setSelectionForeground(BRANCO);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lista.setCellRenderer(new DefaultListCellRenderer() {

            private static final long serialVersionUID = 1L;

            @Override
            public Component getListCellRendererComponent(
                    JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {

                JLabel label = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus
                );

                label.setBorder(new EmptyBorder(0, px(20), 0, px(20)));

                return label;
            }
        });

        JScrollPane scrollPane = new JScrollPane(lista);

        scrollPane.setBorder(BorderFactory.createLineBorder(ROXO, 1));
        scrollPane.getViewport().setBackground(PRETO_CLARO);

        return scrollPane;
    }
}
