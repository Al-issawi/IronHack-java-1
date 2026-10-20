
-- 1. Crear la base de datos
CREATE DATABASE podcast_db;
USE podcast_db;

-- 2. Crear la tabla de usuarios
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- 3. Crear la tabla de podcasts
CREATE TABLE podcast (
    id_podcast INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL
);

-- 4. Crear la tabla-puente de descargas
CREATE TABLE descargas (
    id_descarga INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_podcast INT NOT NULL,
    fecha_descarga TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (id_usuario)
        REFERENCES usuario(id_usuario),

    FOREIGN KEY (id_podcast)
        REFERENCES podcast(id_podcast)
);

