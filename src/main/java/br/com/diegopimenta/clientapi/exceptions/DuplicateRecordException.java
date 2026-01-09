package br.com.diegopimenta.clientapi.exceptions;

public class DuplicateRecordException extends RuntimeException {
    public DuplicateRecordException(String message) {
        super(message);
    }
}
