package br.com.diegopimenta.clientapi.exceptions.common;

import br.com.diegopimenta.clientapi.dto.ErroCampo;
import br.com.diegopimenta.clientapi.dto.ResponseError;
import br.com.diegopimenta.clientapi.exceptions.DuplicateRecordException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
    public ResponseError handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<ErroCampo> errors = fieldErrors
                .stream()
                .map(fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage()))
                .toList();

        return new ResponseError(
                HttpStatus.UNPROCESSABLE_CONTENT.value(),
                "Validation error",
                errors
        );
    }

    @ExceptionHandler(DuplicateRecordException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseError handleRegistroDuplicadoException(DuplicateRecordException e) {
        return ResponseError.conflict(e.getMessage());
    }
}
