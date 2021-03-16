package com.proyecto.app.service;

import com.proyecto.app.entity.Clientes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Creado por @autor: angel
 * El  15 de mar. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/

public interface ClienteService {

    public Iterable<Clientes> findAll(); //Método findAll() que viene de jpaRepository que hemos implementado en nuestro Repository, que devuelve un Iterable de objeto Clientes

    public Page<Clientes> findAll(Pageable pageable); // Método que devuelve un Page (objeto de Spring) para hacer paginación (mostrar resultados de tablas en varias páginas)

    public Optional<Clientes> findById(String dni); // Método que devuelve un Optional (java 8) para encontrar objeto por ID.

    public Clientes save(Clientes cliente); // Método que nos devuelve un objeto de tipo cliente para grabar o actualizar nuestra identidad

    public void deleteById(String nif); // Método para borrar nuestro objeto pasándole el campo clave.
}
