package com.proyecto.app.controller;

import com.proyecto.app.entity.Clientes;
import com.proyecto.app.entity.ExcepcionNoEncontrado;
import com.proyecto.app.service.ClienteService;
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
// Combinación entre Controller y ResponseBody (Controller para controlador; ResponseBody indicamos que el valor de retorno de nuestros métodos tiene que ser cuerpo solicitud (JSON))
@RequestMapping("/api/clientes") //para acceder a nuestros recursos de usuario a través de la url con navegador
public class ClientesController {

    //El controlador se va a comunicar con los métodos creados en la interface del service a través de inyección de dependencias
    @Autowired
    private ClienteService clienteService;


    //Creamos un nuevo cliente

    @PostMapping  // Recurso Post para crear del api REST
    public ResponseEntity<?> crearCliente (@RequestBody Clientes cliente){ // Con la @RequestBody le decimos que recibimos en el cuerpo un cliente
        // Método recibe en el cuerpo de la petición un cliente
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente)); //guardamos el cliente y lo devolvemos(save) y devolvemos un código 201 (creado ok con httpStatus)
    }

    //Leer un cliente

    @GetMapping("/{dni}") //Operación Get; mandamos un parámetro variable ({}) para decirle que cliente queremos que nos devuelva
    public ResponseEntity<?> leerCliente (@PathVariable(value = "dni") String clienteNif) throws ExcepcionNoEncontrado { //con el value decimos que el parámetro del método es =dni (parámetro del GetMapping)
        Optional<Clientes> oClientes = clienteService.findById(clienteNif); // llamamos a nuestro método del service y le pasamos un dni del cliente

        if (!oClientes.isPresent()){ //si no está presente el usuario
            throw new ExcepcionNoEncontrado(ResponseEntity.notFound().build()); // Si no encuentra al cliente mandamos una excepción con un ResponseEntity de no encontrado(error 404)

        }
        return ResponseEntity.ok(oClientes); // devolvemos un código de ok (200) y devolvemos el cliente
    }
}
