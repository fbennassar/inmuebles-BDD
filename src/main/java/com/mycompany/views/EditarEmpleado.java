package com.mycompany.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.interfaces.DAOEmpleado;
import com.mycompany.inmuebles.DAOEmpleadoImpl;
import com.mycompany.models.Empleado;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EditarEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldInputNombre;
	private JTextField textFieldInputCedula;
	private JTextField textFieldInputTelefono;
	private JTextField textFieldInputEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarEmpleado frame = new EditarEmpleado(null);
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
	public EditarEmpleado(com.mycompany.models.Empleado empleado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnVolver = new JButton("<- Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmpleadoView empleadoView = new EmpleadoView(); // Crea una instancia de la clase Compra
		        empleadoView.setVisible(true); // Hace visible la ventana de Compra
		        ((JFrame) SwingUtilities.getWindowAncestor(btnVolver)).dispose();
			}
		});
		btnVolver.putClientProperty("FlatLaf.styleClass", "h3");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(new Color(74, 36, 157));
		
		textFieldInputNombre = new JTextField();
		textFieldInputNombre.setText(empleado.getNombre());
		textFieldInputNombre.setColumns(10);
		
		textFieldInputCedula = new JTextField();
		textFieldInputCedula.setText(String.valueOf(empleado.getCedula()));
		textFieldInputCedula.setColumns(10);
		
		textFieldInputTelefono = new JTextField();
		textFieldInputTelefono.setText(empleado.getTelefono());
		textFieldInputTelefono.setColumns(10);
		
		textFieldInputEmail = new JTextField();
		textFieldInputEmail.setText(empleado.getEmail());
		textFieldInputEmail.setColumns(10);
		
		JLabel lblInputNombre = new JLabel("Nombre");
		
		JLabel lblInputCedula = new JLabel("Cedula");
		
		JLabel lblInputTelefono = new JLabel("Telefono");
		
		JLabel lblInputEmail = new JLabel("Email");
		
		JButton btnRegistrar = new JButton("Guardar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldInputNombre.getText().isEmpty() || textFieldInputCedula.getText().isEmpty() || textFieldInputTelefono.getText().isEmpty() || textFieldInputEmail.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
					return;
                    }
				
				// validacion de cedula que no tenga letras
				
				try {
					Integer.parseInt(textFieldInputCedula.getText());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "La cedula no puede contener letras", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String telefono = textFieldInputTelefono.getText().replaceAll("-", "");
				for (int i = 0; i < telefono.length(); i++) {
				    char c = telefono.charAt(i);
				    if (!Character.isDigit(c)) {
				        // Si encuentra un carácter que no es un dígito, muestra un mensaje de error
				        JOptionPane.showMessageDialog(null, "El telefono no puede contener letras", "Error", JOptionPane.ERROR_MESSAGE);
				        return;
				    }
				}

				
				String nombre = textFieldInputNombre.getText();
				int cedula = Integer.parseInt(textFieldInputCedula.getText());
				String email = textFieldInputEmail.getText();
				
				empleado.setNombre(nombre);
				empleado.setCedula(cedula);
				empleado.setTelefono(telefono);
				empleado.setEmail(email);
				
				try {
					DAOEmpleado dao = new DAOEmpleadoImpl();
					dao.actualizar(empleado);
					
					//Devuelve al usuario a la vista empleadoView
					EmpleadoView empleadoView = new EmpleadoView(); // Crea una instancia de la clase Compra
			        empleadoView.setVisible(true); // Hace visible la ventana de Compra
			        ((JFrame) SwingUtilities.getWindowAncestor(btnVolver)).dispose();
					} catch (Exception e1) {
						e1.printStackTrace();
				}
				
				
			}
		});
		btnRegistrar.putClientProperty("FlatLaf.styleClass", "h3");
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(new Color(74, 36, 157));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblInputNombre, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addGap(287)
					.addComponent(lblInputCedula, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addGap(333))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(textFieldInputNombre, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(textFieldInputCedula, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
					.addGap(64))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblInputTelefono, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(232)
					.addComponent(lblInputEmail, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
					.addGap(333))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(554, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(textFieldInputTelefono, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(textFieldInputEmail, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)))
					.addGap(64))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(87)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInputNombre)
						.addComponent(lblInputCedula))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldInputNombre, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldInputCedula, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInputTelefono)
						.addComponent(lblInputEmail))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldInputTelefono, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldInputEmail, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(82)
					.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(146))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
