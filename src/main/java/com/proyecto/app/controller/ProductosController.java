package com.proyecto.app.controller;

import com.proyecto.app.Excepciones.ExcepcionNoEncontrado;
import com.proyecto.app.entity.Productos;
import com.proyecto.app.service.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Creado por @autor: angel, David
 * El  16 de mar. de 2021.
 *
 * @version 0.0.3
 * Clase controlador de entidad productos
 */

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
    /**
     * productosService para inyección de dependencias
     */
    @Autowired
    private ProductosService productosService;
    /**
     * Para manejar la escritura de ficheros
     * Cada inserción en BD será escrita en File .json
     */
    static Productos productoFichero;

    /**
     * Método POST para petición CRUD mediante API para crear nuevos productos
     *
     * @param producto Recibe un producto
     * @return Respuesta de HTTPstatus con el estado
     */

    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody Productos producto) {
        productoFichero = productosService.save(producto);
        EscribirJson.escribirProductosJson("C:\\Users\\dmama\\Desktop\\productos", productoFichero);
        return ResponseEntity.status(HttpStatus.CREATED).body(productosService.save(producto));

    }

    /**
     * Método GET para petición CRUD mediante API para leer producto por código
     *
     * @param codigoProducto código del producto a buscar
     * @return Respuesta de HTTPstatus con el estado
     * @throws ExcepcionNoEncontrado Excepción propia si el producto no se encuentra
     */

    @GetMapping("/{codigo}")
    public ResponseEntity<?> leerProductos(@PathVariable(value = "codigo") Long codigoProducto) throws ExcepcionNoEncontrado {
        Optional<Productos> oProductos = productosService.findById(codigoProducto);

        if (!oProductos.isPresent()) {
            throw new ExcepcionNoEncontrado(ResponseEntity.notFound().build());
        }
        return ResponseEntity.ok(oProductos);
    }

    /**
     * Método PUT para la petición CRUD mediante API para actualizar un producto
     *
     * @param opcionesProducto nuevos datos del producto
     * @param codigoProducto   código del producto a actualizar
     * @return Respuesta de HTTPstatus con el estado
     * @throws ExcepcionNoEncontrado Excepción propia si el producto no se encuentra
     */
    @PutMapping("/{codigo}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Productos opcionesProducto, @PathVariable(value = "codigo") Long codigoProducto) throws ExcepcionNoEncontrado {
        Optional<Productos> oProductos = productosService.findById(codigoProducto);
        if (!oProductos.isPresent()) {
            throw new ExcepcionNoEncontrado(ResponseEntity.notFound().build());
        }
        oProductos.get().setNombre(opcionesProducto.getNombre());
        oProductos.get().setPrecio(opcionesProducto.getPrecio());

        return ResponseEntity.status(HttpStatus.CREATED).body(productosService.save(oProductos.get()));
    }

    /**
     * Método DELETE para la petición CRUD mediante API para eliminar producto
     *
     * @param codigoProducto código del producto a eliminar
     * @return Respuesta de HTTPstatus con el estado
     * @throws ExcepcionNoEncontrado Excepción propia si el producto no se encuentra
     */
    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> borrarProducto(@PathVariable(value = "codigo") Long codigoProducto) throws ExcepcionNoEncontrado {
        if (!productosService.findById(codigoProducto).isPresent()) {
            throw new ExcepcionNoEncontrado(ResponseEntity.notFound().build());
        }
        productosService.deleteById(codigoProducto);
        return ResponseEntity.ok().build();
    }

    /**
     * Método para leer todos los productos mediante un List
     *
     * @return List con todos los productos de entidad
     */

    @GetMapping
    public List<Productos> leerTodosProductos() {
        List<Productos> listaProductos = StreamSupport
                .stream(productosService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return listaProductos;
    }
}

