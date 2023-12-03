package LibraryProject.service;

import LibraryProject.exception.EntityNotFoundException;
import LibraryProject.model.Book;
import LibraryProject.model.Comment;
import LibraryProject.model.CommentType;
import LibraryProject.repository.BookRepository;
import LibraryProject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    private BookRepository bookRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository,
                          BookRepository bookRepository) {
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
    }

    public Comment getCommentById(int commentId) {
       Optional<Comment> commentFromDB = commentRepository.findById(commentId);
       if (commentFromDB.isPresent()) {
           return commentFromDB.get();
       }
       else {
           throw new EntityNotFoundException("Nu a fost gasit comentariul cu id : " + commentId, commentId);
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

    public List<Comment> getAllComments(Book book, CommentType commentType) {

        if (book != null) {
            if (commentType != null) {
                return commentRepository.findCommentsByBookAndCommentType(book, commentType);
            }
            else {
                return commentRepository.findCommentsByBook(book);
            }
        }
        else if (commentType != null) {
            return commentRepository.findCommentsByCommentType(commentType);
        }
        else {
            return commentRepository.findAll();
        }
    }

    public Comment addCommentToBook(int bookId, Comment comment) {
        Optional<Book> foundBook = bookRepository.findById(bookId);
        if (foundBook.isPresent()) {
            Book book = foundBook.get();
            comment.setBook(book);
            book.addComment(comment);
            bookRepository.save(book);
            return comment;
        } else {
            throw new EntityNotFoundException("Nu a fost gasita cartea cu id " + bookId, bookId);
        }
    }

    public String deleteComment(int commentId) {
        Optional<Comment> commentFromDB = commentRepository.findById(commentId);
        if (commentFromDB.isPresent()) {
            Comment comment = commentFromDB.get();
            Book book = comment.getBook();
            if (book != null) {
                book.removeComment(comment);
                comment.setBook(null);
                bookRepository.save(book);
            }
            commentRepository.delete(comment);
            return String.format("A fost sters comentariul cu id:%d", commentId);
        } else {
            throw new EntityNotFoundException("Nu a putut fi sters comentariul cu id " + commentId, commentId);
        }
    }


    public Comment replaceComment(int commentId, Comment comment) {
            Optional<Comment> foundComment = commentRepository.findById(commentId);
            if (foundComment.isPresent()) {
                comment.setId(commentId);
                comment.setBook(foundComment.get().getBook());
                return commentRepository.save(comment);
            }
            else {
                throw new EntityNotFoundException("Nu a fost inlocuita comentariul cu id " + commentId, commentId);
            }

    }


}
