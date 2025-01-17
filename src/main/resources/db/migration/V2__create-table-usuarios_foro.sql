create table usuarios_foro(

    id SERIAL,
    nombre varchar(100) not null unique,
    email varchar(100) not null unique,
    status boolean not null,

    primary key(id)

);