package cl.company.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "Book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


    private Book(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.author = builder.author;
        this.description = builder.description;
        this.publishedDate = builder.publishedDate;
        this.gender = builder.gender;
        this.linkImage = builder.linkImage;
    }




    public static class Builder {
        private Long id;
        private String title;
        private String author;
        private String description;
        private String publishedDate;
        private String gender;
        private String linkImage;



        public Builder id(Long id) {
            this.id = id;
            return this;
        }


        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }



        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder publishedDate(String publishedDate) {
            this.publishedDate = publishedDate;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder linkImage(String linkImage) {
            this.linkImage = linkImage;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

}
