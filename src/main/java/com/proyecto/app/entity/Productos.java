package com.proyecto.app.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Creado por @autor: angel
 * El  14 de mar. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
@Entity
@Table(name = "productos")
public class Productos implements Serializable {
    private static final long serialVersionUID = 3346525196468868810L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // decimos que genere un valor automático
    private long codigo;
    @Column (name = "nombre", nullable = false,length = 60)
    private String nombre;
    @Column (nullable = false)
    private float precio;


    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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
}
