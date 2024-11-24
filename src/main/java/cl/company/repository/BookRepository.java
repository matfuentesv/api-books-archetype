package cl.company.repository;

import cl.company.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT u FROM Book u WHERE u.title = :title")
    Optional<Book> findBookByTitle(@Param("title") String title);

}
