package com.mycompany.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mycompany.inmuebles.DAOClienteImpl;
import com.mycompany.models.Cliente;
import com.mycompany.interfaces.DAOCliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1007, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				
				cliente.setNombre("Paco Perez");
				cliente.setTelefono("1234567890");
				cliente.setEmail("panchito@gmail.com");
				cliente.setCedula(1234567890);
				
				try {
					DAOCliente dao = new DAOClienteImpl();
					dao.registrar(cliente);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			
			}
		});
		contentPane.add(btnNewButton);
	}

}
