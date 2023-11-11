package LibraryProject.controller;


import LibraryProject.model.Book;
import LibraryProject.model.Comment;
import LibraryProject.model.CommentType;
import LibraryProject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
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

    @PostMapping("{bookId}")
    public Comment addCommentToBook(@PathVariable int bookId, @RequestBody Comment comment) {
        return commentService.addCommentToBook(bookId, comment);
    }

    @DeleteMapping("{commentId}")
    public String deleteComment(@PathVariable int commentId) {
        return commentService.deleteComment(commentId);
    }

    @PutMapping
    public Comment replaceComment(@RequestBody Comment comment) {
        return commentService.replaceComment(comment);
    }

}
