package com.challenge.Literalura.controlador;

import com.challenge.Literalura.modelos.Autor;
import com.challenge.Literalura.modelos.Libro;
import com.challenge.Literalura.servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping("/buscar")
    public void buscarLibro(@RequestParam String titulo) {
        libroService.buscarLibro(titulo);
    }

    @GetMapping("/listar")
    public List<Libro> listarLibros() {
        return libroService.listarLibros();
    }

    @GetMapping("/autores")
    public Set<Autor> listarAutores() {
        return libroService.listarAutores();
    }

    @GetMapping("/autoresVivos")
    public Set<Autor> listarAutoresVivos(@RequestParam String anio) {
        return libroService.listarAutoresVivosEnAnio(anio);
    }

    @GetMapping("/idioma")
    public List<Libro> listarLibrosPorIdioma(@RequestParam String idioma) {
        return libroService.listarLibrosPorIdioma(idioma);
    }
}
