package com.fagnerdev.deliverysystemeveris.services.exceptions;

public class ControllerNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ControllerNotFoundException(Object id){

        super("ID não encontrado: " + id);

    }
}
