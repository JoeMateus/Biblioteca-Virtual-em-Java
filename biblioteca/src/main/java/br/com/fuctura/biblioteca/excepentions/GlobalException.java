package br.com.fuctura.biblioteca.excepentions;

import org.hibernate.ObjectDeletedException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

//vamos tratar o metodo
// o que importa mais é a excessao dentro do paranteses
@RestControllerAdvice
public class GlobalException {

    //Tratar atributo quando for lançar
    @ExceptionHandler(ObjectDeletedException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(se);

    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        StandardError se = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
    }
   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError>methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
       ValidationError errors = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
               "Erro na validacao dps campos", request.getRequestURI());

       // pega os atributos do POstMan
       for (FieldError obj : e.getBindingResult().getFieldErrors()) {
           errors.addErro(obj.getField(),obj.getDefaultMessage());
   }
//add e get é um metodo do validecions - para cada obj fielderro, se refere aos erros do PostMan
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
}}
// validar a API - AQUI EM VALIDECIONS


