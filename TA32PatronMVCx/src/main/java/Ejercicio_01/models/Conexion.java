package Ejercicio_01.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class Conexion {

	// Atributos
	private Connection conexion;
	private String url;
	private String usuario;
	private String password;

	// Constructores
	public Conexion(String url, String usuario, String password) {

		this.url = url;
		this.usuario = usuario;
		this.password = password;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(url, usuario, password);
			JOptionPane.showMessageDialog(null, "Conexión al servidor MySQL exitosa.");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ha podido conectar con el servidor MySQL.");
			System.out.println(e);
		}
	}

	// Métodos
	public Connection getConexion() {
		return conexion;
	}

	public String getUrl() {
		return url;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}

	// Cierra la conexión con MySQL
	public void cerrarConexion() {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor MySQL.");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Crea una BD
	public void crearDB(String nombreBD) {
		try {
			String query = "CREATE DATABASE " + nombreBD;
			Statement st = conexion.createStatement();
			st.execute(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Crea una tabla
	public void crearTabla(String nombreBD, String query) {
		try {
			String queryDb = "USE " + nombreBD + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDb);

			Statement st = conexion.createStatement();
			st.executeUpdate(query);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Inserta datos en una tabla
	public void insertarDatos(String nombreBD, String query) {
		try {
			String queryDb = "USE " + nombreBD + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDb);

			Statement st = conexion.createStatement();
			st.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "Datos insertados correctamente.");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Obtiene todos los datos de una tabla
	public ArrayList<String> obtenerDatos(String nombreBD, String nombreTabla, String[] listaColumnas) {
		try {
			String queryDb = "USE " + nombreBD + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDb);

			String query = "SELECT * FROM " + nombreTabla;
			Statement st = conexion.createStatement();
			ResultSet resultSet = st.executeQuery(query);

			ArrayList<String> registros = new ArrayList<String>();

			while (resultSet.next()) {
				StringBuilder registro = new StringBuilder();

				for (String columna : listaColumnas) {
					registro.append(columna).append(": ").append(resultSet.getString(columna)).append(" | ");
				}
				registros.add(registro.toString());
			}

			return registros;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	// Obtiene los datos de un solo registro
	public String[] obtenerRegistro(String nombreBD, String nombreTabla, String[] listaColumnas, String campo, String valor) {
		try {
			String queryDb = "USE " + nombreBD + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDb);
			
			String query = "SELECT * FROM " + nombreTabla + " WHERE " + campo + "= " + valor;
	        Statement st = conexion.createStatement();
	        ResultSet resultSet = st.executeQuery(query);
	        
	        if (resultSet.next()) {
	            String[] registro = new String[listaColumnas.length];

	            for (int i = 0; i < listaColumnas.length; i++) {
	            	registro[i] = resultSet.getString(listaColumnas[i]);
	            }
	            return registro;
	            
	        } else {
	            return null;
	        }

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	// Modifica un registro
	public void modificarRegisto(String nombreBD, String query) {
		try {
			String queryDb = "USE " + nombreBD + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDb);

			Statement st = conexion.createStatement();
			st.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "Datos modificados correctamente.");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Elimina un registro
	public void eliminarRegistro(String nombreBD, String query) {
		try {
			String queryDb = "USE " + nombreBD + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDb);

			Statement st = conexion.createStatement();
			st.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "Datos eliminados correctamente.");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}