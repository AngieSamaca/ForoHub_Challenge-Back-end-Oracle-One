create table topicos(

    id SERIAL,
    titulo varchar(100) not null unique,
    mensaje varchar(1000) not null unique,
    fecha timestamp not null,
    status boolean not null,
    autor varchar(100) not null,
    curso varchar(100) not null,
    idusuario int not null,

    primary key(id),
    CONSTRAINT fk_topicos_usuarios_foro_id FOREIGN KEY (idusuario) REFERENCES usuarios_foro(id) ON DELETE CASCADE

);