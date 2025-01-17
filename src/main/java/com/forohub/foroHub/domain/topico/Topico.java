package com.forohub.foroHub.domain.topico;

import com.forohub.foroHub.domain.ususarioForo.UsuarioForo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name= "topicos")
@Entity(name= "Topico")
@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private Boolean status;
    private String autor;
    private String curso;
    private Integer idusuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario", referencedColumnName = "id", insertable = false, updatable = false)
    private UsuarioForo usuarioForo;

    public Topico( DatosRegistroTopico datosRegistroTopico) {
    this.idusuario = datosRegistroTopico.idusuario();
    this.titulo = datosRegistroTopico.titulo();
    this.mensaje = datosRegistroTopico.mensaje();
    this.status =true;
    this.autor = datosRegistroTopico.autor();
    this.curso= datosRegistroTopico.curso();
    this.fecha= LocalDateTime.now();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.curso() != null) {
            this.curso = datosActualizarTopico.curso();
        }
        if (datosActualizarTopico.autor() != null) {
            this.autor = datosActualizarTopico.autor();
        }
    }
    public void desactivarTopico() {
        this.status = false;
    }

    public Topico(){
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }

    public Integer getIdusuario() {
        return idusuario;
    }
}
