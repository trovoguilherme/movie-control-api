package br.com.ovort.exception;

import feign.FeignException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseException notFoundException(HttpServletRequest request, Exception exception) {
        return new ResponseException(request, "Recurso não encontrado", exception.getMessage());
    }

    @ExceptionHandler({FeignException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseException feignUnauthorizedException(HttpServletRequest request, FeignException exception) {
        return new ResponseException(request, "Recurso não autorizado", exception.getMessage());
    }

}
