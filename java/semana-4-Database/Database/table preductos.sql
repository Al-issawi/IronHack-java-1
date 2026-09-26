INSERT INTO productos (nombre, precio, fecha_alta) VALUES
('Mesa', 120.50, '2026-01-10'),
('Silla', 45.90, '2026-01-15'),
('Lampara', 35.00, '2026-02-05'),
('Monitor', 250.99, '2026-02-20'),
('Teclado', 55.50, '2026-03-01');

SELECT * FROM tienda.productos;
SELECT * FROM productos;
SELECT nombre FROM productos;
SELECT nombre, precio FROM productos;

SELECT * FROM productos
WHERE id = 3;

SELECT * FROM productos
WHERE nombre = 'Monitor';

SELECT * FROM productos
WHERE precio > 100;

SELECT * FROM productos
WHERE precio < 100;

SELECT * FROM productos
WHERE precio = 55.50;

SELECT * FROM productos
ORDER BY precio;

SELECT * FROM productos
ORDER BY precio ASC;

SELECT * FROM productos
ORDER BY precio DESC;

SELECT * FROM productos
WHERE nombre LIKE '%m%';

SELECT * FROM productos
WHERE nombre LIKE 'M%';

SELECT * FROM productos
WHERE nombre LIKE '%a';

SELECT * FROM productos
WHERE nombre LIKE 'M_sa';