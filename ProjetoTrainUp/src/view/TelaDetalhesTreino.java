package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import model.Exercicio;
import model.Treino;

public class TelaDetalhesTreino extends JFrame {

    private static final long serialVersionUID = 1L;


    private JPanel contentPane;


    private JLabel lblNomeTreino;


    private JList<Exercicio>
            listaExercicios;


    private DefaultListModel<Exercicio>
            modeloLista;


    private JButton btnAdicionarExercicio;

    private JButton btnEditar;

    private JButton btnExcluir;

    private JButton btnVoltar;


    // =============================================
    // CORES
    // =============================================

    private static final Color PRETO =
            new Color(18, 18, 18);

    private static final Color PRETO_CLARO =
            new Color(30, 30, 30);

    private static final Color ROXO =
            new Color(138, 43, 226);

    private static final Color BRANCO =
            new Color(245, 245, 245);

    private static final Color CINZA =
            new Color(180, 180, 180);


    // =============================================
    // CONSTRUTOR
    // =============================================

    public TelaDetalhesTreino(
            Treino treino
    ) {

        setTitle(
                "TrainUp - "
                        + treino.getNome()
        );


        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );


        setSize(
                900,
                600
        );


        setResizable(false);


        setLocationRelativeTo(null);


        contentPane =
                new JPanel();


        contentPane.setBackground(
                PRETO
        );


        contentPane.setBorder(
                new EmptyBorder(
                        5,
                        5,
                        5,
                        5
                )
        );


        contentPane.setLayout(null);


        setContentPane(
                contentPane
        );


        criarComponentes(
                treino
        );
    }


    // =============================================
    // COMPONENTES
    // =============================================

    private void criarComponentes(
            Treino treino
    ) {


        // =========================================
        // LOGO
        // =========================================

        JLabel lblLogo =
                new JLabel(
                        "TRAINUP"
                );


        lblLogo.setBounds(
                40,
                25,
                200,
                40
        );


        lblLogo.setForeground(
                ROXO
        );


        lblLogo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );


        contentPane.add(
                lblLogo
        );


        // =========================================
        // VOLTAR
        // =========================================

        btnVoltar =
                new JButton(
                        "VOLTAR"
                );


        btnVoltar.setBounds(
                740,
                30,
                110,
                35
        );


        btnVoltar.setBackground(
                PRETO_CLARO
        );


        btnVoltar.setForeground(
                BRANCO
        );


        btnVoltar.setFocusPainted(
                false
        );


        contentPane.add(
                btnVoltar
        );


        // =========================================
        // NOME DO TREINO
        // =========================================

        lblNomeTreino =
                new JLabel(
                        treino.getNome()
                );


        lblNomeTreino.setBounds(
                60,
                105,
                500,
                45
        );


        lblNomeTreino.setForeground(
                BRANCO
        );


        lblNomeTreino.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );


        contentPane.add(
                lblNomeTreino
        );


        // =========================================
        // SUBTÍTULO
        // =========================================

        JLabel lblSubtitulo =
                new JLabel(
                        "Exercícios deste treino"
                );


        lblSubtitulo.setBounds(
                60,
                150,
                500,
                30
        );


        lblSubtitulo.setForeground(
                CINZA
        );


        contentPane.add(
                lblSubtitulo
        );


        // =========================================
        // ADICIONAR
        // =========================================

        btnAdicionarExercicio =
                new JButton(
                        "+ ADICIONAR EXERCÍCIO"
                );


        btnAdicionarExercicio.setBounds(
                610,
                125,
                240,
                45
        );


        btnAdicionarExercicio.setBackground(
                ROXO
        );


        btnAdicionarExercicio.setForeground(
                BRANCO
        );


        btnAdicionarExercicio.setFocusPainted(
                false
        );


        btnAdicionarExercicio.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        13
                )
        );


        contentPane.add(
                btnAdicionarExercicio
        );


        // =========================================
        // MODELO
        // =========================================

        modeloLista =
                new DefaultListModel<>();


        // =========================================
        // LISTA
        // =========================================

        listaExercicios =
                new JList<>(
                        modeloLista
                );


        listaExercicios.setBackground(
                PRETO_CLARO
        );


        listaExercicios.setForeground(
                BRANCO
        );


        listaExercicios.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );


        listaExercicios.setFixedCellHeight(
                55
        );


        listaExercicios.setSelectionBackground(
                ROXO
        );


        listaExercicios.setSelectionForeground(
                BRANCO
        );


        listaExercicios.setSelectionMode(
                ListSelectionModel
                        .SINGLE_SELECTION
        );


        // =========================================
        // SCROLL
        // =========================================

        JScrollPane scrollPane =
                new JScrollPane(
                        listaExercicios
                );


        scrollPane.setBounds(
                60,
                210,
                790,
                250
        );


        scrollPane.setBorder(
                BorderFactory
                        .createLineBorder(
                                ROXO,
                                1
                        )
        );


        contentPane.add(
                scrollPane
        );


        // =========================================
        // EDITAR
        // =========================================

        btnEditar =
                new JButton(
                        "EDITAR"
                );


        btnEditar.setBounds(
                430,
                490,
                180,
                45
        );


        btnEditar.setBackground(
                PRETO_CLARO
        );


        btnEditar.setForeground(
                BRANCO
        );


        btnEditar.setFocusPainted(
                false
        );


        contentPane.add(
                btnEditar
        );


        // =========================================
        // EXCLUIR
        // =========================================

        btnExcluir =
                new JButton(
                        "EXCLUIR"
                );


        btnExcluir.setBounds(
                630,
                490,
                220,
                45
        );


        btnExcluir.setBackground(
                PRETO_CLARO
        );


        btnExcluir.setForeground(
                BRANCO
        );


        btnExcluir.setFocusPainted(
                false
        );


        contentPane.add(
                btnExcluir
        );
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

        modeloLista.addElement(
                exercicio
        );
    }


    // =============================================
    // SELECIONADO
    // =============================================

    public Exercicio getExercicioSelecionado() {

        return listaExercicios
                .getSelectedValue();
    }


    // =============================================
    // GETTERS
    // =============================================

    public JButton getBtnAdicionarExercicio() {

        return btnAdicionarExercicio;
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