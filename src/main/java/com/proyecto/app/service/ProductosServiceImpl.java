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
 * Creado por @autor: angel,David
 * El  15 de mar. de 2021.
 * Clase para implementar servicio a entidad producto
 */

@Service
public class ProductosServiceImpl implements ProductosService {
    /**
     * ProductosRepository para crear inyección de dependencias de Repository
     */

    @Autowired
    private ProductosRepository productosRepository;

    /**
     * Método  de lectura implementado de  jpaRepository
     *
     * @return Iterable de tipo productos
     */
    @Override
    @Transactional(readOnly = true)
    public Iterable<Productos> findAll() {
        return productosRepository.findAll();
    }

    /**
     * Método  de lectura implementado de  jpaRepository
     *
     * @param pageable Pageable para posible implementación de FRONT
     * @return Page de productos para recuperación de datos de BD
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Productos> finAll(Pageable pageable) {
        return productosRepository.findAll(pageable);
    }

    /**
     * Método  de lectura implementado de  jpaRepository
     *
     * @param codigo código del producto
     * @return Optional de clase Productos para uso de métodos de objeto
     */

    @Override
    @Transactional(readOnly = true)
    public Optional<Productos> findById(Long codigo) {
        return productosRepository.findById(codigo);
    }

    /**
     * Método  de escritura implementado de  jpaRepository
     *
     * @param producto producto que se va a guardar
     * @return Producto guardado
     */
    @Override
    @Transactional
    public Productos save(Productos producto) {
        return productosRepository.save(producto);
    }
    /**
     * Método   implementado de  jpaRepository
     *
     * @param codigo código del producto
     */
    @Override
    @Transactional
    public void deleteById(Long codigo) {
        productosRepository.deleteById(codigo);
    }

}
