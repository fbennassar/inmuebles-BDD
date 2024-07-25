package com.mycompany.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;
import com.mycompany.models.Cliente;
import com.mycompany.interfaces.DAOCliente;
import com.mycompany.inmuebles.DAOClienteImpl;
import com.mycompany.models.Venta;
import com.mycompany.interfaces.DAOVenta;
import com.mycompany.inmuebles.DAOVentaImpl;
import com.mycompany.models.Empleado;
import com.mycompany.interfaces.DAOEmpleado;
import com.mycompany.inmuebles.DAOEmpleadoImpl;
import com.mycompany.interfaces.DAODetallesinmueble;
import com.mycompany.inmuebles.DAODetallesinmuebleImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class DetallesInmueble extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetallesInmueble frame = new DetallesInmueble(null);
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
	public DetallesInmueble(com.mycompany.models.DetallesInmueble detallesInmueble) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1061, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnVolver = new JButton("<- Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.putClientProperty("FlatLaf.styleClass", "h3");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Compra compra = new Compra(); // Crea una instancia de la clase Compra
		        compra.setVisible(true); // Hace visible la ventana de Compra
		        ((JFrame) SwingUtilities.getWindowAncestor(btnVolver)).dispose();
			}
		});
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBackground(new Color(74, 36, 157));
		
		JLabel lblTipoYDireccion = new JLabel("");
		lblTipoYDireccion.putClientProperty("FlatLaf.styleClass", "h2");
		lblTipoYDireccion.setText(detallesInmueble.getNombreTipo() + " - " + detallesInmueble.getNombreEstado() + " - " + detallesInmueble.getNombreMunicipio() + " - Avenida " + detallesInmueble.getAvenidas() + " - Calle " + detallesInmueble.getCalles() + " - Codigo postal "  + detallesInmueble.getCodigoPostal() + " - Numero: " + detallesInmueble.getDetalle());
		
		JLabel lblCuartos = new JLabel("Cuartos: " + detallesInmueble.getCuartos());
		
		JLabel lblCuartosServicio = new JLabel("Cuartos de servicio: " + detallesInmueble.getCuartosServicio());
		
		JLabel lblAseos = new JLabel("Aseos: " + detallesInmueble.getAseos());
		
		JLabel lblAseosServicio = new JLabel("Aseos de servicio: " + detallesInmueble.getAseosServicio());
		
		JLabel lblEstacionamiento = new JLabel("Estacionamiento: " + detallesInmueble.getEstacionamiento());
		
		JLabel lblMetrosCuadrados = new JLabel("Metros cuadrados: " + detallesInmueble.getMetrosCuadrados() + " m2");
		
		JLabel lblMetrosCuadradosConstruidos = new JLabel("Metros cuadrados construidos: " + detallesInmueble.getMetrosCuadradosConstruidos() + " m2");
		
		JLabel lblFecha = new JLabel("Fecha de publicacion: " + detallesInmueble.getFechaPublicacion());
		
		JLabel lblPrecio = new JLabel("Precio: $" + detallesInmueble.getPrecio());
		
		JLabel lblPiscina = new JLabel("Piscina: " + (detallesInmueble.isPiscina() ? "Si" : "No"));
		
		// nombrar solo las areas deportivas que esten disponibles
		JLabel lblAreasDeportivas = new JLabel("Areas deportivas: " + (detallesInmueble.isCanchaTenis() ? "Cancha de tenis, " : "") + (detallesInmueble.isCanchaBasket() ? "Cancha de basket, " : "") + (detallesInmueble.isCanchaFutbolSalon() ? "Cancha de futbol salon, " : "") + (detallesInmueble.isParque() ? "Parque, " : "") + (detallesInmueble.isJuegosInfantiles() ? "Juegos infantiles, " : "") + (detallesInmueble.isCanchaMultiusos() ? "Cancha multiusos, " : "") + (detallesInmueble.isGym() ? "Gym, " : ""));
		lblAreasDeportivas.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lblCliente = new JLabel("Publicado por: " + detallesInmueble.getNombreCliente());
		
		JLabel lblEmpleado = new JLabel("Agente de venta: " + detallesInmueble.getNombreEmpleado());
		
		JLabel lblContacto = new JLabel("Contacto: " + detallesInmueble.getTelefonoEmpleado());
		
		JLabel lblDescripcion = new JLabel("Descripcion: " + detallesInmueble.getDescripcion());
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnComprar.putClientProperty("FlatLaf.styleClass", "h3");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = new Cliente();
				cliente.setNombre(textField.getText());
				cliente.setTelefono(textField_2.getText());
				cliente.setEmail(textField_3.getText());
				cliente.setCedula(Integer.parseInt(textField_1.getText()));
				
				//Comprobar si el cliente existe, si ese es el caso, no se hace insert, solo se coloca su id en venta
				
				DAOCliente daoCliente = new DAOClienteImpl();
				DAOVenta daoVenta = new DAOVentaImpl();
				DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
				DAODetallesinmueble daoDetallesInmueble = new DAODetallesinmuebleImpl();
                try {
                	Cliente clienteExistente = daoCliente.buscarPorCedula(cliente.getCedula());
                    if (clienteExistente == null) {
                        // El cliente no existe, entonces registrar
                        daoCliente.registrar(cliente);
                        // Después de registrar, necesitamos obtener el ID del cliente registrado
                        clienteExistente = daoCliente.buscarPorCedula(cliente.getCedula());
                    } else {
                        // El cliente ya existe, opcionalmente puedes mostrar un mensaje o realizar alguna acción
                    	JOptionPane.showMessageDialog(null, "El cliente ya existe, se precargaran los datos ya asignados", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    // Continuar con la creación de la venta, ya sea que el cliente fuera nuevo o ya existente
                    Venta venta = new Venta();
                    venta.setFechaVenta(fechaActualDate());
                    venta.setIdCliente(clienteExistente.getId()); // Usar el ID del cliente existente o recién registrado
                    venta.setIdEmpleado(detallesInmueble.getIdEmpleado());
                    venta.setIdPublicacion(detallesInmueble.getIdPublicacion());
                    venta.setIdPropiedad(detallesInmueble.getIdPropiedad());
                    venta.setIdTipoInmueble(detallesInmueble.getIdTipoInmueble());

                    daoDetallesInmueble.comprar(detallesInmueble.getIdPublicacion());
                    daoVenta.registrar(venta);
                    
                    Compra compra = new Compra(); // Crea una instancia de la clase Compra
    		        compra.setVisible(true); // Hace visible la ventana de Compra
    		        ((JFrame) SwingUtilities.getWindowAncestor(btnComprar)).dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnComprar.setForeground(Color.WHITE);
		btnComprar.setBackground(new Color(74, 36, 157));
		
		JLabel lblNombre = new JLabel("Nombre");

		
		JLabel lblCedula = new JLabel("Cedula");

		
		JLabel lblTelefono = new JLabel("Telefono");

		
		JLabel lblEmail = new JLabel("Email");

		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(lblAseosServicio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblAseos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblCuartosServicio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblCuartos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
											.addGap(268))
										.addComponent(lblEstacionamiento, GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblMetrosCuadrados, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblPrecio, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPiscina, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFecha, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
										.addComponent(lblAreasDeportivas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(78)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEmpleado, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblContacto, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField))
											.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblCedula, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField_1)))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblTelefono, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField_2))
											.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField_3))))
									.addGap(64))
								.addComponent(lblTipoYDireccion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1017, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(lblDescripcion, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
									.addGap(266)
									.addComponent(btnComprar, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblMetrosCuadradosConstruidos, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnVolver, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTipoYDireccion, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCuartos)
						.addComponent(lblFecha)
						.addComponent(lblCliente))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCuartosServicio)
						.addComponent(lblPrecio)
						.addComponent(lblEmpleado))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAseos)
						.addComponent(lblPiscina)
						.addComponent(lblContacto))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAseosServicio)
									.addGap(20)
									.addComponent(lblEstacionamiento)
									.addGap(22)
									.addComponent(lblMetrosCuadrados))
								.addComponent(lblAreasDeportivas, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMetrosCuadradosConstruidos)
							.addGap(71)
							.addComponent(lblDescripcion, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(141, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(81)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNombre)
								.addComponent(lblCedula))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefono)
								.addComponent(lblEmail))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(63)
							.addComponent(btnComprar, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(244))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private String fechaActual() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		return dtf.format(localDate);
	}
	
	private Date fechaActualDate() {
	    // Obtener la fecha actual como LocalDate
	    LocalDate fechaLocal = LocalDate.now();
	    
	    // Convertir LocalDate a java.sql.Date
	    Date fechaSql = Date.valueOf(fechaLocal);
	    
	    return fechaSql;
	}
}
