package br.com.glkm.parkingmeterapi.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandleErrors {
    private final Instant timestamp = Instant.now();

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handle(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("timestamp", timestamp.toString());
        errors.put("message", "something goes wrong");

        ex.printStackTrace();
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public Map<String, String> handleNotFound(EntityNotFoundException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("timestamp", timestamp.toString());
        errors.put("message", ex.getMessage());

        ex.printStackTrace();
        return errors;
    }

}
