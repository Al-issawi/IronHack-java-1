INSERT INTO peliculas 
(titulo, protagonista, anio, genero, recaudacion) VALUES
('Titanic', 'Leonardo DiCaprio', 1997, 'Drama', 2200000000),
('Avatar', 'Sam Worthington', 2009, 'Ciencia ficción', 2920000000),
('The Dark Knight', 'Christian Bale', 2008, 'Acción', 1005000000),
('Inception', 'Leonardo DiCaprio', 2010, 'Ciencia ficción', 839000000),
('Gladiator', 'Russell Crowe', 2000, 'Acción', 465000000),
('Interstellar', 'Matthew McConaughey', 2014, 'Ciencia ficción', 733000000),
('Joker', 'Joaquin Phoenix', 2019, 'Drama', 1074000000),
('The Matrix', 'Keanu Reeves', 1999, 'Ciencia ficción', 467000000),
('Forrest Gump', 'Tom Hanks', 1994, 'Drama', 678000000),
('The Avengers', 'Robert Downey Jr.', 2012, 'Acción', 1520000000);

SELECT titulo, anio
FROM peliculas;

SELECT *
FROM peliculas
WHERE anio >= 2010;

SELECT *
FROM peliculas
WHERE anio >= 2010
ORDER BY anio ASC;


SELECT *
FROM peliculas
WHERE anio >= 2010
ORDER BY anio desc;

SELECT *
FROM peliculas
ORDER BY titulo ASC;

SELECT *
FROM peliculas
ORDER BY titulo DESC;

SELECT *
FROM peliculas
ORDER BY genero;

SELECT genero, COUNT(*) AS cantidad
FROM peliculas
GROUP BY genero;

SELECT *
FROM peliculas
WHERE recaudacion < 500000000;


SELECT *
FROM peliculas
WHERE anio BETWEEN 2000 AND 2010;

SELECT *
FROM peliculas
WHERE anio >= 2000 AND anio <= 2010;

SELECT COUNT(*) AS total_peliculas
FROM peliculas;

SELECT SUM(recaudacion) AS recaudacion_total
FROM peliculas;

SELECT AVG(recaudacion) AS recaudacion_media
FROM peliculas;

SELECT *
FROM peliculas
WHERE titulo LIKE '%The%';

SELECT *
FROM peliculas
WHERE protagonista LIKE '%a%';

SELECT *
FROM peliculas
ORDER BY recaudacion DESC
LIMIT 1;


SELECT 
    titulo AS 'Película',
    recaudacion AS 'Recaudación (€)'
FROM peliculas;


SELECT 
    AVG(recaudacion) AS 'Recaudación media'
FROM peliculas;