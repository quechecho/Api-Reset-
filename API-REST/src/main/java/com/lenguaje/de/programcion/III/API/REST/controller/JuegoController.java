package com.lenguaje.de.programcion.III.API.REST.controller;

import com.lenguaje.de.programcion.III.API.REST.dto.JuegoRequest;
import com.lenguaje.de.programcion.III.API.REST.model.Juego;
import com.lenguaje.de.programcion.III.API.REST.service.JuegoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/juegos")
public class JuegoController {

    private final JuegoService juegoService;

    public JuegoController(JuegoService juegoService) {
        this.juegoService = juegoService;
    }

    @GetMapping
    public ResponseEntity<List<Juego>> listar(@RequestParam(required = false) String genero) {
        if (genero != null) {
            return ResponseEntity.ok(juegoService.filtrarPorGenero(genero));
        }
        return ResponseEntity.ok(juegoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Juego> buscarPorId(@PathVariable Long id) {
        return juegoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Juego> crear(@Valid @RequestBody JuegoRequest request) {
        Juego nuevo = juegoService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

@DeleteMapping("/{id}")
public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    if (juegoService.eliminar(id)) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
}
}