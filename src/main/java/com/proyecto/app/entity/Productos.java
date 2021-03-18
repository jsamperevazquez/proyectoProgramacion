package com.proyecto.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Creado por @autor: angel
 * El  14 de mar. de 2021.
 *
 * @version 0.1.1
 * Clase que crea entidad productos en BD
 */
@Entity
@Table(name = "productos")
public class Productos implements Serializable {
    /**
     * UID de la serialización generada por entorno para posible alojamiento nube de BD
     */
    private static final long serialVersionUID = 3346525196468868810L;
    /**
     * Código del producto (Primary KEY)
     *
     * Column con parámetros de columna de la tabla
     */
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // decimos que genere un valor automático
    private long codigo;
    /**
     * Nombre del producto
     *
     * Column con parámetros de columna de la tabla
     */
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;
    /**
     * Precio del producto
     *
     * Column con parámetros de columna de la tabla
     */
    @Column(nullable = false)
    private float precio;


    public long getCodigo() {
        return codigo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * toString adaptado a fichero .json
     *
     * @return datos del producto
     */
    @Override
    public String toString() {
        return "{\n" +
                "\"codigo\"" + " : " + "\"" + codigo + "\"" + "\n" +
                "\"nombre\"" + " : " + "\"" + nombre + "\"" + "\n" +
                "\"precio\"" + " : " + "\"" + precio + "\"" + "\n" +
                "}";
    }
}

