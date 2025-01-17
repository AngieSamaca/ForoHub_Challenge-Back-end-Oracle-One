package com.forohub.foroHub.domain.ususarioForo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioForoRepository extends JpaRepository<UsuarioForo, Long> {
    boolean existsByEmail(String email);

    Page<UsuarioForo> findByStatusTrue(Pageable paginacion);
}
