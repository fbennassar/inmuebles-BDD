package com.mycompany.inmuebles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class Dashboard {

	private JFrame background;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.background.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		background = new JFrame();
		background.setBounds(100, 100, 1012, 633);
		background.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		background.getContentPane().setLayout(null);
	}
}
