package com.daw.mediateca.serie;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/series")
public class SerieController {

    private final List<Serie> series = List.of(
            new Serie(1L, "La casa de papel", 5, "Netflix"),
            new Serie(2L, "The Mandalorian", 3, "Disney+"),
            new Serie(3L, "El Ministerio del Tiempo", 4, "RTVE Play"));

    @GetMapping // Get /series
    public List<Serie> listar() {
        return series;
    }

    @GetMapping("/{id}") // Get /series/1
    public Serie buscarPorId(@PathVariable Long id) {
        return series.stream()
                .filter(s -> s.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}