package main;

import javax.swing.SwingUtilities;

import controller.controller;
import view.Fontes;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    Fontes.aplicarPadrao();

                    new controller();

                }
        );
    }
}