package com.proyecto.app.repository;

import com.proyecto.app.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Creado por @autor: angel,David
 * El  15 de mar. de 2021.
 * Interface para permitir usar métodos de JpaRepository
 */
@Repository
public interface ProductosRepository extends JpaRepository<Productos,Long> {
}
