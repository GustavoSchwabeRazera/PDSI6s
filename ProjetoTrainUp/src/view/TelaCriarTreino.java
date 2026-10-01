package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCriarTreino extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtNome;

    private JButton btnSalvar;
    private JButton btnVoltar;


    // =============================================
    // CONSTRUTOR
    // =============================================

    public TelaCriarTreino() {

        setTitle("TrainUp - Novo Treino");

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


        // =========================================
        // FORMULÁRIO
        // =========================================

        JPanel formulario = Estilo.criarFormulario();

        Estilo.adicionar(formulario, Estilo.criarTitulo("Criar novo treino"));

        Estilo.adicionar(
                formulario,
                Estilo.criarSubtitulo("Dê um nome para seu treino.")
        );

        Estilo.espaco(formulario, 40);


        // NOME

        Estilo.adicionar(formulario, Estilo.criarRotulo("NOME DO TREINO"));

        txtNome = Estilo.criarCampo();

        Estilo.adicionar(formulario, txtNome);

        Estilo.espaco(formulario, 35);


        // SALVAR

        btnSalvar = Estilo.criarBotaoPrimario("SALVAR TREINO");

        Estilo.adicionar(formulario, btnSalvar);

        Estilo.espaco(formulario, 60);


        contentPane.add(
                Estilo.centralizar(formulario),
                BorderLayout.CENTER
        );
    }


    // =============================================
    // GETTERS
    // =============================================

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnVoltar() {
        return btnVoltar;
    }
}
