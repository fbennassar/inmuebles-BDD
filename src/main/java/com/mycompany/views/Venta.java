package com.mycompany.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import com.mycompany.inmuebles.*;
import com.mycompany.interfaces.*;
import com.mycompany.models.*;

public class Venta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEstado;
	private JTextField textFieldMunicipio;
	private JTextField textFieldCalle;
	private JTextField textFieldAvenida;
	private JTextField textFieldCodigoPostal;
	private JTextField textFieldDetalle;
	private JTextField textFieldMetrosCuadrados;
	private JTextField textFieldMetrosCuadradosConstruidos;
	private JTextField textFieldHabitaciones;
	private JTextField textFieldHabitacionesServicio;
	private JTextField textFieldAseos;
	private JTextField textFieldAseosServicio;
	private JTextField textFieldEstacionamiento;
	private JTextField textFieldYYYY;
	private JTextField textFieldMM;
	private JTextField textFieldDD;
	private JTextField textFieldPrecioVenta;
	private JComboBox comboBoxEmpleado;
	private JCheckBox chckbxPiscina;
	private JCheckBox chckbxGym;
	private JCheckBox chckbxParque;
	private JCheckBox chckbxJuegosInfantiles;
	private JCheckBox chckbxCanchaMultiusos;
	private JCheckBox chckbxCanchaTennis;
	private JCheckBox chckbxCanchaFutbol;
	private JCheckBox chckbxCanchaBasket;
	private JButton btnRegistrar;
	private JLabel lblNewLabel;
	private JLabel lblMunicipio;
	private JLabel lblCalle;
	private JLabel lblAvenida;
	private JLabel lblCodigoPostal;
	private JLabel lblDeCasa;
	private JLabel lblMetrosCuadradosDel;
	private JLabel lblMetrosCuadradosConstruidos;
	private JLabel lblTipoDeInmueble;
	private JLabel lblHabitaciones;
	private JLabel lblHabitacionesDeServicio;
	private JLabel lblAseos;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JTextField textFieldCedula;
	private JLabel lblNewLabel_1;
	private JTextField textFieldNombre;
	private JTextField textFieldTelefono;
	private JTextField textFieldEmail;
	private JLabel lblCedula;
	private JLabel lblNombre;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JTextArea textAreaDescripcion;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venta frame = new Venta();
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
	public Venta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 750);
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
		
		textFieldEstado = new JTextField();
		textFieldEstado.setColumns(10);
		
		textFieldMunicipio = new JTextField();
		textFieldMunicipio.setColumns(10);
		
		textFieldCalle = new JTextField();
		textFieldCalle.setColumns(10);
		
		textFieldAvenida = new JTextField();
		textFieldAvenida.setColumns(10);
		
		textFieldCodigoPostal = new JTextField();
		textFieldCodigoPostal.setColumns(10);
		
		textFieldDetalle = new JTextField();
		textFieldDetalle.setColumns(10);
		
		textFieldMetrosCuadrados = new JTextField();
		textFieldMetrosCuadrados.setColumns(10);
		
		textFieldMetrosCuadradosConstruidos = new JTextField();
		textFieldMetrosCuadradosConstruidos.setColumns(10);
		
		JComboBox comboBoxTipo = new JComboBox();
		cargarTipoInmuebles(comboBoxTipo);
		
		textFieldHabitaciones = new JTextField();
		textFieldHabitaciones.setColumns(10);
		
		textFieldHabitacionesServicio = new JTextField();
		textFieldHabitacionesServicio.setColumns(10);
		
		textFieldAseos = new JTextField();
		textFieldAseos.setColumns(10);
		
		textFieldAseosServicio = new JTextField();
		textFieldAseosServicio.setColumns(10);
		
		textFieldEstacionamiento = new JTextField();
		textFieldEstacionamiento.setColumns(10);
		
		textFieldYYYY = new JTextField();
		textFieldYYYY.setColumns(10);
		
		textFieldMM = new JTextField();
		textFieldMM.setColumns(10);
		
		textFieldDD = new JTextField();
		textFieldDD.setColumns(10);
		
		textFieldPrecioVenta = new JTextField();
		textFieldPrecioVenta.setColumns(10);
		
		JComboBox comboBoxEmpleado = new JComboBox();
		cargarEncargados(comboBoxEmpleado);
		
		chckbxPiscina = new JCheckBox("Piscina");
		
		chckbxGym = new JCheckBox("Gym");
		
		chckbxParque = new JCheckBox("Parque");
		
		chckbxJuegosInfantiles = new JCheckBox("Juegos Infantiles");
		
		chckbxCanchaMultiusos = new JCheckBox("Cancha Multiusos");
		
		chckbxCanchaTennis = new JCheckBox("Cancha de Tennis");
		
		chckbxCanchaFutbol = new JCheckBox("Cancha de futbol de salon");
		
		chckbxCanchaBasket = new JCheckBox("Cancha de Basket");
		
		lblNewLabel = new JLabel("Estado");
		
		lblMunicipio = new JLabel("Municipio");
		
		lblCalle = new JLabel("Calle");
		
		lblAvenida = new JLabel("Avenida");
		
		lblCodigoPostal = new JLabel("Codigo Postal");
		
		lblDeCasa = new JLabel("# de Casa / Edificio - Apartamento");
		
		lblMetrosCuadradosDel = new JLabel("Metros Cuadrados del terreno");
		
		lblMetrosCuadradosConstruidos = new JLabel("Metros Cuadrados Construidos");
		
		lblTipoDeInmueble = new JLabel("Tipo de inmueble");
		
		lblHabitaciones = new JLabel("Habitaciones");
		
		lblHabitacionesDeServicio = new JLabel("Habitaciones de servicio");
		
		lblAseos = new JLabel("Aseos");
		
		lblNewLabel_12 = new JLabel("Empleado Encargado");
		
		lblNewLabel_13 = new JLabel("Precio de Venta");
		
		lblNewLabel_14 = new JLabel("Aseos de servicio");
		
		lblNewLabel_15 = new JLabel("Puestos de Estacionamiento");
		
		lblNewLabel_16 = new JLabel("Fecha de Construccion (YYYY-MM-DD)");
		
		lblNewLabel_17 = new JLabel("Areas adicionales");
		
		textFieldCedula = new JTextField();
		textFieldCedula.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Datos de Cliente");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		lblCedula = new JLabel("Cedula");
		
		lblNombre = new JLabel("Nombre");
		
		lblTelefono = new JLabel("Telefono");
		
		lblEmail = new JLabel("Email");
		
		textAreaDescripcion = new JTextArea();
		
		lblNewLabel_2 = new JLabel("Descripcion");
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cedulaCliente = textFieldCedula.getText().trim();
				String nombreCliente = textFieldNombre.getText().trim();
				String telefonoCliente = textFieldTelefono.getText().trim();
				String emailCliente = textFieldEmail.getText().trim();
				String metrosCuadrados = textFieldMetrosCuadrados.getText().trim();
				String Estado = textFieldEstado.getText().trim().toLowerCase();
				String Municipio = textFieldMunicipio.getText().trim().toLowerCase();
				String Calle = textFieldCalle.getText().trim().toUpperCase();
				String Avenida = textFieldAvenida.getText().trim().toUpperCase();
				String Detalle = textFieldDetalle.getText().trim();
				String AñoConstruida = textFieldYYYY.getText().trim();
				String MesConstruida = textFieldMM.getText().trim();
				String DiaConstruida = textFieldDD.getText().trim();
				String Precio = textFieldPrecioVenta.getText().trim();
				String Descripcion = textAreaDescripcion.getText().trim();
				String codigoPostal = textFieldCodigoPostal.getText().trim();
				
				
				if (cedulaCliente.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Cedula no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
				if (!codigoPostal.matches("\\d+")) {
		            JOptionPane.showMessageDialog(null, "El campo de Cedula debe contener solamente caracteres numericos", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (codigoPostal.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Codigo Postal no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (!codigoPostal.matches("\\d{4}")) {
		            JOptionPane.showMessageDialog(null, "El campo de Codigo Postal debe contener exactamente 4 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (metrosCuadrados.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Metros Cuadrados del terreno no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (Estado.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Estado no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (Municipio.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Municipio no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (Calle.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Calle no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (Calle.length() > 4) {
		            JOptionPane.showMessageDialog(null, "El campo de Calle no puede tener más de 4 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (Avenida.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Avenida no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (Avenida.length() > 4) {
		            JOptionPane.showMessageDialog(null, "El campo de Avenida no puede tener más de 4 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (Detalle.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de # de Casa / Edificio - Apartamento no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (AñoConstruida.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Año no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (MesConstruida.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Mes no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (DiaConstruida.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Dia no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (Precio.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Precio de Venta no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (nombreCliente.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (telefonoCliente.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Telefono no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (!telefonoCliente.matches("\\d+")) {
		            JOptionPane.showMessageDialog(null, "El campo de Telefono solo puede contener dígitos", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        if (Descripcion.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "El campo de Descripcion no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        try {
		            int year = Integer.parseInt(AñoConstruida);
		            int month = Integer.parseInt(MesConstruida);
		            int day = Integer.parseInt(DiaConstruida);

		            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		            if (year < 1800 || year > currentYear) {
		                JOptionPane.showMessageDialog(null, "El año debe estar entre 1800 y " + currentYear, "Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		            if (month < 1 || month > 12) {
		                JOptionPane.showMessageDialog(null, "El mes debe estar entre 1 y 12", "Error", JOptionPane.ERROR_MESSAGE);
		                return;
		            }
		            LocalDate date = LocalDate.of(year, month, day);
		        } catch (DateTimeParseException | NumberFormatException o) {
		            JOptionPane.showMessageDialog(null, "Fecha no válida", "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
				
				 // Crear una instancia de la clase que contiene el método registrar
		        DAOCliente cd = new DAOClienteImpl();
		        
		        // Crear un objeto Cliente con los datos del formulario
		        Cliente cliente = new Cliente();
		        cliente.setCedula(Integer.parseInt(cedulaCliente));
		        cliente.setNombre(nombreCliente);
		        cliente.setTelefono(telefonoCliente);
		        cliente.setEmail(emailCliente); 
		        
		        try {
		            // Llamar al método registrar pasando el objeto Cliente
		            cd.registrar(cliente);
		            JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al registrar el cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		        DAOEstado DAOestado = new DAOEstadoImpl();
		        
		        Estado estado = new Estado();
		        estado.setNombre(Estado);
		        
		        try {
		            DAOestado.registrar(estado);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al registrar el estado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		        DAOMunicipio DAOMunicipio = new DAOMunicipioImpl();
		        
		        Municipio municipio = new Municipio();
		        municipio.setNombre(Municipio);
		        
		        try {
		            DAOMunicipio.registrar(municipio);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al registrar el municipio: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		        DAOCodigoPostal DAOCodigoPostal = new DAOCodigoPostalImpl();
		        
		        CodigoPostal CodigoPostal = new CodigoPostal();
		        CodigoPostal.setCodigoPostal(Integer.parseInt(codigoPostal));
		        
		        try {
		            DAOCodigoPostal.registrar(CodigoPostal);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al registrar el codigo postal: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		        DAOAvenidas DAOAv = new DAOAvenidasImpl();
		        
		        Avenidas av = new Avenidas();
		        av.setAvenida(Avenida);
		        
		        try {
		            DAOAv.registrar(av);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al registrar Avenida: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		        DAOCalles DAOCa = new DAOCallesImpl();
		        
		        Calles cll = new Calles();
		        cll.setCalle(Calle);
		        
		        try {
		            DAOCa.registrar(cll);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al registrar Calle: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		     // Buscar ID de Calle
		        int idCalle;
		        try {
		            idCalle = DAOCa.buscarIdPorNombre(Calle);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al buscar ID de Calle: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Buscar ID de Avenida
		        int idAvenida;
		        try {
		            idAvenida = DAOAv.buscarIdPorNombre(Avenida);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al buscar ID de Avenida: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Buscar ID de Estado
		        int idEstado;
		        try {
		            idEstado = DAOestado.buscarIdPorNombre(Estado);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al buscar ID de Estado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Buscar ID de Municipio
		        int idMunicipio;
		        try {
		            idMunicipio = DAOMunicipio.buscarIdPorNombre(Municipio);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al buscar ID de Municipio: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Buscar ID de Código Postal
		        int idCodigoPostal;
		        try {
		            idCodigoPostal = DAOCodigoPostal.buscarIdPorCodigo(Integer.parseInt(codigoPostal));
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al buscar ID de Código Postal: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Crear instancia de Dirección
		        Direccion direccion = new Direccion();
		        direccion.setDetalle(Detalle);
		        direccion.setIdCalle(idCalle);
		        direccion.setIdAvenida(idAvenida);
		        direccion.setIdMunicipio(idMunicipio);
		        direccion.setIdEstado(idEstado);
		        direccion.setIdCodigoPostal(idCodigoPostal);

		        // Registrar Dirección
		        DAODireccion DAODir = new DAODireccionImpl();
		        try {
		            DAODir.registrar(direccion);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al registrar la dirección: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		        int idDireccion;
		        try {
		            idDireccion = DAODir.buscarIdPorDetalle(Detalle);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al buscar ID de Dirección: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Create Propiedad object
		        Propiedad propiedad = new Propiedad();
		        propiedad.setMetrosCuadrados(Double.parseDouble(metrosCuadrados));
		        propiedad.setMetrosCuadradosConstruidos(Double.parseDouble(textFieldMetrosCuadradosConstruidos.getText().trim()));
		        propiedad.setFechaConstruccion(Date.valueOf(AñoConstruida + "-" + MesConstruida + "-" + DiaConstruida));
		        propiedad.setEstacionamiento(Integer.parseInt(textFieldEstacionamiento.getText().trim()));
		        propiedad.setAseos(Integer.parseInt(textFieldAseos.getText().trim()));
		        propiedad.setAseosServicio(Integer.parseInt(textFieldAseosServicio.getText().trim()));
		        propiedad.setCuartos(Integer.parseInt(textFieldHabitaciones.getText().trim()));
		        propiedad.setCuartosServicio(Integer.parseInt(textFieldHabitacionesServicio.getText().trim()));
		        propiedad.setIdDireccion(idDireccion);
		        propiedad.setPiscina(chckbxPiscina.isSelected());
		        propiedad.setCanchaTenis(chckbxCanchaTennis.isSelected());
		        propiedad.setCanchaBasket(chckbxCanchaBasket.isSelected());
		        propiedad.setCanchaFutbolSalon(chckbxCanchaFutbol.isSelected());
		        propiedad.setParque(chckbxParque.isSelected());
		        propiedad.setJuegosInfantiles(chckbxJuegosInfantiles.isSelected());
		        propiedad.setCanchaMultiusos(chckbxCanchaMultiusos.isSelected());
		        propiedad.setGimnasio(chckbxGym.isSelected());

		        // Register Propiedad
		        DAOPropiedad DAOProp = new DAOPropiedadImpl();
		        try {
		            DAOProp.registrar(propiedad);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al registrar la propiedad: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }

		        int idPropiedad;
		        try {
		            idPropiedad = DAOProp.buscarIdPorIdDireccion(idDireccion);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al buscar ID de Propiedad: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        int idCliente = -1;
		        try {
		            idCliente = cd.buscarIdPorCedula(Integer.parseInt(cedulaCliente));
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al buscar ID de Cliente: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }
		        
		        
		        DAOEmpleado DAOEmpleado = new DAOEmpleadoImpl();
		        int idEmpleado = -1;
		        try {
		            idEmpleado = DAOEmpleado.buscarIdPorNombre(comboBoxEmpleado.getSelectedItem().toString());
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al buscar ID de Empleado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        DAOTipoInmueble DAOTipoInmueble = new DAOTipoImpl();
		        int idTipoInmueble = -1;
		        try {
		            idTipoInmueble = DAOTipoInmueble.buscarIdPorNombre(comboBoxTipo.getSelectedItem().toString());
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al buscar ID de Tipo de Inmueble: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		            return;
		        }

		        // Create Publicacion object
		        Publicacion publicacion = new Publicacion();
		        publicacion.setFecha(new Date(System.currentTimeMillis()));
		        publicacion.setIdCliente(idCliente);
		        publicacion.setPrecio(Double.parseDouble(textFieldPrecioVenta.getText().trim()));
		        publicacion.setDescripcion(textAreaDescripcion.getText().trim());
		        publicacion.setIdPropiedad(idPropiedad);
		        publicacion.setIdEmpleado(idEmpleado);
		        publicacion.setIdTipoInmueble(idTipoInmueble);
		        publicacion.setDisponible(true);

		        // Register Publicacion
		        DAOPublicacion daoPublicacion = new DAOPublicacionImpl();
		        try {
		            daoPublicacion.registrar(publicacion);
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(null, "Error al registrar la publicación: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		        textFieldCedula.setText("");
				textFieldNombre.setText("");
				textFieldTelefono.setText("");
				textFieldEmail.setText("");
				textFieldMetrosCuadrados.setText("");
				textFieldMetrosCuadradosConstruidos.setText("");
				textFieldEstado.setText("");
				textFieldMunicipio.setText("");
				textFieldCalle.setText("");
				textFieldAvenida.setText("");
				textFieldDetalle.setText("");
				textFieldYYYY.setText("");
				textFieldMM.setText("");
				textFieldDD.setText("");
				textFieldPrecioVenta.setText("");
				textAreaDescripcion.setText("");
				textFieldCodigoPostal.setText("");
				textFieldHabitaciones.setText("");
				textFieldHabitacionesServicio.setText("");
				textFieldAseos.setText("");
				textFieldAseosServicio.setText("");
				textFieldEstacionamiento.setText("");

			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textAreaDescripcion, GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegistrar, GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(chckbxPiscina, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
										.addComponent(lblNewLabel_17, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(chckbxCanchaMultiusos, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)))
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
								.addGap(2)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(chckbxGym, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
											.addComponent(chckbxCanchaTennis, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(chckbxCanchaFutbol)
											.addComponent(chckbxParque, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(chckbxCanchaBasket, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(chckbxJuegosInfantiles, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
										.addGap(176)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lblCedula, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
													.addComponent(textFieldCedula, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
													.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
										.addGap(14))
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(textFieldEstado, Alignment.LEADING)
												.addComponent(btnInicio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
											.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(textFieldMunicipio, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblMunicipio, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblCalle, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
												.addGap(111))
											.addComponent(textFieldCalle, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(textFieldMetrosCuadrados, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
													.addComponent(textFieldAseosServicio, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
													.addComponent(textFieldMetrosCuadradosConstruidos, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
													.addComponent(textFieldEstacionamiento, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
													.addComponent(lblMetrosCuadradosConstruidos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
											.addComponent(lblMetrosCuadradosDel)
											.addComponent(lblNewLabel_14, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(textFieldYYYY, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldMM, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textFieldDD, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
											.addComponent(comboBoxTipo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblTipoDeInmueble)
											.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldAvenida, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldHabitaciones, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblAvenida, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblHabitaciones, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(comboBoxEmpleado, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textFieldCodigoPostal, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
										.addComponent(textFieldHabitacionesServicio, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_12, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblCodigoPostal, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblHabitacionesDeServicio, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblAseos, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldAseos, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldDetalle, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
									.addComponent(textFieldPrecioVenta, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
									.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblDeCasa, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblMunicipio)
						.addComponent(lblCalle)
						.addComponent(lblAvenida)
						.addComponent(lblCodigoPostal)
						.addComponent(lblDeCasa))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldEstado, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMunicipio, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCalle, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldAvenida, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldCodigoPostal, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDetalle, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMetrosCuadradosDel)
						.addComponent(lblMetrosCuadradosConstruidos)
						.addComponent(lblTipoDeInmueble)
						.addComponent(lblHabitaciones)
						.addComponent(lblHabitacionesDeServicio)
						.addComponent(lblAseos))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldMetrosCuadrados, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textFieldMetrosCuadradosConstruidos, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBoxTipo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldHabitaciones, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldHabitacionesServicio, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(textFieldAseos, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_12)
						.addComponent(lblNewLabel_13)
						.addComponent(lblNewLabel_14)
						.addComponent(lblNewLabel_15)
						.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldAseosServicio, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEstacionamiento, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldYYYY, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldMM, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldDD, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldPrecioVenta, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxEmpleado, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_17)
						.addComponent(lblNewLabel_1))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxPiscina)
								.addComponent(chckbxGym)
								.addComponent(chckbxParque)
								.addComponent(chckbxJuegosInfantiles))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxCanchaMultiusos)
								.addComponent(chckbxCanchaTennis)
								.addComponent(chckbxCanchaFutbol)
								.addComponent(chckbxCanchaBasket)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCedula)
								.addComponent(lblNombre))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldCedula, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblTelefono)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblEmail)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textAreaDescripcion, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void cargarEncargados(JComboBox comboBoxEmpleado) {
        DAOEmpleado daoEmpleado = new DAOEmpleadoImpl();
        try {
            List<Empleado> empleados = daoEmpleado.buscarTodos(); // Llamada corregida
            for (Empleado empleado : empleados) {
                comboBoxEmpleado.addItem(empleado.getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	private void cargarTipoInmuebles(JComboBox comboBoxTipo) {
        DAOTipoInmueble daoTipo = new DAOTipoImpl();
        try {
            List<TipoInmueble> tipos = daoTipo.buscarTodos();
            for (TipoInmueble tipo : tipos) {
                comboBoxTipo.addItem(tipo.getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
