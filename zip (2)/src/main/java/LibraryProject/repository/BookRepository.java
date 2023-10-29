package LibraryProject.repository;

import LibraryProject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


    List<Book> findAll();

    @Query("SELECT b FROM Book b WHERE b.author = :authorName")
    List<Book> findAllByAuthor(@Param("authorName") String author);

    @Query("SELECT b FROM Book b WHERE b.bookTitle = :title")
    List<Book> findBookByBookTitle(@Param("title") String bookTitle);

    @Query("Select b FROM Book b Where b.yearOfPublish < :min")
    List<Book> findByYearBefore(@Param("min") Integer yearOfPublish);

    @Query("Select b FROM Book b Where b.yearOfPublish > :max")
    List<Book> findByYearAfter(@Param("max") Integer yearOfPublish);

    @Query("Select b FROM Book b Where b.bookGenre = :genre")
    List<Book> findByBookGenre(@Param("genre") String bookGenre);




}
