package view;

import static view.Fontes.px;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Registro;

public class TelaProgresso extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JLabel lblTreinos;
    private JLabel lblExercicios;
    private JLabel lblConcluidos;
    private JLabel lblSemana;

    private JList<Registro> listaHistorico;

    private DefaultListModel<Registro> modeloLista;

    private JButton btnVoltar;


    // =============================================
    // CONSTRUTOR
    // =============================================

    public TelaProgresso() {

        setTitle("TrainUp - Progresso");

        Icone.aplicar(this);

        contentPane = Estilo.criarFundo();

        setContentPane(contentPane);

        criarComponentes();

        Janela.configurar(this);
    }


    // =============================================
    // COMPONENTES
    // =============================================

    private void criarComponentes() {

        // =========================================
        // CABEÇALHO
        // =========================================

        btnVoltar = Estilo.criarBotaoCabecalho("VOLTAR");

        contentPane.add(
                Estilo.criarCabecalho(btnVoltar),
                BorderLayout.NORTH
        );


        JPanel conteudo = Estilo.criarPainel(new BorderLayout(0, px(25)));


        // =========================================
        // TÍTULO + RESUMO
        // =========================================

        JPanel topo = Estilo.criarPainel(new BorderLayout(0, px(25)));

        JPanel textos = Estilo.criarPainel(null);

        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        textos.add(Estilo.criarTitulo("Seu Progresso"));

        textos.add(Estilo.criarSubtitulo("Acompanhe sua evolução"));

        topo.add(textos, BorderLayout.NORTH);


        JPanel cards = Estilo.criarPainel(new GridLayout(1, 4, px(25), 0));

        lblTreinos = criarNumero();
        lblExercicios = criarNumero();
        lblConcluidos = criarNumero();
        lblSemana = criarNumero();

        cards.add(criarCard(lblTreinos, "TREINOS CRIADOS"));
        cards.add(criarCard(lblExercicios, "EXERCÍCIOS"));
        cards.add(criarCard(lblConcluidos, "TREINOS CONCLUÍDOS"));
        cards.add(criarCard(lblSemana, "ÚLTIMOS 7 DIAS"));

        topo.add(cards, BorderLayout.CENTER);

        conteudo.add(topo, BorderLayout.NORTH);


        // =========================================
        // HISTÓRICO
        // =========================================

        JPanel historico = Estilo.criarPainel(new BorderLayout());

        historico.add(
                Estilo.criarRotulo("HISTÓRICO DE TREINOS CONCLUÍDOS"),
                BorderLayout.NORTH
        );

        modeloLista = new DefaultListModel<>();

        listaHistorico = new JList<>(modeloLista);

        historico.add(
                Estilo.criarLista(listaHistorico),
                BorderLayout.CENTER
        );

        conteudo.add(historico, BorderLayout.CENTER);


        contentPane.add(conteudo, BorderLayout.CENTER);
    }


    private JLabel criarNumero() {

        JLabel label = new JLabel("0", SwingConstants.CENTER);

        label.setForeground(Estilo.ROXO);
        label.setFont(Fontes.DESTAQUE);

        return label;
    }


    private JPanel criarCard(JLabel numero, String texto) {

        JPanel card = new JPanel(new BorderLayout());

        card.setBackground(Estilo.PRETO_CLARO);

        card.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Estilo.ROXO, 2),
                        new EmptyBorder(px(20), px(10), px(20), px(10))
                )
        );

        JLabel legenda = Estilo.criarRotulo(texto);

        legenda.setHorizontalAlignment(SwingConstants.CENTER);

        card.add(numero, BorderLayout.CENTER);
        card.add(legenda, BorderLayout.SOUTH);

        return card;
    }


    // =============================================
    // PREENCHER DADOS
    // =============================================

    public void setResumo(
            int treinos,
            int exercicios,
            int concluidos,
            int semana
    ) {

        lblTreinos.setText(String.valueOf(treinos));
        lblExercicios.setText(String.valueOf(exercicios));
        lblConcluidos.setText(String.valueOf(concluidos));
        lblSemana.setText(String.valueOf(semana));
    }


    public void limparHistorico() {
        modeloLista.clear();
    }


    public void adicionarRegistro(
            Registro registro
    ) {
        modeloLista.addElement(registro);
    }


    // =============================================
    // GETTERS
    // =============================================

    public JButton getBtnVoltar() {
        return btnVoltar;
    }
}
