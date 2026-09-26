USE libreria;

INSERT INTO libro (titulo, fecha, genero, precio, id_autor) VALUES
('1984', 1949, 'Distopía', 18.50, 1),
('Rebelión en la granja', 1945, 'Fantasía', 15.90, 1),

('Harry Potter y la piedra filosofal', 1997, 'Fantasía', 22.50, 2),
('Harry Potter y la cámara secreta', 1998, 'Fantasía', 23.90, 2),

('El Hobbit', 1937, 'Fantasía', 19.90, 3),
('El Señor de los Anillos', 1954, 'Fantasía', 35.50, 3),

('Cien años de soledad', 1967, 'Realismo mágico', 21.50, 4),


('Tokio Blues', 1987, 'Novela', 20.50, 6),
('Kafka en la orilla', 2002, 'Novela', 24.90,5);

select * from libro;