package com.lenguaje.de.programcion.III.API.REST.service;

import com.lenguaje.de.programcion.III.API.REST.dto.JuegoRequest;
import com.lenguaje.de.programcion.III.API.REST.model.Juego;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class JuegoService {

    private final List<Juego> juegos = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(0);

    public JuegoService() {
        juegos.add(new Juego(contadorId.incrementAndGet(), "The Legend of Zelda: Breath of the Wild", "Aventura", "Switch", 2017));
        juegos.add(new Juego(contadorId.incrementAndGet(), "Hades", "Roguelike", "PC", 2020));
        juegos.add(new Juego(contadorId.incrementAndGet(), "Elden Ring", "RPG", "PC", 2022));
    }

    public List<Juego> listar() {
        return juegos;
    }

    public Optional<Juego> buscarPorId(Long id) {
        return juegos.stream()
                .filter(j -> j.getId().equals(id))
                .findFirst();
    }

    public List<Juego> filtrarPorGenero(String genero) {
        return juegos.stream()
                .filter(j -> j.getGenero().equalsIgnoreCase(genero))
                .toList();
    }

    public Juego crear(JuegoRequest request) {
        Juego nuevo = new Juego(
                contadorId.incrementAndGet(),
                request.titulo(),
                request.genero(),
                request.plataforma(),
                request.anio()
        );
        juegos.add(nuevo);
        return nuevo;
    }
}