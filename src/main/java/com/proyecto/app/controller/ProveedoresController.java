package com.proyecto.app.controller;

import com.proyecto.app.Excepciones.ExcepcionNoEncontrado;
import com.proyecto.app.entity.Proveedores;
import com.proyecto.app.service.ProveedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
    public ResponseEntity<?> crearProveedor(@RequestBody Proveedores proveedor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedoresService.save(proveedor));
    }

    @GetMapping("/{nif}")
    public ResponseEntity<?> leerProveedor(@PathVariable String nif) throws ExcepcionNoEncontrado {
        Optional<Proveedores> oProveedores = proveedoresService.findById(nif);

        if (!oProveedores.isPresent()) {
            throw new ExcepcionNoEncontrado(ResponseEntity.notFound().build());
        }
        return ResponseEntity.ok(oProveedores);
    }

    @PutMapping("/{nif}")
    public ResponseEntity<?> actualizarProveedores(@RequestBody Proveedores opcionesProveedor, @PathVariable(value = "nif") String nifProveedor) throws ExcepcionNoEncontrado {
        Optional<Proveedores> oProveedor = proveedoresService.findById(nifProveedor);

        if (!oProveedor.isPresent()) {
            throw new ExcepcionNoEncontrado(ResponseEntity.notFound().build());
        }

        oProveedor.get().setNombre(opcionesProveedor.getNombre());
        oProveedor.get().setDireccion(opcionesProveedor.getDireccion());

        return ResponseEntity.status(HttpStatus.CREATED).body(proveedoresService.save(oProveedor.get()));
    }

    @DeleteMapping("/{nif}")
    public ResponseEntity<?> borrarProveedor(@PathVariable(value = "nif") String nifProveedor) throws ExcepcionNoEncontrado {
        if (!proveedoresService.findById(nifProveedor).isPresent()) {
            throw new ExcepcionNoEncontrado(ResponseEntity.notFound().build());
        }
        proveedoresService.deleteById(nifProveedor);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public List<Proveedores> leerTodosProveedores (){
        List<Proveedores> listaProveedores = StreamSupport
                .stream(proveedoresService.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return listaProveedores;
    }
}

