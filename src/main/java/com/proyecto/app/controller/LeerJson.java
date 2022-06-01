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
        File j = new File("/home/ec2-user/json/clientes.json");
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
        File j = new File("/home/ec2-user/json/productos.json");
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
        File j = new File("/home/ec2-user/json/proveedores.json");
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
