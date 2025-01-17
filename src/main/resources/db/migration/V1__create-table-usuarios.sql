create table usuarios(

    id SERIAL,
    login varchar(100) not null,
    clave varchar(300) not null,

    primary key(id)

);