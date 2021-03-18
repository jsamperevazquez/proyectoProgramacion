package com.proyecto.app.repository;

import com.proyecto.app.entity.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Creado por @autor: angel,David
 * El  15 de mar. de 2021.
 * Interface para permitir usar métodos de JpaRepository
 */
@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedores,String> {

}
