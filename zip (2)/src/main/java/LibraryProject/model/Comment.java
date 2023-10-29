package LibraryProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JsonManagedReference
   @JsonIgnore
   @JoinColumn(name = "book_comment_id")
   private Book book;

    private CommentType commentType;

    @Lob
    @Nationalized
    private String content;

    public Comment(Book book, CommentType commentType, String content) {
        this.book = book;
        this.commentType = commentType;
        this.content = content;
    }

    public Comment(int id, Book book, CommentType commentType, String content) {
        this.id = id;
        this.book = book;
        this.commentType = commentType;
        this.content = content;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
