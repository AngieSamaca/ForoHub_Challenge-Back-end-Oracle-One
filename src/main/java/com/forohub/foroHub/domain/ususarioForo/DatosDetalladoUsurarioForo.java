package com.forohub.foroHub.domain.ususarioForo;

public record DatosDetalladoUsurarioForo(Long id,
                                         String nombre,
                                         String email
) {
    public DatosDetalladoUsurarioForo (UsuarioForo usuarioForo){
        this(usuarioForo.getId(), usuarioForo.getNombre(), usuarioForo.getEmail());
    }
}
