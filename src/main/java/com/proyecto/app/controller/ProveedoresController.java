package com.proyecto.app.controller;

import com.proyecto.app.entity.ExcepcionNoEncontrado;
import com.proyecto.app.entity.Proveedores;
import com.proyecto.app.service.ProductosService;
import com.proyecto.app.service.ProveedoresService;
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
@RequestMapping("/api/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;

    @PostMapping
    public ResponseEntity<?> crearProveedor(@RequestBody Proveedores proveedor){
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedoresService.save(proveedor));
    }

    @GetMapping("/{nif}")
    public ResponseEntity<?> leerProveedor (@PathVariable String nif) throws ExcepcionNoEncontrado {
        Optional<Proveedores> oProveedores = proveedoresService.findById(nif);

        if (!oProveedores.isPresent()){
            throw new ExcepcionNoEncontrado(ResponseEntity.notFound().build());
        }
        return ResponseEntity.ok(oProveedores);
    }
}
