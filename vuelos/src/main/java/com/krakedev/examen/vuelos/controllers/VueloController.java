package com.krakedev.examen.vuelos.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.examen.vuelos.entities.Vuelo;
import com.krakedev.examen.vuelos.services.ServicioVuelo;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    private final ServicioVuelo servicio;

    public VueloController(ServicioVuelo servicio) {
        this.servicio = servicio;
    }


    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Vuelo vuelo) {
        try {
           
            Vuelo existente = servicio.buscarPorCodigo(vuelo.getCodigo());
            if (existente != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Ya existe un vuelo con el código: " + vuelo.getCodigo());
            }

            Vuelo creado = servicio.crear(vuelo);
            return ResponseEntity.status(HttpStatus.CREATED).body(creado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el vuelo: " + e.getMessage());
        }
    }

    
    @GetMapping
    public ResponseEntity<?> listar() {
        try {
            List<Vuelo> vuelos = servicio.listar();
            return ResponseEntity.ok(vuelos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al listar los vuelos: " + e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            Vuelo vuelo = servicio.buscarPorId(id);

            if (vuelo == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Vuelo con ID " + id + " no encontrado");
            }

            return ResponseEntity.ok(vuelo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar el vuelo: " + e.getMessage());
        }
    }

 
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Vuelo vuelo) {
        try {
            Vuelo actualizado = servicio.actualizar(id, vuelo);

            if (actualizado == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Vuelo con ID " + id + " no encontrado");
            }

            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el vuelo: " + e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            boolean eliminado = servicio.eliminar(id);

            if (!eliminado) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Vuelo con ID " + id + " no encontrado");
            }

            return ResponseEntity.ok("Vuelo eliminado con éxito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el vuelo: " + e.getMessage());
        }
    }


    @GetMapping("/precio")
    public ResponseEntity<?> buscarPorPrecioMenorA(@RequestParam BigDecimal precio) {
        try {
            List<Vuelo> vuelos = servicio.buscarPorPrecioMenorA(precio);
            return ResponseEntity.ok(vuelos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en la búsqueda: " + e.getMessage());
        }
    }

    
    @GetMapping("/asientos")
    public ResponseEntity<?> buscarPorAsientosDisponibles(@RequestParam Integer asientos) {
        try {
            List<Vuelo> vuelos = servicio.buscarPorAsientosDisponiblesMayorA(asientos);
            return ResponseEntity.ok(vuelos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error en la búsqueda: " + e.getMessage());
        }
    }

  
    @GetMapping("/origen/{origen}")
    public ResponseEntity<?> buscarPorOrigen(@PathVariable String origen) {
        try {
            List<Vuelo> vuelos = servicio.buscarPorOrigen(origen);
            return ResponseEntity.ok(vuelos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar por origen: " + e.getMessage());
        }
    }

    
    @GetMapping("/destino/{destino}")
    public ResponseEntity<?> buscarPorDestino(@PathVariable String destino) {
        try {
            List<Vuelo> vuelos = servicio.buscarPorDestino(destino);
            return ResponseEntity.ok(vuelos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar por destino: " + e.getMessage());
        }
    }

   
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<?> buscarPorCodigo(@PathVariable String codigo) {
        try {
            Vuelo vuelo = servicio.buscarPorCodigo(codigo);

            if (vuelo == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Vuelo con código " + codigo + " no encontrado");
            }

            return ResponseEntity.ok(vuelo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar el vuelo: " + e.getMessage());
        }
    }
}
