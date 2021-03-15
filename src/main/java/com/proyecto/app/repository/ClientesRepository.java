package com.proyecto.app.repository;

import com.proyecto.app.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Creado por @autor: angel
 * El  15 de mar. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/

@Repository //Le decimos que es componente de tipo Repositorio (DAO)
public interface ClientesRepository extends JpaRepository<Clientes,String>  {  //objeto Clientes y tipo de ID
// Queremos implementar todos los metodos del CRUD de jpaRepository
}
