package com.mycompany.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.inmuebles.DAOEmpleadoImpl;
import com.mycompany.interfaces.DAOEmpleado;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class EmpleadoView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableEmpleados;
	private JTextField textFieldBusqueda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpleadoView frame = new EmpleadoView();
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
	public EmpleadoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1061, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnInicio = new JButton("<- Volver");
		btnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicio.addActionListener(new ActionListener() {
			
			//Devuelve al usuario a la vista principal
			public void actionPerformed(ActionEvent e) {
				Principal principalView = new Principal();
		        principalView.setVisible(true); 
		        ((JFrame) SwingUtilities.getWindowAncestor(btnInicio)).dispose();
			}
		});
		btnInicio.putClientProperty("FlatLaf.styleClass", "h3");
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setBackground(new Color(74, 36, 157));
		
		JScrollPane scrollPaneEmpleados = new JScrollPane();
		
		JButton btnNuevoEmpleado = new JButton("Registrar");
		btnNuevoEmpleado.putClientProperty("FlatLaf.styleClass", "h3");
		btnNuevoEmpleado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevoEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearEmpleado crearEmpleadoView = new CrearEmpleado();
                crearEmpleadoView.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(btnNuevoEmpleado)).dispose();
			}
		});
		btnNuevoEmpleado.setForeground(Color.WHITE);
		btnNuevoEmpleado.setBackground(new Color(74, 36, 157));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.putClientProperty("FlatLaf.styleClass", "h3");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(74, 36, 157));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.putClientProperty("FlatLaf.styleClass", "h3");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(74, 36, 157));
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Elimina el empleado seleccionado
				int row = tableEmpleados.getSelectedRow();
				int idEmpleado = (int) tableEmpleados.getValueAt(row, 0);
				DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
				try {
					daoEmpleado.eliminar(idEmpleado);
					cargarEmpleados();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEliminar.putClientProperty("FlatLaf.styleClass", "h3");
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(new Color(74, 36, 157));
		
		textFieldBusqueda = new JTextField();
		textFieldBusqueda.setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNuevoEmpleado, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(textFieldBusqueda, GroupLayout.PREFERRED_SIZE, 646, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPaneEmpleados, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 831, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldBusqueda)
						.addComponent(btnBuscar, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPaneEmpleados, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNuevoEmpleado, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(56)
							.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		tableEmpleados = new JTable();
		tableEmpleados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Cedula", "Nombre", "Telefono", "Email"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableEmpleados.getColumnModel().getColumn(0).setResizable(false);
		tableEmpleados.getColumnModel().getColumn(1).setResizable(false);
		tableEmpleados.getColumnModel().getColumn(2).setResizable(false);
		tableEmpleados.getColumnModel().getColumn(3).setResizable(false);
		tableEmpleados.getColumnModel().getColumn(4).setResizable(false);
		
		
		scrollPaneEmpleados.setViewportView(tableEmpleados);
		cargarEmpleados();
		contentPane.setLayout(gl_contentPane);
	}
	
	private void cargarEmpleados() {
		DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
		try {
			DefaultTableModel model = (DefaultTableModel) tableEmpleados.getModel();
			model.setRowCount(0);
			for (com.mycompany.models.Empleado empleado : daoEmpleado.buscarTodos()) {
				model.addRow(new Object[] { empleado.getId(), empleado.getCedula(), empleado.getNombre(),
						empleado.getTelefono(), empleado.getEmail() });
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
