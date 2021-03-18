package com.proyecto.app.service;

import com.proyecto.app.entity.Clientes;
import com.proyecto.app.entity.Productos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Creado por @autor: angel,David
 * El  15 de mar. de 2021.
 *interface con métodos necesarios para API
 */
public interface ProductosService {
    public Iterable<Productos> findAll();

    public Page<Productos> finAll(Pageable pageable);

    public Optional<Productos> findById(Long codigo);

    public Productos save(Productos producto);

    public void deleteById(Long codigo);
}
