package br.com.wzzy.gerenciamentopessoas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PessoaCadastradoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleLivroCadastradoException(PessoaCadastradoException ex) {
        return ex.getMessage();
    }
}
