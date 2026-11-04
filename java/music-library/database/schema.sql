CREATE TABLE IF NOT EXISTS discos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    artista VARCHAR(100) NOT NULL,
    lanzamiento INT,
    PRIMARY KEY (id)
);

-- Optional example records:
INSERT INTO discos (titulo, artista, lanzamiento)
SELECT 'Random Access Memories', 'Daft Punk', 2013
WHERE NOT EXISTS (
    SELECT 1 FROM discos WHERE titulo = 'Random Access Memories' AND artista = 'Daft Punk'
);

INSERT INTO discos (titulo, artista, lanzamiento)
SELECT 'Back to Black', 'Amy Winehouse', 2006
WHERE NOT EXISTS (
    SELECT 1 FROM discos WHERE titulo = 'Back to Black' AND artista = 'Amy Winehouse'
);
