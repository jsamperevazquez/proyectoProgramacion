package com.proyecto.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Creado por @autor: angel
 * El  14 de mar. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
@Entity //le decimos a spring que esta clase en una entidad
@Table(name = "clientes")  //Le decimos a hibernate que nos cree una tabla con este nombre (mapeo)
public class Clientes implements Serializable {

    private static final long serialVersionUID = 4931928483294722769L;
    @Id
    private String dni;
    @Column(name = "nombre", nullable = false, length = 60) //Damos características a nuestra columna
    private String nombre;
    @Column(length = 80)
    private String apellido;
    @Column(length = 200, nullable = false)
    private String direccion;
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Decimos que nos genere un valor de identidad
    private long num_cliente;

    // Setter y Getters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(long num_cliente) {
        this.num_cliente = num_cliente;
    }

    @Override
    public String toString() {
        return
                "{\n" +
                        "\"dni\""+" : " + "\""+dni+"\""+"\n"+
                        "\"nombre\""+" : " + "\""+nombre+"\""+"\n"+
                        "\"apellido\""+" : " + "\""+apellido+"\""  +"\n"+
                        "\"dirección\""+" : " + "\""+direccion+"\""  +"\n"+
                        "\"num_cliente\""+" : " + "\""+num_cliente+"\"" + "}" ;
    }
}
