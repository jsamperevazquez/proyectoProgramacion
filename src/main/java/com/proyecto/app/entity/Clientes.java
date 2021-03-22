package com.proyecto.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Creado por @autor: angel, David
 * El  14 de mar. de 2021.
 *
 * @version 0.1.1
 * Clase que crea entidad clientes en BD
 */
@Entity //le decimos a spring que esta clase en una entidad
@Table(name = "clientes")  //Le decimos a hibernate que nos cree una tabla con este nombre (mapeo)
public class Clientes implements Serializable {
    /**
     * UID de la serialización generada por entorno para posible alojamiento nube de BD
     */
    private static final long serialVersionUID = 4931928483294722769L;

    /**
     * DNI del cliente (Primary KEY)
     */
    @Id
    @Column(unique = true)
    private String dni;

    /**
     * Nombre del cliente
     *
     * Column con parámetros de columna de la tabla
     */
    @Column(name = "nombre", nullable = false, length = 60) //Damos características a nuestra columna
    private String nombre;

    /**
     * Apellidos del cliente
     *
     * Column con parámetros de columna de la tabla
     */
    @Column(length = 80)
    private String apellido;
    /**
     * dirección del cliente
     *
     * Column con parámetros de columna de la tabla
     */
    @Column(length = 200, nullable = false)
    private String direccion;
    /**
     * Número de cliente
     *
     * Column con parámetros de columna de la tabla
     */
    @Column(unique = true)
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

    /**
     * toString adaptado para .json
     *
     * @return datos del cliente
     */
    @Override
    public String toString() {
        return
                "{\n" +
                        "\"dni\"" + " : " + "\"" + dni + "\"" + "\n" +
                        "\"nombre\"" + " : " + "\"" + nombre + "\"" + "\n" +
                        "\"apellido\"" + " : " + "\"" + apellido + "\"" + "\n" +
                        "\"dirección\"" + " : " + "\"" + direccion + "\"" + "\n" +
                        "\"num_cliente\"" + " : " + "\"" + num_cliente + "\"" + "\n" +
                        "}";
    }
}
