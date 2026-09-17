package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaAdicionarExercicio
        extends JFrame {

    private static final long serialVersionUID = 1L;


    private JPanel contentPane;


    private JTextField txtNome;

    private JTextField txtSeries;

    private JTextField txtRepeticoes;


    private JButton btnSalvar;

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

    public TelaAdicionarExercicio() {

        setTitle(
                "TrainUp - Adicionar Exercício"
        );


        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );


        setSize(
                600,
                550
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
                new JLabel(
                        "TRAINUP"
                );


        lblLogo.setBounds(
                30,
                20,
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
                        24
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
                450,
                25,
                100,
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
                        "Adicionar exercício"
                );


        lblTitulo.setBounds(
                60,
                90,
                450,
                40
        );


        lblTitulo.setForeground(
                BRANCO
        );


        lblTitulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );


        contentPane.add(
                lblTitulo
        );


        // =========================================
        // NOME
        // =========================================

        JLabel lblNome =
                criarLabel(
                        "NOME DO EXERCÍCIO"
                );


        lblNome.setBounds(
                60,
                160,
                470,
                20
        );


        contentPane.add(
                lblNome
        );


        txtNome =
                criarCampo();


        txtNome.setBounds(
                60,
                185,
                470,
                45
        );


        contentPane.add(
                txtNome
        );


        // =========================================
        // SÉRIES
        // =========================================

        JLabel lblSeries =
                criarLabel(
                        "SÉRIES"
                );


        lblSeries.setBounds(
                60,
                250,
                200,
                20
        );


        contentPane.add(
                lblSeries
        );


        txtSeries =
                criarCampo();


        txtSeries.setBounds(
                60,
                275,
                210,
                45
        );


        contentPane.add(
                txtSeries
        );


        // =========================================
        // REPETIÇÕES
        // =========================================

        JLabel lblRepeticoes =
                criarLabel(
                        "REPETIÇÕES"
                );


        lblRepeticoes.setBounds(
                320,
                250,
                210,
                20
        );


        contentPane.add(
                lblRepeticoes
        );


        txtRepeticoes =
                criarCampo();


        txtRepeticoes.setBounds(
                320,
                275,
                210,
                45
        );


        contentPane.add(
                txtRepeticoes
        );


        // =========================================
        // SALVAR
        // =========================================

        btnSalvar =
                new JButton(
                        "ADICIONAR EXERCÍCIO"
                );


        btnSalvar.setBounds(
                290,
                380,
                240,
                50
        );


        btnSalvar.setBackground(
                ROXO
        );


        btnSalvar.setForeground(
                BRANCO
        );


        btnSalvar.setFocusPainted(
                false
        );


        btnSalvar.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        14
                )
        );


        contentPane.add(
                btnSalvar
        );
    }


    // =============================================
    // LABEL
    // =============================================

    private JLabel criarLabel(
            String texto
    ) {

        JLabel label =
                new JLabel(
                        texto
                );


        label.setForeground(
                CINZA
        );


        label.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        12
                )
        );


        return label;
    }


    // =============================================
    // CAMPO
    // =============================================

    private JTextField criarCampo() {

        JTextField campo =
                new JTextField();


        campo.setBackground(
                PRETO_CLARO
        );


        campo.setForeground(
                BRANCO
        );


        campo.setCaretColor(
                BRANCO
        );


        campo.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );


        campo.setBorder(
                BorderFactory
                        .createLineBorder(
                                ROXO,
                                1
                        )
        );


        return campo;
    }


    // =============================================
    // GETTERS
    // =============================================

    public JTextField getTxtNome() {

        return txtNome;
    }


    public JTextField getTxtSeries() {

        return txtSeries;
    }


    public JTextField getTxtRepeticoes() {

        return txtRepeticoes;
    }


    public JButton getBtnSalvar() {

        return btnSalvar;
    }


    public JButton getBtnVoltar() {

        return btnVoltar;
    }
}