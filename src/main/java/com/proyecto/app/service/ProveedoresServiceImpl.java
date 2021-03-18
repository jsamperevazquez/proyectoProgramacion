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
 * Creado por @autor: angel,David
 * El  15 de mar. de 2021.
 * Clase para implementación de servicio a entidad proveedores
 */

@Service
public class ProveedoresServiceImpl implements ProveedoresService {


    /**
     * ProveedoresService  para crear inyección de dependencias de Repository
     */
    @Autowired
    private ProveedoresRepository proveedoresRepository;

    /**
     * Método  de lectura implementado de  jpaRepository
     *
     * @return Iterable de tipo proveedores
     */
    @Override
    //jpa implementa métodos transaccionales y hay que indicarlo con @Transaccional
    @Transactional(readOnly = true) // es una transacción de solo lectura porque no va a cambiar nada de nuestra BD
    public Iterable<Proveedores> findAll() {
        return proveedoresRepository.findAll();
    }

    /**
     * Método  de lectura implementado de  jpaRepository
     *
     * @param pageable Pageable para posible implementación de FRONT
     * @return Page de proveedores para recuperación de datos de BD
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Proveedores> findAll(Pageable pageable) {
        return proveedoresRepository.findAll(pageable);
    }

    /**
     * Método  de lectura implementado de  jpaRepository
     *
     * @param nif nif del proveedor
     * @return Optional de clase Proveedores para uso de métodos de objeto
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Proveedores> findById(String nif) {
        return proveedoresRepository.findById(nif);
    }

    /**
     * Método  de escritura implementado de  jpaRepository
     *
     * @param proveedor proveedor que se va a guardar
     * @return Proveedor guardado
     */
    @Override
    @Transactional  // este va a guardar nuestra identidad en nuestra BD, con lo cual es de escritura
    public Proveedores save(Proveedores proveedor) {
        return proveedoresRepository.save(proveedor);
    }

    /**
     * Método   implementado de  jpaRepository
     *
     * @param nif nif del proveedor
     */
    @Override
    @Transactional(readOnly = false) // va a borrar de nuestra BD
    public void deleteById(String nif) {
        proveedoresRepository.deleteById(nif);

    }
}
