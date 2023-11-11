package LibraryProject.controller;

import LibraryProject.model.Book;
import LibraryProject.model.Comment;
import LibraryProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String authorName,
                                  @RequestParam(required = false) String bookTitle,
                                  @RequestParam(required = false) String bookGenre,
                                  @RequestParam(required = false) Integer yearOfPublish) {

        return bookService.getAllBooks(authorName, bookTitle,
                bookGenre, yearOfPublish);
    }
    @GetMapping("{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("{bookId}")
    public String deleteBook(@PathVariable int bookId) {
        return bookService.removeBook(bookId);
    }

    @PutMapping("{bookId}")
    public Book putBook(@PathVariable int bookId, @RequestBody Book book) {
        return bookService.replaceBook(bookId, book);
    }
}
