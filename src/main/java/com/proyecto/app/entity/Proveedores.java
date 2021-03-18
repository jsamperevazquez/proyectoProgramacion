package com.proyecto.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Creado por @autor: angel
 * El  14 de mar. de 2021.
 *
 * @version 0.1.1
 * Clase que crea la entidad proveedores en BS
 */
@Entity
@Table(name = "proveedores")
public class Proveedores implements Serializable {
    /**
     * UID de la serialización generada por entorno para posible alojamiento nube de BD
     */
    private static final long serialVersionUID = 703557856708520535L;
    /**
     * Nif del proveedor (Primary KEY)
     *
     * Column con parámetros de columna de la tabla
     */
    @Id
    @Column(unique = true)
    private String nif;
    /**
     * Nombre del proveedor
     *
     * Column con parámetros de columna de la tabla
     */
    @Column(length = 60)
    private String nombre;
    /**
     * Dirección del proveedor
     *
     * Column con parámetros de columna de la tabla
     */
    @Column(length = 200)
    private String direccion;

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * toString adaptado a creación fichero -json
     *
     * @return datos del proveedor
     */
    @Override
    public String toString() {
        return "{\n" +
                "\"nif\"" + " : " + "\"" + nif + "\"" + "\n" +
                "\"nombre\"" + " : " + "\"" + nombre + "\"" + "\n" +
                "\"direccion\"" + " : " + "\"" + direccion + "\"" + "\n" +
                "}";
    }
}
