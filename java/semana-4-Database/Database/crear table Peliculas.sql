CREATE TABLE peliculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    protagonista VARCHAR(100),
    anio INT,
    genero VARCHAR(50),
    recaudacion DECIMAL(12,2)
);