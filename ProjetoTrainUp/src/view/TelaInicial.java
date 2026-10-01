package view;

import static view.Fontes.px;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TelaInicial extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JButton btnEntrar;
    private JButton btnCadastrar;
    private JButton btnSair;

    public TelaInicial() {

        setTitle("TrainUp");

        Icone.aplicar(this);

        contentPane = Estilo.criarFundo();

        setContentPane(contentPane);

        criarComponentes();

        Janela.configurar(this);
    }


    private void criarComponentes() {

        // =============================
        // CABEÇALHO (SAIR)
        // =============================

        btnSair = Estilo.criarBotaoCabecalho("SAIR");

        JPanel cabecalho = Estilo.criarPainel(new BorderLayout());

        cabecalho.add(btnSair, BorderLayout.EAST);

        contentPane.add(cabecalho, BorderLayout.NORTH);


        // =============================
        // CONTEÚDO
        // =============================

        JPanel formulario = Estilo.criarFormulario();


        // TÍTULO

        JLabel lblTitulo = new JLabel("TRAINUP", SwingConstants.CENTER);

        lblTitulo.setForeground(Estilo.ROXO);

        lblTitulo.setFont(Fontes.DESTAQUE);

        Estilo.adicionar(formulario, lblTitulo);


        // FRASE

        JLabel lblFrase = Estilo.criarSubtitulo(
                "Evolua seu treino. Acompanhe seu progresso."
        );

        lblFrase.setHorizontalAlignment(SwingConstants.CENTER);

        Estilo.adicionar(formulario, lblFrase);

        Estilo.espaco(formulario, 70);


        // BOTÕES

        btnEntrar = Estilo.criarBotaoPrimario("ENTRAR");

        btnCadastrar = Estilo.criarBotaoContorno("CRIAR CONTA");

        JPanel botoes = Estilo.criarPainel(new GridLayout(2, 1, 0, px(18)));

        botoes.add(btnEntrar);
        botoes.add(btnCadastrar);

        botoes.setPreferredSize(
                new Dimension(0, px(50) * 2 + px(18))
        );

        Estilo.adicionar(formulario, botoes);

        Estilo.espaco(formulario, 60);


        contentPane.add(
                Estilo.centralizar(formulario),
                BorderLayout.CENTER
        );
    }


    // =============================
    // GETTERS
    // =============================

    public JButton getBtnEntrar() {
        return btnEntrar;
    }

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    public JButton getBtnSair() {
        return btnSair;
    }
}
