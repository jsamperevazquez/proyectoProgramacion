package com.proyecto.app.service;

import com.proyecto.app.entity.Clientes;
import com.proyecto.app.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Creado por @autor: angel,David
 * El  15 de mar. de 2021.
 * Clase para implementar servicio a entidad  cliente
 */


// Implementación de nuestro servicio

@Service
public class ClienteServiceImpl implements ClienteService {

    /**
     * ClienteRepository para crear inyección de dependencias de Repository
     */
    @Autowired //Con esto hacemos la inyección de dependencias de nuestros Repository
    private ClientesRepository clienteRepository; // Podemos usar nuestro ClienteRepository desde esta clase (patrón fachada)

    // Podemos usar cualquier método que tenga jpaRepository ya que nuestro Repository implementa esa interface
    // Lo iremos ampliando en función de nuestras necesidades

    /**
     * Método  de lectura implementado de  jpaRepository
     *
     * @return Iterable de tipo clientes
     */
    @Override
    //jpa implementa métodos transaccionales y hay que indicarlo con @Transaccional
    @Transactional(readOnly = true) // es una transacción de solo lectura porque no va a cambiar nada de nuestra BD
    public Iterable<Clientes> findAll() {
        return clienteRepository.findAll(); //  devuelve Iterable a través del método de jpaRepository
    }

    /**
     * Método  de lectura implementado de  jpaRepository
     *
     * @param pageable Pageable para posible implementación de FRONT
     * @return Page de clientes para recuperación de datos de BD
     */
    @Override
    @Transactional(readOnly = true)
    public Page<Clientes> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable); // retornamos un Page a través del método de PagingAndSorting de spring
    }

    /**
     * Método  de lectura implementado de  jpaRepository
     *
     * @param dni dni del cliente
     * @return Optional de clase Clientes para uso de métodos de objeto
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Clientes> findById(String dni) {
        return clienteRepository.findById(dni); // retornamos un Optional a través del método de CrudRepository
    }

    /**
     * Método  de escritura implementado de  jpaRepository
     *
     * @param cliente cliente que se va a guardar
     * @return Cliente guardado
     */
    @Override
    @Transactional  // este va a guardar nuestra identidad en nuestra BD, con lo cual es de escritura
    public Clientes save(Clientes cliente) {
        return clienteRepository.save(cliente); // retornamos un Cliente a través del método de CrudRepository
    }

    /**
     * Método   implementado de  jpaRepository
     *
     * @param nif nif del cliente
     */
    @Override
    @Transactional  // este va a guardar nuestra identidad en nuestra BD, con lo cual es de escritura
    public void deleteById(String nif) {
        clienteRepository.deleteById(nif); //usamos el método para borrar un objeto de CrudRepository


    }
}
