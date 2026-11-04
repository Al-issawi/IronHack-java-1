package com.alisawi.musiclibrary.controller;

import com.alisawi.musiclibrary.model.Disco;
import com.alisawi.musiclibrary.repository.DiscoRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/discos")
public class DiscoController {

    private final DiscoRepository repository;

    public DiscoController(DiscoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Disco> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Disco buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disco no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Disco crear(@Valid @RequestBody Disco disco) {
        disco.setId(null);
        return repository.save(disco);
    }

    @PutMapping("/{id}")
    public Disco actualizar(@PathVariable Long id, @Valid @RequestBody Disco datos) {
        Disco disco = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Disco no encontrado"));
        disco.setTitulo(datos.getTitulo());
        disco.setArtista(datos.getArtista());
        disco.setLanzamiento(datos.getLanzamiento());
        return repository.save(disco);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Disco no encontrado");
        }
        repository.deleteById(id);
    }
}
