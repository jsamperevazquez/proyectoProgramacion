package com.proyecto.app.form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Creado por @autor: angel
 * El  20 de may. de 2021.
 * @version 1.1.0
 * Clase con interfaz de usuario para el control de API
 */
public class Portal implements ActionListener {
    JFrame marco;
    JPanel panel;
    JButton bClientes, bProductos, bProveedores;
    JLabel etiClientes, etiProductos, etiProveedores, etiFondo;
    ImageIcon iconobtnClientes;
    ImageIcon iconobtnProductos;
    ImageIcon iconoProveedores;

    public void iniciar() {

        // Instancia de  componentes

        marco = new JFrame("Proyecto Programacion");
        panel = new JPanel();
        bClientes = new JButton();
        bProductos = new JButton();
        bProveedores = new JButton();
        etiClientes = new JLabel("Clientes");
        etiProductos = new JLabel("Productos");
        etiProveedores = new JLabel("Proveedores");
        etiFondo = new JLabel();
        iconobtnClientes = new ImageIcon("C:\\Users\\angel\\Documents\\Programacion\\proyectoProgramacion\\src\\main\\java\\com\\proyecto\\app\\imagenes\\050.png");
        iconobtnProductos = new ImageIcon("C:\\Users\\angel\\Documents\\Programacion\\proyectoProgramacion\\src\\main\\java\\com\\proyecto\\app\\imagenes\\134.png");
        iconoProveedores = new ImageIcon("C:\\Users\\angel\\Documents\\Programacion\\proyectoProgramacion\\src\\main\\java\\com\\proyecto\\app\\imagenes\\198.png");


        // Características de los componentes

        marco.setTitle("Proyecto Programacion");
        marco.setSize(1200, 1000);
        panel.setSize(1150, 950);
        panel.setLayout(null);
        etiFondo.setSize(1200, 1000);
        etiFondo.setLocation(0, 0);
        etiFondo.setIcon(new ImageIcon("C:\\Users\\angel\\Documents\\Programacion\\proyectoProgramacion\\src\\main\\java\\com\\proyecto\\app\\imagenes\\fondo.jpg"));

        bClientes.setIcon(iconobtnClientes);
        bClientes.setIconTextGap(2);
        bClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bClientes.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        bClientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bClientes.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        bClientes.setBounds(600, 150, 150, 50);

        bProductos.setIcon(iconobtnProductos);
        bProductos.setIconTextGap(2);
        bProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bProductos.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        bProductos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bProductos.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        bProductos.setBounds(600, 300, 150, 50);

        bProveedores.setIcon(iconoProveedores);
        bProveedores.setIconTextGap(2);
        bProveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bProveedores.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        bProveedores.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        bProveedores.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        bProveedores.setBounds(600, 450, 150, 50);

        bClientes.setToolTipText("Control de clientes");
        bProveedores.setToolTipText("Control de los proveedores");
        bProductos.setToolTipText("Control de los productos");

        etiClientes.setBounds(400, 150, 200, 50);
        etiClientes.setForeground(Color.YELLOW);
        etiClientes.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        etiProductos.setBounds(400, 300, 200, 50);
        etiProductos.setForeground(Color.YELLOW);
        etiProductos.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));
        etiProveedores.setBounds(400, 450, 200, 50);
        etiProveedores.setForeground(Color.YELLOW);
        etiProveedores.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 22));

        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLocationRelativeTo(null);


        //Añadir los componentes

        panel.add(etiClientes);
        panel.add(etiProductos);
        panel.add(etiProveedores);
        panel.add(bClientes);
        panel.add(bProductos);
        panel.add(bProveedores);
        panel.add(etiFondo);
        marco.add(panel);


        // Gestión de eventos

        bClientes.addActionListener(this);
        bProductos.addActionListener(this);
        bProductos.addActionListener(this);
        bProveedores.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Clientes") {
            try {
                Desktop.getDesktop()
                        .browse(new URI("http://localhost:4200/clientes"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        } else if (e.getActionCommand() == "Productos") {
            try {
                Desktop.getDesktop()
                        .browse(new URI("http://localhost:4200/productos"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        } else if (e.getActionCommand() == "Proveedores") {
            try {
                Desktop.getDesktop()
                        .browse(new URI("http://localhost:4200/proveedores"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (URISyntaxException uriSyntaxException) {
                uriSyntaxException.printStackTrace();
            }
        }
    }
}
