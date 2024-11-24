package cl.company.service;

import cl.company.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {

    List<Book> findAll();
    Book findBook(Long id);
    ResponseEntity<Object> createBook(Book book);
    ResponseEntity<Object>  updateBook(Book book);
    ResponseEntity<Object>  deleteBook(Long id);
    boolean findBookByTitle(String title);
    boolean existsBookById(Long id);
}
