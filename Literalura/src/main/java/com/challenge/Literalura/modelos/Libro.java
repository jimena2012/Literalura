package com.challenge.Literalura.modelos;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Autor> authors;
    private String language;

    // Getters y setters

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Libro libro = (Libro) obj;
        return id != null && id.equals(libro.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", language='" + language + '\'' +
                '}';
    }

    public Long getId() {
        return this.id;
    }

    public Collection<? extends Autor> getAuthors() {
        return this.authors;
    }
}

