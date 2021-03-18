package com.proyecto.app.service;

import com.proyecto.app.entity.Proveedores;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Creado por @autor: angel, David
 * El  15 de mar. de 2021.
 * interface con métodos necesarios para API
 */
public interface ProveedoresService {
    public Iterable<Proveedores> findAll();

    public Page<Proveedores> findAll(Pageable pageable);

    public Optional<Proveedores> findById(String nif);

    public Proveedores save(Proveedores proveedor);

    public void deleteById(String nif);


}
