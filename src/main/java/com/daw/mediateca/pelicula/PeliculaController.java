package com.daw.mediateca.pelicula;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController // Responde con datos (JSON), no con páginas HTML
@RequestMapping("/peliculas") // Todas las rutas de esta clase empiezan por /peliculas

public class PeliculaController {

    // De momento, los datos viven en memoria (en la UD5 irán a una base de datos)
    private final List<Pelicula> peliculas = List.of(
            new Pelicula(1L, "El Padrino", "Francis Ford Coppola", 1972),
            new Pelicula(2L, "La lista de Schindler", "Steven Spielberg", 1993),
            new Pelicula(3L, "Forrest Gump", "Robert Zemeckis", 1994));

    @GetMapping // Get /peliculas
    public List<Pelicula> listar() {
        return peliculas; // Spring convierte automáticamente la lista de películas a JSON
    }

    @GetMapping("/{id}")
    public Pelicula buscarPorId(@PathVariable Long id) {
        return peliculas.stream()
                .filter(p -> p.id().equals(id))
                .findFirst()
                .orElse(null); // Si no existe, respuesta vacía (lo mejoraremos en la UD3)
    }

    @GetMapping("/director/{director}")
    public List<Pelicula> buscarPorDirector(@PathVariable String director) {
        return peliculas.stream()
                .filter(p -> p.director().equalsIgnoreCase(director))
                .toList();
    }
}
