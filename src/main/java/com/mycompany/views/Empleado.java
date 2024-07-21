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

public class Empleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableEmpleados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleado frame = new Empleado();
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
	public Empleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1061, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnInicio = new JButton("<- Volver");
		btnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principalView = new Principal(); // Crea una instancia de la clase Compra
		        principalView.setVisible(true); // Hace visible la ventana de Compra
		        ((JFrame) SwingUtilities.getWindowAncestor(btnInicio)).dispose();
			}
		});
		btnInicio.putClientProperty("FlatLaf.styleClass", "h3");
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setBackground(new Color(74, 36, 157));
		
		JScrollPane scrollPaneEmpleados = new JScrollPane();
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(304)
							.addComponent(scrollPaneEmpleados, GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(105)
					.addComponent(scrollPaneEmpleados, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
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
