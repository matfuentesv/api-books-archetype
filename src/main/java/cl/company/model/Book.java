package cl.company.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    private String title;

    @Column(name = "author")

    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "publishedDate")
    private String publishedDate;

    @Column(name = "gender")
    private String gender;

    @Column(name = "linkImage")

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
