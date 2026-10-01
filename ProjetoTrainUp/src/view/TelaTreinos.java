package view;

import static view.Fontes.px;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import model.Treino;

public class TelaTreinos extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JList<Treino> listaTreinos;

    private DefaultListModel<Treino> modeloLista;

    private JButton btnNovoTreino;
    private JButton btnAbrir;
    private JButton btnExcluir;
    private JButton btnVoltar;


    // =============================================
    // CONSTRUTOR
    // =============================================

    public TelaTreinos() {

        setTitle("TrainUp - Meus Treinos");

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
        // TÍTULO + NOVO TREINO
        // =========================================

        JPanel topo = Estilo.criarPainel(new BorderLayout());

        JPanel textos = Estilo.criarPainel(null);

        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        textos.add(Estilo.criarTitulo("Meus Treinos"));

        textos.add(Estilo.criarSubtitulo("Gerencie seus treinos"));

        topo.add(textos, BorderLayout.WEST);


        btnNovoTreino = Estilo.criarBotaoPrimario("+ NOVO TREINO");

        JPanel areaNovo = Estilo.criarPainel(new GridBagLayout());

        areaNovo.add(btnNovoTreino);

        topo.add(areaNovo, BorderLayout.EAST);

        conteudo.add(topo, BorderLayout.NORTH);


        // =========================================
        // LISTA
        // =========================================

        modeloLista = new DefaultListModel<>();

        listaTreinos = new JList<>(modeloLista);

        conteudo.add(
                Estilo.criarLista(listaTreinos),
                BorderLayout.CENTER
        );


        // =========================================
        // EXCLUIR / ABRIR
        // =========================================

        JPanel botoes = Estilo.criarPainel(
                new GridLayout(1, 2, px(20), 0)
        );

        btnExcluir = Estilo.criarBotaoSecundario("EXCLUIR");

        btnAbrir = Estilo.criarBotaoPrimario("ABRIR TREINO");

        botoes.add(btnExcluir);
        botoes.add(btnAbrir);

        JPanel rodape = Estilo.criarPainel(new BorderLayout());

        rodape.add(botoes, BorderLayout.EAST);

        conteudo.add(rodape, BorderLayout.SOUTH);


        contentPane.add(conteudo, BorderLayout.CENTER);
    }


    // =============================================
    // LIMPAR LISTA
    // =============================================

    public void limparTreinos() {
        modeloLista.clear();
    }


    // =============================================
    // ADICIONAR TREINO
    // =============================================

    public void adicionarTreino(
            Treino treino
    ) {
        modeloLista.addElement(treino);
    }


    // =============================================
    // TREINO SELECIONADO
    // =============================================

    public Treino getTreinoSelecionado() {
        return listaTreinos.getSelectedValue();
    }


    // =============================================
    // GETTERS
    // =============================================

    public JButton getBtnNovoTreino() {
        return btnNovoTreino;
    }

    public JButton getBtnAbrir() {
        return btnAbrir;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }

    public JList<Treino> getListaTreinos() {
        return listaTreinos;
    }
}
