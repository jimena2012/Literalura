package com.challenge.Literalura.modelos;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthYear;
    private String deathYear;
    @ManyToMany(mappedBy = "authors")
    private Set<Libro> libros;

    // Getters y setters

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Autor autor = (Autor) obj;
        return id != null && id.equals(autor.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", deathYear='" + deathYear + '\'' +
                '}';
    }

    public Comparable<String> getBirthYear() {
        return this.birthYear;
    }

    public Comparable<String> getDeathYear() {
        return  this.deathYear;
    }
}
