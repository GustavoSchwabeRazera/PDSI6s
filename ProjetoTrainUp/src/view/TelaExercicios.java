package view;

import static view.Fontes.px;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import model.Exercicio;

public class TelaExercicios extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtBusca;

    private JList<Exercicio> listaExercicios;

    private DefaultListModel<Exercicio> modeloLista;

    // Todos os exercícios carregados (a lista mostra só os filtrados)
    private List<Exercicio> todos = new ArrayList<>();

    private JButton btnAbrirTreino;
    private JButton btnVoltar;


    // =============================================
    // CONSTRUTOR
    // =============================================

    public TelaExercicios() {

        setTitle("TrainUp - Exercícios");

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
        // TÍTULO + BUSCA
        // =========================================

        JPanel topo = Estilo.criarPainel(new BorderLayout());

        JPanel textos = Estilo.criarPainel(null);

        textos.setLayout(new BoxLayout(textos, BoxLayout.Y_AXIS));

        textos.add(Estilo.criarTitulo("Exercícios"));

        textos.add(Estilo.criarSubtitulo("Todos os exercícios dos seus treinos"));

        topo.add(textos, BorderLayout.WEST);


        JPanel areaBusca = Estilo.criarPainel(null);

        areaBusca.setLayout(new BoxLayout(areaBusca, BoxLayout.Y_AXIS));

        areaBusca.add(Estilo.criarRotulo("BUSCAR"));

        txtBusca = Estilo.criarCampo();

        txtBusca.setPreferredSize(new Dimension(px(320), px(48)));
        txtBusca.setMaximumSize(new Dimension(px(320), px(48)));
        txtBusca.setAlignmentX(LEFT_ALIGNMENT);

        txtBusca.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrar();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrar();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrar();
            }
        });

        areaBusca.add(txtBusca);

        JPanel centroBusca = Estilo.criarPainel(new GridBagLayout());

        centroBusca.add(areaBusca);

        topo.add(centroBusca, BorderLayout.EAST);

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
        // ABRIR TREINO
        // =========================================

        btnAbrirTreino = Estilo.criarBotaoPrimario("ABRIR TREINO");

        JPanel rodape = Estilo.criarPainel(new BorderLayout());

        rodape.add(btnAbrirTreino, BorderLayout.EAST);

        conteudo.add(rodape, BorderLayout.SOUTH);


        contentPane.add(conteudo, BorderLayout.CENTER);
    }


    // =============================================
    // FILTRAR PELO TEXTO DA BUSCA
    // =============================================

    private void filtrar() {

        String busca = txtBusca.getText().trim().toLowerCase();

        modeloLista.clear();

        for (Exercicio exercicio : todos) {

            if (exercicio.getNome().toLowerCase().contains(busca)
                    || exercicio.getNomeTreino().toLowerCase().contains(busca)) {

                modeloLista.addElement(exercicio);
            }
        }
    }


    // =============================================
    // CARREGAR LISTA
    // =============================================

    public void setExercicios(
            List<Exercicio> exercicios
    ) {

        todos = new ArrayList<>(exercicios);

        filtrar();
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

    public JButton getBtnAbrirTreino() {
        return btnAbrirTreino;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }

    public JList<Exercicio> getListaExercicios() {
        return listaExercicios;
    }
}
