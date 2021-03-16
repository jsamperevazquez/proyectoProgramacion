package com.proyecto.app.controller;

import com.proyecto.app.entity.ExcepcionNoEncontrado;
import com.proyecto.app.entity.Productos;
import com.proyecto.app.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Creado por @autor: angel
 * El  16 de mar. de 2021.
 * //-encoding utf8 -docencoding utf8 -charset utf8(Para el javadoc)
 **/

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
    @Autowired
    private ProductosService productosService;

    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Productos producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productosService.save(producto));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<?> leerProductos(@PathVariable(value ="codigo") Long codigoProducto) throws ExcepcionNoEncontrado {
        Optional<Productos> oProductos=productosService.findById(codigoProducto);

        if (!oProductos.isPresent()){
            throw new ExcepcionNoEncontrado(ResponseEntity.notFound().build());
        }
        return ResponseEntity.ok(oProductos);
    }

}

