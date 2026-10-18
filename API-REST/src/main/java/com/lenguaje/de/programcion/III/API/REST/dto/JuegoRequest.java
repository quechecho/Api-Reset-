package com.lenguaje.de.programcion.III.API.REST.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record JuegoRequest(
        @NotBlank(message = "El título es obligatorio")
        String titulo,

        @NotBlank(message = "El género es obligatorio")
        String genero,

        @NotBlank(message = "La plataforma es obligatoria")
        String plataforma,

        @Min(value = 1950, message = "El año debe ser 1950 o posterior")
        int anio
) {}