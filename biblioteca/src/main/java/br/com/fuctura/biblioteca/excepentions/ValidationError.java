package br.com.fuctura.biblioteca.excepentions;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

// puxando os atributos de StandardError
public class ValidationError extends StandardError {

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(LocalDateTime timestamp, Integer status, String message, String path) {
        super(timestamp, status, message, path);
    }

    public List<FieldMessage> getErro() {
        return erros;
    }

    public void addErro(String fieldName, String message) {
        this.erros.add(new FieldMessage(fieldName, message));
    }

}
