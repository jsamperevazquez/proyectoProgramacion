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
 * Creado por @autor: angel,David
 * El  16 de mar. de 2021.
 * Clase controlador de la entidad proveedores
 */

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoresController {
    /**
     * ProveedoresService para la inyección de dependencias
     */
    @Autowired
    private ProveedoresService proveedoresService;
    /**
     * Para manejar la escritura de ficheros
     * Cada inserción en BD será escrita en File .json
     */
    static Proveedores proveedorFichero;

    /**
     * Método POST para petición CRUD mediante API para crear nuevos proveedores
     *
     * @param proveedor Recibe un proveedor
     * @return Respuesta de HTTPstatus con el estado
     */

    @PostMapping
    public ResponseEntity<?> crearProveedor(@RequestBody Proveedores proveedor) {
        proveedorFichero=proveedoresService.save(proveedor);
        EscribirJson.escribirProveedoresJson("C:\\Users\\angel\\Documents\\Programacion\\proyecto\\src\\main\\java\\com\\proyecto\\app\\ficheros\\proovedores",proveedorFichero);
        return ResponseEntity.status(HttpStatus.CREATED).body(proveedoresService.save(proveedor));
    }
    /**
     * Método GET para petición CRUD mediante API para leer proveedor por nif
     *
     * @param nif nif del proveedor a buscar
     * @return Respuesta de HTTPstatus con el estado
     * @throws ExcepcionNoEncontrado Excepción propia si el proveedor no se encuentra
     */

    @GetMapping("/{nif}")
    public ResponseEntity<?> leerProveedor(@PathVariable String nif) throws ExcepcionNoEncontrado {
        Optional<Proveedores> oProveedores = proveedoresService.findById(nif);

        if (!oProveedores.isPresent()) {
            throw new ExcepcionNoEncontrado(ResponseEntity.notFound().build());
        }
        return ResponseEntity.ok(oProveedores);
    }
    /**
     * Método PUT para la petición CRUD mediante API para actualizar un proveedor
     *
     * @param opcionesProveedor nuevos datos del proveedor
     * @param nifProveedor   nif del proveedor a actualizar
     * @return Respuesta de HTTPstatus con el estado
     * @throws ExcepcionNoEncontrado Excepción propia si el proveedor no se encuentra
     */

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
    /**
     * Método DELETE para la petición CRUD mediante API para eliminar proveedor
     *
     * @param nifProveedor nif del proveedor a eliminar
     * @return Respuesta de HTTPstatus con el estado
     * @throws ExcepcionNoEncontrado Excepción propia si el proveedor no se encuentra
     */

    @DeleteMapping("/{nif}")
    public ResponseEntity<?> borrarProveedor(@PathVariable(value = "nif") String nifProveedor) throws ExcepcionNoEncontrado {
        if (!proveedoresService.findById(nifProveedor).isPresent()) {
            throw new ExcepcionNoEncontrado(ResponseEntity.notFound().build());
        }
        proveedoresService.deleteById(nifProveedor);
        return ResponseEntity.ok().build();
    }
    /**
     * Método para leer todos los proveedores mediante un List
     *
     * @return List con todos los proveedores de entidad
     */

    @GetMapping
    public List<Proveedores> leerTodosProveedores (){
        List<Proveedores> listaProveedores = StreamSupport
                .stream(proveedoresService.findAll().spliterator(),false)
                .collect(Collectors.toList());
        return listaProveedores;
    }

}

