USE libreria;

-- =========================================
-- FACIL
-- =========================================

-- 1. Mostrar todos los libros del género "Fantasía"
-- ordenados por precio de menor a mayor.

SELECT *
FROM libro
WHERE genero = 'Fantasía'
ORDER BY precio ASC;


-- 2. Mostrar todos los libros escritos por George Orwell.

SELECT libro.*
FROM libro
JOIN autor ON libro.id_autor = autor.id
WHERE autor.nombre = 'George'
AND autor.apellido = 'Orwell';


-- 3. Mostrar todos los libros publicados después del año 2000.

SELECT *
FROM libro
WHERE fecha > 2000;


-- 4. Mostrar los libros cuyo precio sea superior a 20 €.

SELECT *
FROM libro
WHERE precio > 20;


-- 5. Mostrar los libros cuyo título contenga la palabra "Harry".

SELECT *
FROM libro
WHERE titulo LIKE '%Harry%';


-- 6. Mostrar los libros publicados entre 1980 y 2000.

SELECT *
FROM libro
WHERE fecha BETWEEN 1980 AND 2000;


-- 7. Mostrar el título del libro y el nombre completo de su autor.

SELECT
    libro.titulo,
    CONCAT(autor.nombre, ' ', autor.apellido) AS autor
FROM libro
JOIN autor ON libro.id_autor = autor.id;


-- =========================================
-- MEDIO-FACIL
-- FUNCIONES DE AGREGACION
-- =========================================

-- 8. Funciones de agregación
-- (No es una consulta independiente, sino
-- la introducción a las siguientes consultas.)


-- 9. Calcular el precio medio de todos los libros.

SELECT AVG(precio) AS precio_medio
FROM libro;


-- 10. Contar cuántos libros hay en total.

SELECT COUNT(*) AS total_libros
FROM libro;


-- 11. Calcular el precio máximo y mínimo de los libros.

SELECT
    MAX(precio) AS precio_maximo,
    MIN(precio) AS precio_minimo
FROM libro;


-- 12. Calcular la suma de los precios de todos los libros.

SELECT SUM(precio) AS suma_precios
FROM libro;


-- =========================================
-- MEDIO-DIFICIL
-- GROUP BY
-- =========================================

-- 13. Contar cuántos libros ha escrito cada autor.

SELECT
    autor.nombre,
    autor.apellido,
    COUNT(libro.id) AS cantidad_libros
FROM autor
LEFT JOIN libro ON autor.id = libro.id_autor
GROUP BY autor.id, autor.nombre, autor.apellido;


-- 14. Mostrar el número de libros de cada género.

SELECT
    genero,
    COUNT(*) AS cantidad_libros
FROM libro
GROUP BY genero;


-- 15. Mostrar el precio medio de los libros de cada género.

SELECT
    genero,
    AVG(precio) AS precio_medio
FROM libro
GROUP BY genero;


-- 16. Mostrar cada autor junto con el precio medio de sus libros.

SELECT
    autor.nombre,
    autor.apellido,
    AVG(libro.precio) AS precio_medio
FROM autor
JOIN libro ON autor.id = libro.id_autor
GROUP BY autor.id, autor.nombre, autor.apellido;