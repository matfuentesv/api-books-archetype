package cl.company.service.impl;

import cl.company.exception.ApiResponse;
import cl.company.model.Book;
import cl.company.repository.BookRepository;
import cl.company.service.BookService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Log
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBook(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElseGet(() -> new Book.Builder().build());
    }

    @Override
    public ResponseEntity<Object>  createBook(Book book) {

        if(!findBookByTitle(book.getTitle())){
            Book bookToCreate = new Book.Builder()
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .description(book.getDescription())
                    .publishedDate(book.getPublishedDate())
                    .gender(book.getGender())
                    .linkImage(book.getLinkImage())
                    .build();
            Book createdBook = bookRepository.save(bookToCreate);
            if(createdBook == null){
                log.info("Algunos de los parámetros no se ingresaron");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Algunos de los parámetros no se ingresaron",false));
            }else {
                return ResponseEntity.ok(createdBook);
            }
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("No se puedo actualizar el product,no existe",false));
        }
    }

    @Override
    public ResponseEntity<Object>  updateBook(Book book) {
         if(!existsBookById(book.getId())){
            Book bookToCreate = new Book.Builder()
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .description(book.getDescription())
                    .publishedDate(book.getPublishedDate())
                    .gender(book.getGender())
                    .linkImage(book.getLinkImage())
                    .build();
            Book createdBook = bookRepository.save(bookToCreate);
            if(createdBook == null){
                log.info("Algunos de los parámetros no se ingresaron");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Algunos de los parámetros no se ingresaron",false));
            }else {
                return ResponseEntity.ok(createdBook);
            }
        }else {
             log.info("No se puedo actualizar el book,no existe");
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("No se puedo actualizar el product,no existe",false));
        }
    }

    @Override
    public ResponseEntity<Object>  deleteBook(Long id) {
        if (!existsBookById(id)) {
            log.info("No se puede eliminar el book, no existe");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("El product no existe",false));
        }
        bookRepository.deleteById(id);
        return ResponseEntity.ok("Eliminación exitosa");
    }

    @Override
    public boolean findBookByTitle(String name) {
        return bookRepository.findBookByTitle(name).isPresent();
    }

    @Override
    public boolean existsBookById(Long id) {
        return bookRepository.findById(id).isPresent();
    }
}
