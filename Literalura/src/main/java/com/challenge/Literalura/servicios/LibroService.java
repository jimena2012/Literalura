package com.challenge.Literalura.servicios;

import com.challenge.Literalura.modelos.Autor;
import com.challenge.Literalura.modelos.Libro;
import com.challenge.Literalura.repositorio.LibroRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private ConsumoAPI consumoAPI;

    private Gson gson = new GsonBuilder().create();

    public void buscarLibro(String titulo) {
        String url = "https://gutendex.com/books?search=" + titulo;
        String json = consumoAPI.obtenerDatos(url);
        Libro[] libros = gson.fromJson(json, Libro[].class);
        for (Libro libro : libros) {
            if (!libroRepository.existsById(libro.getId())) {
                libroRepository.save(libro);
            }
        }
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Set<Autor> listarAutores() {
        List<Libro> libros = listarLibros();
        Set<Autor> autores = new HashSet<>();
        for (Libro libro : libros) {
            autores.addAll(libro.getAuthors());
        }
        return autores;
    }

    public Set<Autor> listarAutoresVivosEnAnio(String anio) {
        Set<Autor> autores = listarAutores();
        Set<Autor> autoresVivos = new HashSet<>();
        for (Autor autor : autores) {
            if (autor.getBirthYear() != null && autor.getBirthYear().compareTo(anio) <= 0
                    && (autor.getDeathYear() == null || autor.getDeathYear().compareTo(anio) > 0)) {
                autoresVivos.add(autor);
            }
        }
        return autoresVivos;
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByLanguage(idioma);
    }
}

