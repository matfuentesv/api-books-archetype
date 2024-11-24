package cl.company.controller;

import cl.company.exception.ApiResponse;
import cl.company.model.Book;
import cl.company.service.BookService;


import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@Log
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping(value = "/findAllBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Book>> findAllBook() {
        log.info("Se solicita la lista de todas los libros.");
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/findBook/{id}")
    public ResponseEntity<Object> findBook(@PathVariable Long id) {

        if (StringUtils.containsWhitespace(String.valueOf(id))|| id == null) {
            log.info("El id no se ingreso");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Algunos de los parámetros no se ingresaron",false));
        }
        return ResponseEntity.ok(bookService.findBook(id));
    }

    @PostMapping("/createBook")
    public ResponseEntity<Object> createBook( @RequestBody Book book,
                                             BindingResult bindingResult) throws MethodArgumentNotValidException {

        if (book == null) {
            log.info("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Algunos de los parámetros no se ingresaron",false));
        }

        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        return ResponseEntity.ok(bookService.createBook(book));
    }


    @PutMapping("/updateBook")
    public ResponseEntity<Object> updateBook( @RequestBody Book book,
                                             BindingResult bindingResult) throws MethodArgumentNotValidException {

        if (book == null) {
            log.info("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Algunos de los parámetros no se ingresaron",false));
        }

        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }

        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id) {

        if (StringUtils.containsWhitespace(String.valueOf(id))|| id == null) {
            log.info("El id no se ingreso");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Algunos de los parámetros no se ingresaron",false));
        }


        Book book = bookService.findBook(id);

        if (book.getId() != null) {
            bookService.deleteBook(id);
            return ResponseEntity.ok(new ApiResponse("Libro eliminada",true));
        } else {
            log.info("Libro no encontrado con id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Libro no encontrado",false));
        }
    }

}


