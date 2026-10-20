
-- Insertar usuarios
INSERT INTO usuario (nombre)
VALUES
('Mohammed'),
('Laura'),
('Carlos');

-- Insertar podcasts
INSERT INTO podcast (titulo)
VALUES
('Introduccion a Java'),
('Bases de datos MySQL'),
('Desarrollo web');

-- Registrar descargas
INSERT INTO descargas (id_usuario, id_podcast)
VALUES
(1, 1),
(1, 2),
(1, 1),
(2, 3),
(3, 2);



SELECT
    u.nombre AS usuario,
    p.titulo AS podcast,
    d.fecha_descarga
FROM descargas d
INNER JOIN usuario u
    ON d.id_usuario = u.id_usuario
INNER JOIN podcast p
    ON d.id_podcast = p.id_podcast
ORDER BY d.fecha_descarga;



SELECT
    u.nombre,
    p.titulo,
    d.fecha_descarga
FROM descargas d
INNER JOIN usuario u
    ON d.id_usuario = u.id_usuario
INNER JOIN podcast p
    ON d.id_podcast = p.id_podcast
WHERE u.nombre = 'Mohammed';



SELECT
    p.titulo,
    COUNT(d.id_descarga) AS total_descargas
FROM podcast p
LEFT JOIN descargas d
    ON p.id_podcast = d.id_podcast
GROUP BY p.id_podcast, p.titulo;

