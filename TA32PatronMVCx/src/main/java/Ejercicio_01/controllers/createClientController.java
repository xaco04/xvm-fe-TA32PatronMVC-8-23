package Ejercicio_01.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Ejercicio_01.views.createClient;
import Ejercicio_01.views.MainPanel;

import Ejercicio_01.models.Conexion;


public class createClientController {
    // Atributos
    private createClient vista;
    private Conexion modelo;

    public createClientController(final createClient vista, Conexion modelo) {
        this.vista = vista;
        this.modelo = modelo;

        vista.getbtnCrearCliente().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = vista.gettextNombre().getText();
                String apellido = vista.gettextApellido().getText();
                String direccion = vista.gettextDireccion().getText();
                String dni = vista.gettextDni().getText();
                String fecha = vista.gettextFieldFecha().getText();

                create(nombre, apellido, direccion, dni, fecha);
            }
        });

        vista.getbtnSalir().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exit();
            }
        });
    }

    // Métodos
    private void create(String nombre, String apellido, String direccion, String dni, String fecha) {
        String queryCrearCliente = "INSERT INTO clientes (nombre, apellido, direccion, dni, fecha) VALUES "
                + "('" + nombre + "', '" + apellido + "', '" + direccion + "', " + Integer.parseInt(dni) + ", '" + fecha + "');";
        modelo.insertarDatos("videoclub", queryCrearCliente);
        vista.dispose();
        new MainPanelController(new MainPanel(), modelo);
    }
	private void exit() {
		vista.dispose();
		new MainPanelController(new MainPanel(), modelo);
	}

}

