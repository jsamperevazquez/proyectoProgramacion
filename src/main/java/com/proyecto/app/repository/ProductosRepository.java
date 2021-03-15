package com.proyecto.app.repository;

import com.proyecto.app.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Creado por @autor: angel
 * El  15 de mar. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/
@Repository
public interface ProductosRepository extends JpaRepository<Productos,Long> {
}
