package com.fagnerdev.deliverysystemeveris.controllers.exceptions;

import com.fagnerdev.deliverysystemeveris.services.exceptions.ControllerNotFoundException;
import com.fagnerdev.deliverysystemeveris.services.exceptions.DataBaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

/**
 * Classe que trata quando um objeto não é encontrado na requisição
 *
 * @author Fagner Cristino
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(ControllerNotFoundException.class) //anotação para indicar que este método vai tratar qualquer exceção do tipo ControllerNotFoundException
    public ResponseEntity<StandardError> controllerNotFound(ControllerNotFoundException e, HttpServletRequest request){

        String error = "Controller not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }

    @ExceptionHandler(DataBaseException.class) //anotação para indicar que este método vai tratar qualquer exceção do tipo DataBaseException
    public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);

    }
}
