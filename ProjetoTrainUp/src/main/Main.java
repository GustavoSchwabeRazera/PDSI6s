package main;

import javax.swing.SwingUtilities;

import controller.controller;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    new controller();

                }
        );
    }
}