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
 * Creado por @autor: angel
 * El  15 de mar. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/


// Implementación de nuestro servicio

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired //Con esto hacemos la inyección de dependencias de nuestros Repository
    private ClientesRepository clienteRepository; // Podemos usar nuestro ClienteRepository desde esta clase (patrón fachada)

    // Podemos usar cualquier método que tenga jpaRepository ya que nuestro Repository implementa esa interface
    // Lo iremos ampliando en función de nuestras necesidades
    @Override
    //jpa implementa métodos transaccionales y hay que indicarlo con @Transaccional
    @Transactional (readOnly = true) // es una transacción de solo lectura porque no va a cambiar nada de nuestra BD
    public Iterable<Clientes> findAll() {
        return clienteRepository.findAll(); //  devuelve Iterable a través del método de jpaRepository
    }

    @Override
    @Transactional (readOnly = true)
    public Page<Clientes> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable); // retornamos un Page a través del método de PagingAndSorting de spring
    }

    @Override
    @Transactional (readOnly = true)
    public Optional<Clientes> findById(String dni) {
        return clienteRepository.findById(dni); // retornamos un Optional a través del método de CrudRepository
    }

    @Override
    @Transactional  // este va a guardar nuestra identidad en nuestra BD, con lo cual es de escritura
    public Clientes save(Clientes cliente) {
        return clienteRepository.save(cliente); // retornamos un Cliente a través del método de CrudRepository
    }

    @Override
    @Transactional  // este va a guardar nuestra identidad en nuestra BD, con lo cual es de escritura
    public void deleteById(String nif) {
        clienteRepository.deleteById(nif); //usamos el método para borrar un objeto de CrudRepository


    }
}
