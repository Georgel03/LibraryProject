package LibraryProject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;
    private String author;
    private String bookTitle;
    private String bookGenre;
    private int yearOfPublish;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "book")
    private List<Comment> comments;


    public Book(String author, String bookTitle, String bookGenre, int yearOfPublish, List<Comment> comments) {
        this.author = author;
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
        this.yearOfPublish = yearOfPublish;
        this.comments = comments;
    }

    public Book(int bookId, String author, String bookTitle, String bookGenre, int yearOfPublish, List<Comment> comments) {
        this.bookId = bookId;
        this.author = author;
        this.bookTitle = bookTitle;
        this.bookGenre = bookGenre;
        this.yearOfPublish = yearOfPublish;
        this.comments = comments;
    }

    public Book() {
        this.comments = new ArrayList<>();
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public void addComment(Comment comment) {
        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        else {
            this.comments.add(comment);
        }
    }

    public void removeComment(Comment comment) {
        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        else {
            this.comments.remove(comment);
        }
    }

//    public Book replaceComment(Comment newComment) {
//        if (this.comments == null) {
//            this.comments = new ArrayList<>();
//        }
//        else {
//            Optional<Comment> foundComment = this.comments
//                    .stream()
//                    .filter(comment -> comment.getId() == commentId)
//                    .findFirst();
//            if (foundComment.isPresent()) {
//                newComment.setId(commentId);
//            }
//        }
//    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
