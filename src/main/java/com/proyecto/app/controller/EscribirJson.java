package com.proyecto.app.controller;

import com.proyecto.app.entity.Clientes;
import com.proyecto.app.entity.Productos;
import com.proyecto.app.entity.Proveedores;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.util.ArrayList;

/**
 * Creado por @autor: angel,David
 * El  17 de mar. de 2021.
 *
 * @version 0.0.2
 * Clase encargada de la escritura de File
 **/

public class EscribirJson {

    /**
     * Método para la escritura de archivos de tipo cliente
     *
     * @param nombreArchivo Nombre de archivo a crear
     * @param res           Cliente que se va a guardar en archivo
     */
    public static void escribirClientesJson(String nombreArchivo, Clientes res) {
        PrintWriter json = null;
        File fichero;
        try {
            FileWriter añadir = new FileWriter(new File(nombreArchivo + ".json"), true);
            json = new PrintWriter(añadir);
            json.println(res);
        } catch (IOException e) {
            System.out.println("Error en la escritura" + e.toString());
        } finally {
            json.close();
        }
    }

    /**
     * Método para la escritura de archivos de tipo proveedores
     *
     * @param nombreArchivo Nombre de archivo a crear
     * @param res           Proveedor que va a guardar en archivo
     */
    public static void escribirProveedoresJson(String nombreArchivo, Proveedores res) {
        PrintWriter json1 = null;
        File fichero;
        try {
            FileWriter añadir = new FileWriter(new File(nombreArchivo + ".json"), true);
            json1 = new PrintWriter(añadir);
            json1.println(res);
        } catch (IOException e) {
            System.out.println("Error en la escritura" + e.toString());
        } finally {
            json1.close();
        }
    }

    /**
     * Método para la escritura de archivos de tipo Productos
     *
     * @param nombreArchivo Nombre de archivo a crear
     * @param res           Producto que va a guardar en archivo
     */
    public static void escribirProductosJson(String nombreArchivo, Productos res) {
        PrintWriter json2 = null;
        File fichero;
        try {
            FileWriter añadir = new FileWriter(new File(nombreArchivo + ".json"), true);
            json2 = new PrintWriter(añadir);
            json2.println(res);
        } catch (IOException e) {
            System.out.println("Error en la escritura" + e.toString());
        } finally {
            json2.close();
        }
    }
}
