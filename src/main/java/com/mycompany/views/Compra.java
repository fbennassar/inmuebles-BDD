package com.mycompany.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.interfaces.DAODetallesinmueble;
import com.mycompany.interfaces.DAOVistaPublicacion;
import com.mycompany.models.VistaPublicacion;
import com.mycompany.inmuebles.DAODetallesinmuebleImpl;
import com.mycompany.inmuebles.DAOVistaPublicacionImpl;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Compra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablePropiedades;
	private JTextField textFieldEstado;
	private JTextField textFieldPrecio;
	private JTextField textFieldCuartos;
	private JTextField textFieldAseos;
	private JTextField textFieldMunicipio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compra frame = new Compra();
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
	public Compra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 680);
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
		
		JScrollPane scrollPanePropiedades = new JScrollPane();
		
		JButton btnDetalles = new JButton("Ver mas");
		btnDetalles.putClientProperty("FlatLaf.styleClass", "h3");
		btnDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tablePropiedades.getSelectedRow() > -1) {
					try {
						
						int idPublicacion = (int) tablePropiedades.getValueAt(tablePropiedades.getSelectedRow(), 0);
						DAODetallesinmueble dao = new DAODetallesinmuebleImpl();
						DetallesInmueble detallesInmueble = new DetallesInmueble(dao.buscarPorId(idPublicacion));
						detallesInmueble.setVisible(true);
						((JFrame) SwingUtilities.getWindowAncestor(btnDetalles)).dispose();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}

		});
		btnDetalles.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDetalles.setForeground(Color.WHITE);
		btnDetalles.setBackground(new Color(74, 36, 157));
		
		textFieldEstado = new JTextField();
		textFieldEstado.putClientProperty("JTextField.placeholderText", "Direccion");
		textFieldEstado.setColumns(10);
		
		JRadioButton rdbtnPiscina = new JRadioButton("Piscina");
		
		JRadioButton rdbtnAreaDeportiva = new JRadioButton("Area deportiva");
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.putClientProperty("FlatLaf.styleClass", "h3");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    }
		});
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(new Color(74, 36, 157));
		
		textFieldPrecio = new JTextField();
		textFieldPrecio.putClientProperty("JTextField.placeholderText", "Precio");
		textFieldPrecio.setColumns(10);
		
		textFieldCuartos = new JTextField();
		textFieldCuartos.putClientProperty("JTextField.placeholderText", "Cuartos");
		textFieldCuartos.setColumns(10);
		
		textFieldAseos = new JTextField();
		textFieldAseos.putClientProperty("JTextField.placeholderText", "Aseos");
		textFieldAseos.setColumns(10);
		

		
		textFieldMunicipio = new JTextField();
		textFieldMunicipio.putClientProperty("JTextField.placeholderText", "Municipio");
		textFieldMunicipio.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPanePropiedades, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1036, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textFieldMunicipio, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textFieldCuartos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textFieldAseos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rdbtnPiscina, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnAreaDeportiva, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDetalles, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCuartos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldAseos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnPiscina)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDetalles, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnAreaDeportiva)
						.addComponent(textFieldMunicipio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPanePropiedades, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tablePropiedades = new JTable();
		tablePropiedades.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Tipo", "Precio", "Direccion", "Cuartos", "Aseos", "Estacionamiento", "Piscina", "Area deportiva"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablePropiedades.getColumnModel().getColumn(7).setPreferredWidth(61);
		scrollPanePropiedades.setViewportView(tablePropiedades);
		cargarPublicaciones();
		contentPane.setLayout(gl_contentPane);
	}
	
	private void cargarPublicaciones() {
		DAOVistaPublicacion dao = new DAOVistaPublicacionImpl();
		
		try {
			DefaultTableModel model = (DefaultTableModel) tablePropiedades.getModel();
			model.setRowCount(0);
			for (com.mycompany.models.VistaPublicacion publicacion : dao.buscarTodos()) {
				if(publicacion.isDisponible() == false) {
					continue;
				}

                model.addRow(new Object[] {
                		publicacion.getIdPublicacion(),
                        publicacion.getNombreTipo(),
                        "$" + publicacion.getPrecio(),
                        publicacion.getNombreEstado() + ", " + publicacion.getNombreMunicipio(),
                        publicacion.getCuartos(),
                        publicacion.getAseos(),
                        publicacion.getEstacionamiento(),
                        publicacion.isPiscina() ? "Si" : "No",
                        publicacion.isAreaDeportiva() ? "Si" : "No"
                });
            }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

