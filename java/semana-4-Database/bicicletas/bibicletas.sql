CREATE DATABASE bicicletas;

Use bicicletas;

CREATE TABLE bicicletas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    material VARCHAR(50),
    anio INT,
    precio DECIMAL(10,2) NOT NULL
);

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE
);

CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    cliente_id INT NOT NULL,
    bicicleta_id INT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
    FOREIGN KEY (bicicleta_id) REFERENCES bicicletas(id)
);

INSERT INTO bicicletas (marca, modelo, material, anio, precio)
VALUES
('Trek', 'Marlin 7', 'Aluminio', 2024, 1200.00),
('Specialized', 'Rockhopper', 'Aluminio', 2023, 900.00),
('Orbea', 'Alma H30', 'Aluminio', 2024, 1500.00),
('Giant', 'Talon 2', 'Aluminio', 2023, 750.00),
('Cannondale', 'Trail 5', 'Aluminio', 2024, 1800.00);

INSERT INTO clientes (nombre, apellido, email)
VALUES
('Antonio', 'García', 'antonio@gmail.com'),
('Mohammed', 'Alisawi', 'mohammed@gmail.com'),
('Laura', 'Martínez', 'laura@gmail.com'),
('Ana', 'López', 'ana@gmail.com');

INSERT INTO pedidos (fecha, cliente_id, bicicleta_id)
VALUES
('2026-09-20', 1, 1),
('2026-09-21', 2, 3),
('2026-09-22', 3, 2),
('2026-09-23', 4, 5);


-- 4.1
SELECT *
FROM bicicletas
WHERE precio > 1000;

-- 4.2
SELECT *
FROM bicicletas
ORDER BY precio DESC;

-- 4.3
SELECT *
FROM clientes
WHERE nombre LIKE 'A%';

-- 4.4
SELECT *
FROM bicicletas
WHERE precio BETWEEN 500 AND 1500;

-- 4.5
SELECT COUNT(*) AS total_clientes
FROM clientes;

-- 4.6
SELECT clientes.nombre, pedidos.fecha
FROM clientes
INNER JOIN pedidos
ON clientes.id = pedidos.cliente_id;

-- 4.7
SELECT
    clientes.nombre AS cliente,
    bicicletas.modelo AS bicicleta,
    pedidos.fecha
FROM pedidos
INNER JOIN clientes
ON pedidos.cliente_id = clientes.id
INNER JOIN bicicletas
ON pedidos.bicicleta_id = bicicletas.id;

-- 4.8
SELECT
    clientes.nombre AS cliente,
    bicicletas.modelo AS bicicleta,
    bicicletas.precio
FROM pedidos
INNER JOIN clientes
ON pedidos.cliente_id = clientes.id
INNER JOIN bicicletas
ON pedidos.bicicleta_id = bicicletas.id
WHERE clientes.nombre LIKE 'A%';