package com.forohub.foroHub.domain.ususarioForo;

import com.forohub.foroHub.domain.topico.Topico;

public record DatosListadoUsuariosForo(
        Long id,
        String nombre,
        String email
) {
    public DatosListadoUsuariosForo(UsuarioForo usuarioForo){
        this(usuarioForo.getId(), usuarioForo.getNombre(), usuarioForo.getEmail());
    }
}
