package com.forohub.foroHub.domain.ususarioForo;

import com.forohub.foroHub.domain.topico.Topico;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name= "usuarios_foro")
@Entity(name= "usuarios_foro")
@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioForo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private Boolean status;

    @OneToMany(mappedBy = "usuarioForo")
    private List<Topico> listaTopicos;

    public UsuarioForo(DatosRegistroUsuarioForo datosRegistroUsuarioForo){
        this.nombre = datosRegistroUsuarioForo.nombre();
        this.email = datosRegistroUsuarioForo.email();
        this.status = true;
    }

    public void actualizarDatos( DatosActualizarUsuariosForo datosActualizarUsuariosForo) {
        if (datosActualizarUsuariosForo.nombre() != null) {
            this.nombre = datosActualizarUsuariosForo.nombre();
        }
        if (datosActualizarUsuariosForo.email() != null) {
            this.email = datosActualizarUsuariosForo.email();
        }
    }

    public void desactivarTopico() {
        this.status = false;
    }

    public UsuarioForo() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }
}

