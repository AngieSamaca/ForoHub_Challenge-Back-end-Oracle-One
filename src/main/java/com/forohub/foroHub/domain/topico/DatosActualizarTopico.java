package com.forohub.foroHub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
    @NotNull
    Long id,
    String titulo,
    String mensaje,
    String curso,
    String autor
) {
}
