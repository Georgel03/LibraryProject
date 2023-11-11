package LibraryProject.repository;

import LibraryProject.model.Book;
import LibraryProject.model.Comment;
import LibraryProject.model.CommentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAll();

    @Query("SELECT c FROM Comment c WHERE c.id =: commentId")
    Optional<Comment> findCommentById(@Param("commentId")int commentId);
    @Query("SELECT c FROM Comment c WHERE c.book =: searchedBook")
    List<Comment> findCommentsByBook(@Param("searchedBook")Book book);

    @Query("SELECT c FROM Comment c WHERE c.commentType =: searchedType")
    List<Comment> findCommentsByCommentType(@Param("searchedType")CommentType commentType);

    @Query("SELECT c FROM Comment c WHERE c.book =: searchedBook AND c.commentType =: searchedType")
    List<Comment> findCommentsByBookAndCommentType(@Param("searchedBook")Book book,
                                                   @Param("searchedType")CommentType commentType);
}
