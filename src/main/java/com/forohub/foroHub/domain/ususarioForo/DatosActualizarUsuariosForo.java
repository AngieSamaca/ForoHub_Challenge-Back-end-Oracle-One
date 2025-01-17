package com.forohub.foroHub.domain.ususarioForo;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarUsuariosForo(
    @NotNull
    Long id,
    String nombre,
    String email
) {
}
