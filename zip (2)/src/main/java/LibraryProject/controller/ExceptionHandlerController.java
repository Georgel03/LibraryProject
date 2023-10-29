package LibraryProject.controller;

import LibraryProject.exception.ApiException;
import LibraryProject.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiException handleNotFound(EntityNotFoundException exception) {
        return new ApiException(exception.getMessage(), exception.getEntityId(), HttpStatus.NOT_FOUND);
    }
}
