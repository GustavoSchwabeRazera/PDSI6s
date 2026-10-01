package view;

import static view.Fontes.px;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import model.Exercicio;
import model.Treino;

public class TelaDetalhesTreino extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JLabel lblNomeTreino;

    private JList<Exercicio> listaExercicios;

    private DefaultListModel<Exercicio> modeloLista;

    private JButton btnAdicionarExercicio;
    private JButton btnConcluir;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnVoltar;


    // =============================================
    // CONSTRUTOR
    // =============================================

    public TelaDetalhesTreino(
            Treino treino
    ) {

        setTitle("TrainUp - " + treino.getNome());

        Icone.aplicar(this);

        contentPane = Estilo.criarFundo();

        setContentPane(contentPane);

        criarComponentes(treino);

        Janela.configurar(this);
    }


    // =============================================
    // COMPONENTES
    // =============================================

    private void criarComponentes(
            Treino treino
    ) {

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
        // NOME DO TREINO + ADICIONAR
        // =========================================

        JPanel topo = Estilo.criarPainel(new BorderLayout());

        JPanel textos = Estilo.criarPainel(null);

        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        lblNomeTreino = Estilo.criarTitulo(treino.getNome());

        textos.add(lblNomeTreino);

        textos.add(Estilo.criarSubtitulo("Exercícios deste treino"));

        topo.add(textos, BorderLayout.WEST);


        btnAdicionarExercicio =
                Estilo.criarBotaoPrimario("+ ADICIONAR EXERCÍCIO");

        btnAdicionarExercicio.setPreferredSize(
                new Dimension(px(260), px(50))
        );

        btnConcluir = Estilo.criarBotaoContorno("CONCLUIR TREINO");

        btnConcluir.setPreferredSize(
                new Dimension(px(240), px(50))
        );

        JPanel botoesTopo = Estilo.criarPainel(
                new GridLayout(1, 2, px(20), 0)
        );

        botoesTopo.add(btnConcluir);
        botoesTopo.add(btnAdicionarExercicio);

        JPanel areaAdicionar = Estilo.criarPainel(new GridBagLayout());

        areaAdicionar.add(botoesTopo);

        topo.add(areaAdicionar, BorderLayout.EAST);

        conteudo.add(topo, BorderLayout.NORTH);


        // =========================================
        // LISTA
        // =========================================

        modeloLista = new DefaultListModel<>();

        listaExercicios = new JList<>(modeloLista);

        conteudo.add(
                Estilo.criarLista(listaExercicios),
                BorderLayout.CENTER
        );


        // =========================================
        // EDITAR / EXCLUIR
        // =========================================

        JPanel botoes = Estilo.criarPainel(
                new GridLayout(1, 2, px(20), 0)
        );

        btnEditar = Estilo.criarBotaoSecundario("EDITAR");

        btnExcluir = Estilo.criarBotaoSecundario("EXCLUIR");

        botoes.add(btnEditar);
        botoes.add(btnExcluir);

        JPanel rodape = Estilo.criarPainel(new BorderLayout());

        rodape.add(botoes, BorderLayout.EAST);

        conteudo.add(rodape, BorderLayout.SOUTH);


        contentPane.add(conteudo, BorderLayout.CENTER);
    }


    // =============================================
    // LIMPAR
    // =============================================

    public void limparExercicios() {
        modeloLista.clear();
    }


    // =============================================
    // ADICIONAR
    // =============================================

    public void adicionarExercicio(
            Exercicio exercicio
    ) {
        modeloLista.addElement(exercicio);
    }


    // =============================================
    // SELECIONADO
    // =============================================

    public Exercicio getExercicioSelecionado() {
        return listaExercicios.getSelectedValue();
    }


    // =============================================
    // GETTERS
    // =============================================

    public JButton getBtnAdicionarExercicio() {
        return btnAdicionarExercicio;
    }

    public JButton getBtnConcluir() {
        return btnConcluir;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }

    public JList<Exercicio> getListaExercicios() {
        return listaExercicios;
    }
}
