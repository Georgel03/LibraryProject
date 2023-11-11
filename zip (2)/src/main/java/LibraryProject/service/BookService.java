package LibraryProject.service;

import LibraryProject.exception.EntityNotFoundException;
import LibraryProject.model.Book;
import LibraryProject.model.Comment;
import LibraryProject.repository.BookRepository;
import LibraryProject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    private CommentRepository commentRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Book getBookById(int bookId) {
        Optional<Book> foundBook = bookRepository.findById(bookId);
        if (foundBook.isPresent()) {
            return foundBook.get();
        }
        else {
            throw new EntityNotFoundException("Nu a fost gasita cartea cu id " + bookId, bookId);
        }
    }

    public List<Book> getAllBooks(String authorName,  String bookTitle,
                                  String bookGenre, Integer yearOfPublish) {

        return bookRepository.findAll()
                .stream()
                .filter(book -> authorName == null || book.getAuthor().equals(authorName))
                .filter(book -> bookTitle == null || book.getBookTitle().equals(bookTitle))
                .filter(book -> bookGenre == null || book.getBookGenre().equals(bookGenre))
                .filter(book -> yearOfPublish == null || book.getYearOfPublish() == yearOfPublish)
                .collect(Collectors.toList());
    }
    public List<Comment> getCommentsByBookId(int bookId) {
        Optional<Book> foundBook = bookRepository.findById(bookId);
        if (foundBook.isPresent()) {
            return foundBook.get().getComments();
        }
        else {
            throw new EntityNotFoundException("Nu a fost gasita cartea cu id " + bookId, bookId);
        }
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public String removeBook(int bookId) {
        Optional<Book> foundBook = bookRepository.findById(bookId);
        if (foundBook.isPresent()) {
           bookRepository.deleteById(bookId);
           return "Sters cu succes!";
        }
        else {
            throw new EntityNotFoundException("Nu a fost stearsa cartea cu id " + bookId, bookId);
        }
    }

    public Book replaceBook(int bookId, Book book) {
        Optional<Book> foundBook = bookRepository.findById(bookId);
        if (foundBook.isPresent()) {
            book.setBookId(bookId);
            return bookRepository.save(book);
        }
        else {
            throw new EntityNotFoundException("Nu a fost inlocuita cartea cu id " + bookId, bookId);
        }
    }


}
