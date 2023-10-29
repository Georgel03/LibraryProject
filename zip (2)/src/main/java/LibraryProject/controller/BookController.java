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
    public List<Book> getAllBooks()  {
        return bookService.getAllBooks();
    }

    @GetMapping("{bookId}/comments")
    public List<Comment> getCommentsByBook(@PathVariable int bookId) {
        return bookService.getCommentsByBookId(bookId);
    }

    @GetMapping("{bookId}")
    public Book getBookById(@PathVariable int bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping("{bookId}")
    public Book addCommentToBook(@PathVariable int bookId, @RequestBody Comment comment) {
        return bookService.addCommentToBook(bookId, comment);
    }


    @DeleteMapping("{bookId}")
    public String deleteBook(@PathVariable int bookId) {
        return bookService.removeBook(bookId);
    }

    @DeleteMapping("{bookId}/{commentId}")
    public String deleteCommentFromBook(@PathVariable int bookId, @PathVariable int commentId) {
        return bookService.deleteCommentFromBook(bookId, commentId);
    }

    @PutMapping("{bookId}")
    public Book putBook(@RequestBody Book book, @PathVariable int bookId) {
        return bookService.replaceBook(bookId, book);
    }
}
