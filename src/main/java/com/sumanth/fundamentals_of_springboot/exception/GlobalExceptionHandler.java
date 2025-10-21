package com.sumanth.fundamentals_of_springboot.exception;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.exception.JDBCConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLTransientConnectionException;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Hidden
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private ProblemDetail problemDetail(HttpStatus status, String title, String detail, HttpServletRequest request){
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(status,detail);
        pd.setTitle(title);
        pd.setProperty("Path", request.getRequestURI());
        pd.setProperty("timestamp", OffsetDateTime.now().toString());
        return  pd;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public  ProblemDetail handleUserNotFound( UserNotFoundException ex, HttpServletRequest request){

        return problemDetail(HttpStatus.NOT_FOUND,"User Not Found",ex.getMessage(),request);

    }

    // e.g., email unique constraint or bad FK
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDataIntegrity(DataIntegrityViolationException ex, HttpServletRequest req){
        return problemDetail(HttpStatus.CONFLICT, "Data Integrity Violation", "Duplicate or invalid data.", req);
    }

    // e.g., /users/abc where {id} is Long, or bad query param types
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public  ProblemDetail handleTypeMismatch(MethodArgumentTypeMismatchException ex, HttpServletRequest req){
        String detail = "Invalid value for parameter '" + ex.getName() + "'.";
        return problemDetail(HttpStatus.BAD_REQUEST, "Type Mismatch", detail, req);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ProblemDetail handleMissingParam(MissingServletRequestParameterException ex, HttpServletRequest req) {
        String detail = "Missing required parameter '" + ex.getParameterName() + "'.";
        return problemDetail(HttpStatus.BAD_REQUEST, "Missing Parameter", detail, req);
    }


    @ExceptionHandler({
            org.springframework.transaction.CannotCreateTransactionException.class,
            JDBCConnectionException.class,
            SQLTransientConnectionException.class

    })
    public ProblemDetail handleDatabaseConnectionError(Exception ex, HttpServletRequest req) {
        return problemDetail(HttpStatus.SERVICE_UNAVAILABLE,
                "Database Connection Error",
                "Unable to connect to database. Please try again later.",
                req);
    }


    // To catch all  generic exception
    @ExceptionHandler(Exception.class)
    public ProblemDetail handleGeneric(Exception ex, HttpServletRequest req) {
        log.error("Unexpected error", ex); // Log stacktrace server-side
        return problemDetail(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", "Something went wrong.", req);
    }

    //validation for the user Dto
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Void> handleNoResource(NoResourceFoundException ex) {
        return ResponseEntity.notFound().build();
    }

}
