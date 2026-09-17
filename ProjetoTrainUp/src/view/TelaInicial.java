package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JButton btnEntrar;
    private JButton btnCadastrar;

    private static final Color PRETO = new Color(18, 18, 18);
    private static final Color ROXO = new Color(138, 43, 226);
    private static final Color BRANCO = new Color(245, 245, 245);
    private static final Color CINZA = new Color(180, 180, 180);

    public TelaInicial() {

        setTitle("TrainUp");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500, 600);

        setResizable(false);

        setLocationRelativeTo(null);

        contentPane = new JPanel();

        contentPane.setBackground(PRETO);

        contentPane.setBorder(
                new EmptyBorder(5, 5, 5, 5)
        );

        contentPane.setLayout(null);

        setContentPane(contentPane);

        criarComponentes();
    }


    private void criarComponentes() {

        // =============================
        // TÍTULO
        // =============================

        JLabel lblTitulo = new JLabel("TRAINUP");

        lblTitulo.setBounds(
                50, 100, 400, 60
        );

        lblTitulo.setHorizontalAlignment(
                JLabel.CENTER
        );

        lblTitulo.setForeground(ROXO);

        lblTitulo.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        42
                )
        );

        contentPane.add(lblTitulo);


        // =============================
        // FRASE
        // =============================

        JLabel lblFrase = new JLabel(
                "Evolua seu treino. Acompanhe seu progresso."
        );

        lblFrase.setBounds(
                50, 165, 400, 30
        );

        lblFrase.setHorizontalAlignment(
                JLabel.CENTER
        );

        lblFrase.setForeground(CINZA);

        lblFrase.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        contentPane.add(lblFrase);


        // =============================
        // ENTRAR
        // =============================

        btnEntrar = new JButton("ENTRAR");

        btnEntrar.setBounds(
                100, 280, 300, 50
        );

        btnEntrar.setBackground(ROXO);
        btnEntrar.setForeground(BRANCO);
        btnEntrar.setFocusPainted(false);

        btnEntrar.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        contentPane.add(btnEntrar);


        // =============================
        // CADASTRAR
        // =============================

        btnCadastrar = new JButton(
                "CRIAR CONTA"
        );

        btnCadastrar.setBounds(
                100, 350, 300, 50
        );

        btnCadastrar.setBackground(PRETO);
        btnCadastrar.setForeground(ROXO);
        btnCadastrar.setFocusPainted(false);

        btnCadastrar.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        contentPane.add(btnCadastrar);
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
}