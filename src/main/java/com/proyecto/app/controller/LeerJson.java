package com.proyecto.app.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Creado por @autor: angel
 * El  17 de mar. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
public class LeerJson {
    public static void leerJsonClientes() {
        File j = new File("C:\\Users\\angel\\Documents\\Programacion\\proyecto\\src\\main\\java\\com\\proyecto\\app\\ficheros\\clientes.json");
        Scanner sc = null;
        String datosJson;
        try {
            sc = new Scanner(j).useDelimiter("}");
            sc = new Scanner(j).useDelimiter("\\s*,\\s*");
            while (sc.hasNext()) {
                datosJson = sc.next();
                System.out.println(datosJson);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en lectura" + e.toString());
        } finally {
            sc.close();
        }
    }

    public static void leerJsonProductos() {
        File j = new File("C:\\Users\\angel\\Documents\\Programacion\\proyecto\\src\\main\\java\\com\\proyecto\\app\\ficheros\\productos.json");
        Scanner sc = null;
        String datosJson;
        try {
            sc = new Scanner(j).useDelimiter("}");
            sc = new Scanner(j).useDelimiter("\\s*,\\s*");
            while (sc.hasNext()) {
                datosJson = sc.next();
                System.out.println(datosJson);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura" + e.toString());
        } finally {
            sc.close();
        }
    }

    public static void leerJsonProveedores() {
        File j = new File("C:\\Users\\angel\\Documents\\Programacion\\proyecto\\src\\main\\java\\com\\proyecto\\app\\ficheros\\proovedores.json");
        Scanner sc=null;
        String datosJson;
        try {
            sc=new Scanner(j).useDelimiter("}");
            sc=new Scanner(j).useDelimiter("\\s*,\\s*");
            while (sc.hasNext()){
                datosJson=sc.next();
                System.out.println(datosJson);
            }
        }catch (FileNotFoundException e){
            System.out.println("Error en la lectura" + e.toString());
        }finally {
            sc.close();
        }
    }
}
