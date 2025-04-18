package ir.digixo.controller;

import ir.digixo.exception.MyErrorResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@RequestMapping("/")
public class C02ExceptionHandler {

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<MyErrorResponse> handleNotFoundException(NoHandlerFoundException ex) {
        MyErrorResponse myErrorResponse = new MyErrorResponse(404, "resource not found");
        return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body(myErrorResponse);
    }
}
