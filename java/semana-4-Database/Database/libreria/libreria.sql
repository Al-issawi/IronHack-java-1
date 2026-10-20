CREATE DATABASE IF NOT EXISTS libreria;
USE libreria;

CREATE TABLE autor (
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    pais VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE libro (
    id INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(150) NOT NULL,
    fecha YEAR,
    genero VARCHAR(50),
    precio DECIMAL(10,2),
    id_autor INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_autor)
        REFERENCES autor(id)
);
