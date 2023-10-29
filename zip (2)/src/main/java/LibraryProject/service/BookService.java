package LibraryProject.service;

import LibraryProject.exception.EntityNotFoundException;
import LibraryProject.model.Book;
import LibraryProject.model.Comment;
import LibraryProject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getAllBooksByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
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

    public Book addCommentToBook(int bookId, Comment comment) {
        Optional<Book> foundBook = bookRepository.findById(bookId);
        if (foundBook.isPresent()) {
            Book book = foundBook.get();
            comment.setBook(book);
            book.addComment(comment);
            return bookRepository.save(book);
        }
        else {
            throw new EntityNotFoundException("Nu a fost gasita cartea cu id " + bookId, bookId);
        }
    }

    public String deleteCommentFromBook(int bookId, int commentId) {

        Optional<Book> bookFromDB = bookRepository.findById(bookId);
        if (bookFromDB.isPresent()) {
            Book foundBook = bookFromDB.get();
            Optional<Comment> foundComment =
                    foundBook.getComments().stream()
                    .filter(comment -> comment.getId() == commentId)
                    .findFirst();
            if (foundComment.isPresent()) {
                Comment comment = foundComment.get();
                comment.setBook(null);
               foundBook.removeComment(comment);
                bookRepository.save(foundBook);
                return String.format("Am sters comentariul cu id:%d din cartea: %s",
                        comment.getId(), foundBook.getBookTitle());
            }

            else  {
                throw new EntityNotFoundException("Nu a fost gasita comentariul cu id " + commentId, commentId);
            }
        }
        else {
            throw new EntityNotFoundException("Nu a fost gasita cartea cu id " + bookId, bookId);
        }
    }

//    public Book replaceCommentFromBook(int bookId, int commentId, Comment newComment) {
//        Optional<Book> bookFromDB = bookRepository.findById(bookId);
//        if (bookFromDB.isPresent()) {
//            Book foundBook = bookFromDB.get();
//            Optional<Comment> commentFromDB = foundBook.getComments().stream()
//                    .filter(comment1 -> comment1.getId() == commentId)
//                    .findFirst();
//            if (commentFromDB.isPresent()) {
//                Comment comment = commentFromDB.get();
//                newComment.setId(commentId);
//                foundBook.
//            }
//        }
//    }

}
