package com.proyecto.app.service;

import com.proyecto.app.entity.Proveedores;
import com.proyecto.app.repository.ProveedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Creado por @autor: angel
 * El  15 de mar. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/

@Service
public class ProveedoresServiceImpl implements ProveedoresService{


    @Autowired
    private ProveedoresRepository proveedoresRepository;


    @Override
    //jpa implementa métodos transaccionales y hay que indicarlo con @Transaccional
    @Transactional (readOnly = true) // es una transacción de solo lectura porque no va a cambiar nada de nuestra BD
    public Iterable<Proveedores> findAll() {
        return proveedoresRepository.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public Page<Proveedores> findAll(Pageable pageable) {
        return proveedoresRepository.findAll(pageable);
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<Proveedores> findById(String nif) {
        return proveedoresRepository.findById(nif);
    }

    @Override
    @Transactional  // este va a guardar nuestra identidad en nuestra BD, con lo cual es de escritura
    public Proveedores save(Proveedores proveedor) {
        return proveedoresRepository.save(proveedor);
    }

    @Override
    @Transactional (readOnly = false) // va a borrar de nuestra BD
    public void deleteById(String nif) {
        proveedoresRepository.deleteById(nif);

    }
}
