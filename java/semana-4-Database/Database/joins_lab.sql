
CREATE DATABASE IF NOT EXISTS joins_lab;
USE joins_lab;

-- Tabla madre: dueños
CREATE TABLE duenos (
    id_dueno INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Tabla hija: mascotas
CREATE TABLE mascotas (
    id_mascota INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    especie VARCHAR(30) NOT NULL,
    id_dueno INT NULL,
    FOREIGN KEY (id_dueno) REFERENCES duenos(id_dueno)
);

-- Insertar 10 dueños
INSERT INTO duenos (id_dueno, nombre) VALUES
(1, 'Ana'),
(2, 'Luis'),
(3, 'Marta'),
(4, 'Pedro'),
(5, 'Sofia'),
(6, 'Carlos'),
(7, 'Elena'),
(8, 'David'),
(9, 'Laura'),
(10, 'Jorge');

-- Insertar 10 mascotas
INSERT INTO mascotas (id_mascota, nombre, especie, id_dueno) VALUES
(1, 'Luna', 'Perro', 1),
(2, 'Michi', 'Gato', 2),
(3, 'Rocky', 'Perro', 1),
(4, 'Nemo', 'Pez', 4),
(5, 'Coco', 'Loro', 5),
(6, 'Toby', 'Perro', NULL),
(7, 'Mia', 'Gato', 7),
(8, 'Dori', 'Pez', NULL),
(9, 'Max', 'Perro', 2),
(10, 'Kira', 'Gato', 10);


-- seleciones

SELECT
    d.nombre AS dueno,
    m.nombre AS mascota,
    m.especie
FROM duenos d
INNER JOIN mascotas m
    ON d.id_dueno = m.id_dueno;



SELECT
    d.nombre AS dueno,
    m.nombre AS mascota,
    m.especie
FROM duenos d
LEFT JOIN mascotas m
    ON d.id_dueno = m.id_dueno;



SELECT
    d.nombre AS dueno,
    m.nombre AS mascota,
    m.especie
FROM duenos d
RIGHT JOIN mascotas m
    ON d.id_dueno = m.id_dueno;



SELECT d.id_dueno, d.nombre
FROM duenos d
LEFT JOIN mascotas m
    ON d.id_dueno = m.id_dueno
WHERE m.id_mascota IS NULL;
