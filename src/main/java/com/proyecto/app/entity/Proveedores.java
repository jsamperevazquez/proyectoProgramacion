package com.proyecto.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Creado por @autor: angel
 * El  14 de mar. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
@Entity
@Table (name = "proveedores")
public class Proveedores implements Serializable {
    private static final long serialVersionUID = 703557856708520535L;
    @Id
    private String nif;
    @Column (length = 60)
    private String nombre;
    @Column (length = 200)
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
}
