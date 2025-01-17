package com.forohub.foroHub.controller;

import com.forohub.foroHub.domain.ususarioForo.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios_foro")
@SecurityRequirement(name = "bearer-key")
public class UsuarioForoController {

    @Autowired
    private UsuarioForoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarUsuarioForo(@RequestBody @Valid DatosRegistroUsuarioForo datosRegistroUsuarioForo,
                                               UriComponentsBuilder uriBuilder) {
        try {
            var usuarioForo = new UsuarioForo(datosRegistroUsuarioForo);
            if (repository.existsByEmail(usuarioForo.getEmail())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ya está registrado");
            }
            repository.save(usuarioForo);
            var uri = uriBuilder.path("/usuarios_foro/{id}").buildAndExpand(usuarioForo.getId()).toUri();
            return ResponseEntity.created(uri).body(new DatosDetalladoUsurarioForo(usuarioForo));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al registrar el usuario", e);
        }
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuariosForo>> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(repository.findByStatusTrue(paginacion).map(DatosListadoUsuariosForo::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarUsuariosForo(@RequestBody @Valid DatosActualizarUsuariosForo datosActualizarUsuariosForo) {
        UsuarioForo usuarioForo = repository.getReferenceById(datosActualizarUsuariosForo.id());
        usuarioForo.actualizarDatos(datosActualizarUsuariosForo);
        return ResponseEntity.ok(new DatosDetalladoUsurarioForo(usuarioForo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuarioForo(@PathVariable Long id) {
        UsuarioForo usuarioForo = repository.getReferenceById(id);
        usuarioForo.desactivarTopico();
        return ResponseEntity.noContent().build();
    }
}
