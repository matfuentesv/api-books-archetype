package cl.company.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Entity
@Table(name = "Book")

public class Book {

    // Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    @NotBlank(message = "No puede ingresar un title vacio")
    @NotNull(message = "No puede ingresar un title nulo")
    private String title;

    @Column(name = "author")
    @NotBlank(message = "No puede ingresar un author vacio")
    @NotNull(message = "No puede ingresar un author nulo")
    private String author;

    @Column(name = "description")
    @NotBlank(message = "No puede ingresar un title vacio")
    @NotNull(message = "No puede ingresar un title nulo")
    private String description;

    @Column(name = "publishedDate")
    @NotBlank(message = "No puede ingresar un author vacio")
    @NotNull(message = "No puede ingresar un author nulo")
    private String publishedDate;

    @Column(name = "gender")
    @NotBlank(message = "No puede ingresar un gender vacio")
    @NotNull(message = "No puede ingresar un gender nulo")
    private String gender;

    @Column(name = "linkImage")
    @NotBlank(message = "No puede ingresar un linkImage vacio")
    @NotNull(message = "No puede ingresar un linkImage nulo")
    private String linkImage;

    // Constructor privado para el Builder
    private Book(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.author = builder.author;
        this.description = builder.description;
        this.publishedDate = builder.publishedDate;
        this.gender = builder.gender;
        this.linkImage = builder.linkImage;
    }

    public Book() {

    }

    // Builder interno
    public static class Builder {
        private int id;
        private String title;
        private String author;
        private String description;
        private String publishedDate;
        private String gender;
        private String linkImage;


    }

}
