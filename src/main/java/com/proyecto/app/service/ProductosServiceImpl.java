package com.proyecto.app.service;

import com.proyecto.app.entity.Productos;
import com.proyecto.app.repository.ProductosRepository;
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
public class ProductosServiceImpl implements ProductosService {
    @Autowired
    private ProductosRepository productosRepository;


    @Override
    @Transactional(readOnly = true)
    public Iterable<Productos> findAll() {
        return productosRepository.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public Page<Productos> finAll(Pageable pageable) {
        return productosRepository.findAll(pageable);
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<Productos> findById(Long codigo) {
        return productosRepository.findById(codigo);
    }

    @Override
    @Transactional
    public Productos save(Productos producto) {
        return productosRepository.save(producto);
    }

    @Override
    @Transactional
    public void deleteById(Long codigo) {
        productosRepository.deleteById(codigo);
    }

}
