package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.UsuarioDAO;
import model.Usuario;
import view.TelaCadastro;

public class controller {

    private UsuarioDAO usuarioDAO;
    private TelaCadastro telaCadastro;

    public controller(UsuarioDAO usuarioDAO, TelaCadastro telaCadastro) {

        this.usuarioDAO = usuarioDAO;
        this.telaCadastro = telaCadastro;

        configurarEventos();
    }
    private void configurarEventos() {

        telaCadastro.getBtnCadastrar().addActionListener(e -> cadastrarUsuario());

    }

    private void cadastrarUsuario() {

        try {

            String nome = telaCadastro.getTxtNome().getText().trim();

            String email = telaCadastro.getTxtEmail().getText().trim();

            String idadeTexto =
                    telaCadastro.getTxtIdade().getText().trim();

            String senha =
                    new String(telaCadastro.getTxtSenha().getPassword());

            String confirmarSenha =
                    new String(telaCadastro.getTxtConfirmarSenha().getPassword());


            // ==========================================
            // VALIDAR NOME
            // ==========================================

            if (nome.isEmpty()) {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "Digite seu nome.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE
                );

                telaCadastro.getTxtNome().requestFocus();

                return;
            }


            // ==========================================
            // VALIDAR EMAIL
            // ==========================================

            if (email.isEmpty()) {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "Digite seu e-mail.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE
                );

                telaCadastro.getTxtEmail().requestFocus();

                return;
            }


            // ==========================================
            // VALIDAR IDADE
            // ==========================================

            if (idadeTexto.isEmpty()) {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "Digite sua idade.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE
                );

                telaCadastro.getTxtIdade().requestFocus();

                return;
            }

            int idade;

            try {

                idade = Integer.parseInt(idadeTexto);

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "A idade deve conter apenas números.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

                telaCadastro.getTxtIdade().requestFocus();

                return;
            }


            if (idade <= 0 || idade > 120) {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "Digite uma idade válida.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

                telaCadastro.getTxtIdade().requestFocus();

                return;
            }


            // ==========================================
            // VALIDAR SENHA
            // ==========================================

            if (senha.isEmpty()) {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "Digite uma senha.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE
                );

                telaCadastro.getTxtSenha().requestFocus();

                return;
            }


            if (senha.length() < 6) {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "A senha deve ter pelo menos 6 caracteres.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

                telaCadastro.getTxtSenha().requestFocus();

                return;
            }


            // ==========================================
            // CONFIRMAR SENHA
            // ==========================================

            if (!senha.equals(confirmarSenha)) {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "As senhas não são iguais.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

                telaCadastro.getTxtConfirmarSenha().requestFocus();

                return;
            }


            // ==========================================
            // CRIAR USUÁRIO
            // ==========================================

            Usuario usuario = new Usuario(
                    nome,
                    email,
                    senha,
                    idade
            );


            // ==========================================
            // SALVAR NO BANCO
            // ==========================================

            usuarioDAO.inserir(usuario);


            JOptionPane.showMessageDialog(
                    telaCadastro,
                    "Cadastro realizado com sucesso!",
                    "TrainUp",
                    JOptionPane.INFORMATION_MESSAGE
            );


            // Limpar campos

            telaCadastro.getTxtNome().setText("");

            telaCadastro.getTxtEmail().setText("");

            telaCadastro.getTxtIdade().setText("");

            telaCadastro.getTxtSenha().setText("");

            telaCadastro.getTxtConfirmarSenha().setText("");

            telaCadastro.getTxtNome().requestFocus();


        } catch (SQLException e) {

            if (e.getMessage().contains("Duplicate")) {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "Este e-mail já está cadastrado.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                        telaCadastro,
                        "Erro ao cadastrar usuário:\n"
                        + e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );

                e.printStackTrace();
            }
        }
    }
}