package main;

import java.awt.EventQueue;

import controller.controller;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new controller();
			}
		});
	}
}
