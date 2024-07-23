package com.mycompany.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.inmuebles.DAOClienteImpl;
import com.mycompany.models.Cliente;
import com.mycompany.interfaces.DAOCliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.Cursor;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		FlatLightLaf.setup(); // <- Esto es FlatLaf, un Look and Feel, a efectos practicos digamos que es una libreria de estilos
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
		setBounds(100, 100, 1061, 645);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel nombreEmpresa = new JLabel("Pillows");
		nombreEmpresa.putClientProperty("FlatLaf.styleClass", "h1");
		nombreEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.putClientProperty("FlatLaf.styleClass", "h2");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compra compraView = new Compra(); // Crea una instancia de la clase Compra
		        compraView.setVisible(true); // Hace visible la ventana de Compra
		        ((JFrame) SwingUtilities.getWindowAncestor(btnComprar)).dispose();
			}
		});
		btnComprar.setForeground(new Color(255, 255, 255));
		btnComprar.setBackground(new Color(74, 36, 157));
		btnComprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnVender = new JButton("Vender");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Venta ventaView = new Venta(); // Crea una instancia de la clase Compra
		        ventaView.setVisible(true); // Hace visible la ventana de Compra
		        ((JFrame) SwingUtilities.getWindowAncestor(btnVender)).dispose();
			}
		});
		btnVender.putClientProperty("FlatLaf.styleClass", "h2");
		btnVender.setForeground(Color.WHITE);
		btnVender.setBackground(new Color(74, 36, 157));
		btnVender.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnReporte = new JButton("Reportes");
		btnReporte.putClientProperty("FlatLaf.styleClass", "h2");
		btnReporte.setForeground(Color.WHITE);
		btnReporte.setBackground(new Color(74, 36, 157));
		btnReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnEmpleado = new JButton("Empleados");
		btnEmpleado.putClientProperty("FlatLaf.styleClass", "h3");
		btnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpleadoView empleadoView = new EmpleadoView(); // Crea una instancia de la clase Compra
				empleadoView.setVisible(true); // Hace visible la ventana de Compra
				((JFrame) SwingUtilities.getWindowAncestor(btnEmpleado)).dispose();
			}
		});
		btnEmpleado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmpleado.setForeground(Color.WHITE);
		btnEmpleado.setBackground(new Color(74, 36, 157));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(383)
					.addComponent(nombreEmpresa, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
					.addGap(115)
					.addComponent(btnEmpleado, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(228)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReporte, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
						.addComponent(btnVender, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
						.addComponent(btnComprar, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE))
					.addGap(219))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(nombreEmpresa, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(btnEmpleado, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGap(107)
					.addComponent(btnComprar, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnVender, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnReporte, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
					.addGap(163))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
