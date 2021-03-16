package com.proyecto.app.Excepciones;

import org.springframework.http.ResponseEntity;

import javax.swing.*;

/**
 * Creado por @autor: angel
 * El  16 de mar. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
public class ExcepcionNoEncontrado extends Exception{
    public ExcepcionNoEncontrado() {
        super();
    }
    public ExcepcionNoEncontrado(ResponseEntity mensaje){
        super("Error"+ mensaje);
    }
}
