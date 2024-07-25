package com.mycompany.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mycompany.models.Venta;
import com.mycompany.interfaces.DAOVenta;
import com.mycompany.inmuebles.DAOVentaImpl;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class Reporte extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableReporte;
	private JTextField textFieldDesde;
	private JTextField textFieldHasta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte frame = new Reporte();
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
	public Reporte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnInicio = new JButton("<- Volver");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal.setVisible(true);
				dispose();
			}
		});
		btnInicio.putClientProperty("FlatLaf.styleClass", "h3");
		btnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicio.setForeground(Color.WHITE);
		btnInicio.setBackground(new Color(74, 36, 157));
		
		JLabel lblReporte = new JLabel("Reporte de ventas");
		lblReporte.putClientProperty("FlatLaf.styleClass", "h1");
		lblReporte.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		
		textFieldDesde = new JTextField();
		textFieldDesde.putClientProperty("JTextField.placeholderText", "Desde... YYYY-MM-DD");
		textFieldDesde.setColumns(10);
		
		textFieldHasta = new JTextField();
		textFieldHasta.putClientProperty("JTextField.placeholderText", "Hasta... YYYY-MM-DD");
		textFieldHasta.setColumns(10);
		
		JButton btnReporte = new JButton("Reporte");
		btnReporte.putClientProperty("FlatLaf.styleClass", "h3");
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// formatear fecha a Date sql
				
				formatearDateSql(textFieldDesde.getText());
				formatearDateSql(textFieldHasta.getText());
				
				DAOVenta dao = new DAOVentaImpl();
				
				try {
                    DefaultTableModel model = (DefaultTableModel) tableReporte.getModel();
                    model.setRowCount(0);

                    for (Venta venta : dao.buscarDesdeUnaFechaHastaOtra(formatearDateSql(textFieldDesde.getText()), formatearDateSql(textFieldHasta.getText()))) {
                        model.addRow(new Object[] { venta.getId(), venta.getFechaVenta(), venta.getTipoInmueble(),
                                "$" + venta.getPrecio(), venta.getEstado() + ", " + venta.getMunicipio(), venta.getNombreCliente(), venta.getNombreEmpleado() });
                    
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();}
				
			}
		});
		btnReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReporte.setForeground(Color.WHITE);
		btnReporte.setBackground(new Color(74, 36, 157));
		
		JButton btnPdf = new JButton("Exportar PDF");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JTable tabla = tableReporte;
				String userHome = System.getProperty("user.home");
				String path = userHome + File.separator + "Desktop" + File.separator + "reporte.pdf";
				exportarPdf(tabla, path);
			}
		});
		btnPdf.putClientProperty("FlatLaf.styleClass", "h3");
		btnPdf.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPdf.setForeground(Color.WHITE);
		btnPdf.setBackground(new Color(74, 36, 157));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addGap(172)
							.addComponent(lblReporte, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(723, Short.MAX_VALUE)
					.addComponent(textFieldDesde, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textFieldHasta, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPdf, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 648, Short.MAX_VALUE)
					.addComponent(btnReporte, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(86))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(lblReporte)))
					.addGap(109)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldDesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldHasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReporte, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPdf, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableReporte = new JTable();
		tableReporte.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Fecha", "Tipo inmueble", "Precio", "Direccion", "Comprador", "Empleado"
			}
		));
		scrollPane.setViewportView(tableReporte);
		cargarReporte();
		contentPane.setLayout(gl_contentPane);
	}
	
	private void cargarReporte() {
		
		DAOVenta dao = new DAOVentaImpl();
		
		try {
			DefaultTableModel model = (DefaultTableModel) tableReporte.getModel();
			model.setRowCount(0);

			for (Venta venta : dao.buscarTodos()) {
				model.addRow(new Object[] { venta.getId(), venta.getFechaVenta(), venta.getTipoInmueble(),
						"$" + venta.getPrecio(), venta.getEstado() + ", " + venta.getMunicipio(), venta.getNombreCliente(), venta.getNombreEmpleado() });
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	private Date formatearDateSql(String fecha) {
		
		LocalDate localDate = LocalDate.parse(fecha);
		Date date = Date.valueOf(localDate);

		return date;
	    
	}
	
	private void exportarPdf(JTable table, String path) {
		Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            
            Font titleFont = new Font(FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Reporte de Ventas", titleFont);
            title.setSpacingAfter(20);
            document.add(title);
            
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            Font headerFont = new Font(FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
            for (int i = 0; i < table.getColumnCount(); i++) {
                PdfPCell header = new PdfPCell(new Phrase(table.getColumnName(i), headerFont));
                header.setBackgroundColor(BaseColor.DARK_GRAY);
                pdfTable.addCell(header);
            }
            // Añadir filas de la tabla
            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());
                }
            }
            
            JOptionPane.showMessageDialog(null, "PDF exportado correctamente");
            document.add(pdfTable);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
	}
}
