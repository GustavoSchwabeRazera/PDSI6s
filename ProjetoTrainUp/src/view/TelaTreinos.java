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

import model.Treino;

public class TelaTreinos extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JList<Treino> listaTreinos;

    private DefaultListModel<Treino>
            modeloLista;

    private JButton btnNovoTreino;
    private JButton btnAbrir;
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

    public TelaTreinos() {

        setTitle(
                "TrainUp - Meus Treinos"
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


        criarComponentes();
    }


    // =============================================
    // COMPONENTES
    // =============================================

    private void criarComponentes() {


        // =========================================
        // LOGO
        // =========================================

        JLabel lblLogo =
                new JLabel("TRAINUP");

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
                new JButton("VOLTAR");

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
        // TÍTULO
        // =========================================

        JLabel lblTitulo =
                new JLabel(
                        "Meus Treinos"
                );

        lblTitulo.setBounds(
                60,
                110,
                500,
                45
        );

        lblTitulo.setForeground(
                BRANCO
        );

        lblTitulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        30
                )
        );

        contentPane.add(
                lblTitulo
        );


        // =========================================
        // SUBTÍTULO
        // =========================================

        JLabel lblSubtitulo =
                new JLabel(
                        "Gerencie seus treinos"
                );

        lblSubtitulo.setBounds(
                60,
                155,
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
        // NOVO TREINO
        // =========================================

        btnNovoTreino =
                new JButton(
                        "+ NOVO TREINO"
                );

        btnNovoTreino.setBounds(
                650,
                125,
                200,
                45
        );

        btnNovoTreino.setBackground(
                ROXO
        );

        btnNovoTreino.setForeground(
                BRANCO
        );

        btnNovoTreino.setFocusPainted(
                false
        );

        btnNovoTreino.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        contentPane.add(
                btnNovoTreino
        );


        // =========================================
        // MODELO DA LISTA
        // =========================================

        modeloLista =
                new DefaultListModel<>();


        listaTreinos =
                new JList<>(
                        modeloLista
                );


        listaTreinos.setBackground(
                PRETO_CLARO
        );

        listaTreinos.setForeground(
                BRANCO
        );

        listaTreinos.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        17
                )
        );

        listaTreinos.setFixedCellHeight(
                50
        );

        listaTreinos.setSelectionBackground(
                ROXO
        );

        listaTreinos.setSelectionForeground(
                BRANCO
        );

        listaTreinos.setSelectionMode(
                ListSelectionModel
                        .SINGLE_SELECTION
        );


        // =========================================
        // SCROLL
        // =========================================

        JScrollPane scrollPane =
                new JScrollPane(
                        listaTreinos
                );

        scrollPane.setBounds(
                60,
                220,
                790,
                230
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
        // EXCLUIR
        // =========================================

        btnExcluir =
                new JButton(
                        "EXCLUIR"
                );

        btnExcluir.setBounds(
                430,
                480,
                180,
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


        // =========================================
        // ABRIR
        // =========================================

        btnAbrir =
                new JButton(
                        "ABRIR TREINO"
                );

        btnAbrir.setBounds(
                650,
                480,
                200,
                45
        );

        btnAbrir.setBackground(
                ROXO
        );

        btnAbrir.setForeground(
                BRANCO
        );

        btnAbrir.setFocusPainted(
                false
        );

        btnAbrir.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );

        contentPane.add(
                btnAbrir
        );
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

        modeloLista.addElement(
                treino
        );
    }


    // =============================================
    // TREINO SELECIONADO
    // =============================================

    public Treino getTreinoSelecionado() {

        return listaTreinos
                .getSelectedValue();
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