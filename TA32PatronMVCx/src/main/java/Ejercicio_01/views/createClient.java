package Ejercicio_01.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class createClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDireccion;
	private JTextField textDni;
	private JButton btnCrearCliente;
	private JButton btnSalir;
	private JTextField textFieldFecha; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createClient frame = new createClient();
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
	public createClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Creación Cliente");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTitulo.setBounds(94, 0, 241, 70);
		contentPane.add(lblTitulo);
		
		JLabel lblFecha = new JLabel("Date");
		lblFecha.setBounds(35, 83, 46, 14);
		contentPane.add(lblFecha);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(35, 108, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(35, 133, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(35, 158, 68, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(35, 183, 46, 14);
		contentPane.add(lblDni);
		
		textNombre = new JTextField();
		textNombre.setBounds(132, 105, 114, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(132, 130, 114, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(132, 155, 114, 20);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);
		
		textDni = new JTextField();
		textDni.setBounds(132, 180, 114, 20);
		contentPane.add(textDni);
		textDni.setColumns(10);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBackground(new Color(255, 255, 255));
		textFieldFecha.setEditable(false);
		textFieldFecha.setBounds(132, 81, 114, 20);
		contentPane.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
		LocalDate localDate = LocalDate.now();
		
		
		JButton btnCrearCliente = new JButton("Crear Cliente");
		btnCrearCliente.setBounds(279, 81, 124, 50);
		contentPane.add(btnCrearCliente);
		
		JButton btnSalir = new JButton("Cancelar");
		btnSalir.setBounds(279, 154, 124, 50);
		contentPane.add(btnSalir);
	}
	
	public JButton getbtnCrearCliente() {
		return btnCrearCliente;
	}
	
	public JButton getbtnSalir() {
		return btnSalir;
	}
	
	public JTextField gettextFieldFecha() {
		return textFieldFecha;
	}
	
	public JTextField gettextNombre() {
		return textNombre;
	}
	
	public JTextField gettextApellido() {
		return textApellido;
	}
	
	public JTextField gettextDireccion() {
		return textDireccion;
	}
	
	public JTextField gettextDni() {
		return textDni;
	}
	
	public void settextFieldFecha(JTextField textFieldFecha) {
		this.textFieldFecha = textFieldFecha;
	}
	
	public void settextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}
	
	public void settextApellido(JTextField textApellido) {
		this.textApellido = textApellido;
	}
	
	public void settextDireccion(JTextField textDireccion) {
		this.textDireccion = textDireccion;
	}
	
	public void settextDni(JTextField textDni) {
		this.textDni = textDni;
	}
	
}
