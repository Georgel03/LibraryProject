package LibraryProject.controller;


import LibraryProject.model.Book;
import LibraryProject.model.Comment;
import LibraryProject.model.CommentType;
import LibraryProject.service.BookService;
import LibraryProject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("comments")
public class CommentController {

    private CommentService commentService;

    private BookService bookService;

    @Autowired
    public CommentController(CommentService commentService, BookService bookService) {
        this.commentService = commentService;
        this.bookService = bookService;
    }

    @GetMapping("{commentId}")
    public Comment getCommentById(@PathVariable int commentId) {
        return commentService.getCommentById(commentId);
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam(required = false) Book book,
                                  @RequestParam(required = false) CommentType commentType) {
        return commentService.getAllComments(book, commentType);
    }

    @GetMapping("book/{bookId}")
    public List<Comment> getCommentsByBookId(@PathVariable int bookId) {
        return commentService.getCommentsByBookId(bookId);
    }

    @PostMapping("{bookId}")
    public Comment addCommentToBook(@PathVariable int bookId, @RequestBody Comment comment) {
        return commentService.addCommentToBook(bookId, comment);
    }

    @DeleteMapping("{commentId}")
    public String deleteComment(@PathVariable int commentId) {
        return commentService.deleteComment(commentId);
    }

    @PutMapping("{commentId}")
    public Comment replaceComment(@PathVariable int commentId, @RequestBody Comment comment) {
        return commentService.replaceComment(commentId, comment);
    }

}
