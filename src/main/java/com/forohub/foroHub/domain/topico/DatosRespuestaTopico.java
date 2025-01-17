package com.forohub.foroHub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fecha,
        Boolean status,
        String curso,
        String autor,
        Integer idusuario) {
}
