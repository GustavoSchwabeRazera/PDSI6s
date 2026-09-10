package main;

import javax.swing.SwingUtilities;

import controller.controller;
import dao.UsuarioDAO;
import view.TelaCadastro;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {

                UsuarioDAO usuarioDAO = new UsuarioDAO();

                TelaCadastro telaCadastro =
                        new TelaCadastro();

                new controller(
                        usuarioDAO,
                        telaCadastro
                );

                telaCadastro.setLocationRelativeTo(null);

                telaCadastro.setVisible(true);

            } catch (Exception e) {

                e.printStackTrace();
            }
        });
    }
}