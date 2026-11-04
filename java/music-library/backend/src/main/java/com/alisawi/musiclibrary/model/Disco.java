package com.alisawi.musiclibrary.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "discos")
public class Disco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank(message = "El artista es obligatorio")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String artista;

    @Min(value = 1, message = "El año debe ser válido")
    @Max(value = 2100, message = "El año debe ser válido")
    private Integer lanzamiento;

    public Disco() {
    }

    public Disco(String titulo, String artista, Integer lanzamiento) {
        this.titulo = titulo;
        this.artista = artista;
        this.lanzamiento = lanzamiento;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public Integer getLanzamiento() { return lanzamiento; }

    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setArtista(String artista) { this.artista = artista; }
    public void setLanzamiento(Integer lanzamiento) { this.lanzamiento = lanzamiento; }
}
