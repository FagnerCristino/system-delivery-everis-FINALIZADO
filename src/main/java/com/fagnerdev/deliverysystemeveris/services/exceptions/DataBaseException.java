package com.fagnerdev.deliverysystemeveris.services.exceptions;

import java.io.Serializable;

/**
 * Classe onde são tratadas as exceções que podem ocorrer pelos relacionamentos no banco de dados
 */
public class DataBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataBaseException(String msg){
        super(msg);
    }
}
