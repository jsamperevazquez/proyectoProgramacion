package com.proyecto.app.Excepciones;

import org.springframework.http.ResponseEntity;

import javax.swing.*;

/**
 * Creado por @autor: angel
 * El  16 de mar. de 2021.
 * Clase para controlar excepciónes
 */
public class ExcepcionNoEncontrado extends Exception{
    public ExcepcionNoEncontrado() {
        super();
    }
    public ExcepcionNoEncontrado(ResponseEntity mensaje){
        super("Error, objeto no encontrado    "+ mensaje);
    }
}
