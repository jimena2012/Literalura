package com.challenge.Literalura.repositorio;

import com.challenge.Literalura.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByLanguage(String language);
}
