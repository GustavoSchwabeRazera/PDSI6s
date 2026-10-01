package view;

import static view.Fontes.px;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaAdicionarExercicio extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    private JTextField txtNome;
    private JTextField txtSeries;
    private JTextField txtRepeticoes;

    private JButton btnSalvar;
    private JButton btnVoltar;


    // =============================================
    // CONSTRUTOR
    // =============================================

    public TelaAdicionarExercicio() {

        setTitle("TrainUp - Adicionar Exercício");

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

        Estilo.adicionar(formulario, Estilo.criarTitulo("Adicionar exercício"));

        Estilo.espaco(formulario, 35);


        // NOME

        Estilo.adicionar(formulario, Estilo.criarRotulo("NOME DO EXERCÍCIO"));

        txtNome = Estilo.criarCampo();

        Estilo.adicionar(formulario, txtNome);

        Estilo.espaco(formulario, 20);


        // SÉRIES E REPETIÇÕES (lado a lado)

        txtSeries = Estilo.criarCampo();

        txtRepeticoes = Estilo.criarCampo();

        JPanel linha = Estilo.criarPainel(new GridLayout(1, 2, px(20), 0));

        linha.add(criarGrupo("SÉRIES", txtSeries));
        linha.add(criarGrupo("REPETIÇÕES", txtRepeticoes));

        linha.setPreferredSize(
                new Dimension(0, linha.getPreferredSize().height)
        );

        Estilo.adicionar(formulario, linha);

        Estilo.espaco(formulario, 35);


        // SALVAR

        btnSalvar = Estilo.criarBotaoPrimario("ADICIONAR EXERCÍCIO");

        Estilo.adicionar(formulario, btnSalvar);

        Estilo.espaco(formulario, 60);


        contentPane.add(
                Estilo.centralizar(formulario),
                BorderLayout.CENTER
        );
    }


    private JPanel criarGrupo(String rotulo, JTextField campo) {

        JPanel grupo = Estilo.criarPainel(null);

        grupo.setLayout(new BoxLayout(grupo, BoxLayout.Y_AXIS));

        JLabel label = Estilo.criarRotulo(rotulo);

        label.setAlignmentX(LEFT_ALIGNMENT);
        campo.setAlignmentX(LEFT_ALIGNMENT);

        campo.setMaximumSize(
                new Dimension(Integer.MAX_VALUE, campo.getPreferredSize().height)
        );

        grupo.add(label);
        grupo.add(campo);

        return grupo;
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
