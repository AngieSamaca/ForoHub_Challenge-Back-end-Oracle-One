package com.forohub.foroHub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
    Long id,
    String titulo,
    String mensaje,
    LocalDateTime fecha,
    Integer idusuario
) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getIdusuario());
    }
}