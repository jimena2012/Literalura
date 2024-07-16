package com.challenge.Literalura;

import com.challenge.Literalura.modelos.Libro;
import com.challenge.Literalura.servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Menu implements CommandLineRunner {
    @Autowired
    private LibroService libroService;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Buscar un libro");
            System.out.println("2. Listar los libros registrados");
            System.out.println("3. Listar los autores registrados");
            System.out.println("4. Listar autores vivos en determinado año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el título del libro:");
                    String titulo = scanner.nextLine();
                    libroService.buscarLibro(titulo);
                    break;
                case 2:
                    List<Libro> libros = libroService.listarLibros();
                    libros.forEach(System.out::println);
                    break;
                case 3:
                    libroService.listarAutores().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Ingrese el año:");
                    String anio = scanner.nextLine();
                    libroService.listarAutoresVivosEnAnio(anio).forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Elija un idioma:");
                    System.out.println("1. Español");
                    System.out.println("2. Inglés");
                    System.out.println("3. Francés");
                    System.out.println("4. Portugués");

                    int idiomaOpcion = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character
                    String idioma = null;
                    switch (idiomaOpcion) {
                        case 1: idioma = "es"; break;
                        case 2: idioma = "en"; break;
                        case 3: idioma = "fr"; break;
                        case 4: idioma = "pt"; break;
                        default:
                            System.out.println("Opción no válida.");
                            continue;
                    }
                    libroService.listarLibrosPorIdioma(idioma).forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
