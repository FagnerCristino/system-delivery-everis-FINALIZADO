package com.fagnerdev.deliverysystemeveris.services.exceptions;

/**
 * Classe onde criamos a exceção quando a requisição tratada por um Controller não é feita da forma adecuada
 */

public class ControllerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ControllerNotFoundException(Object id){

        super("ID não encontrado: " + id);

    }
}
