package LibraryProject.ui;

import LibraryProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookUiController {

    private BookService bookService;


    @Autowired
    public BookUiController(BookService bookService) {
        this.bookService = bookService;
    }


}
