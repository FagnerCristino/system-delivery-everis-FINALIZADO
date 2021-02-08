package com.fagnerdev.deliverysystemeveris.services.exceptions;

import java.io.Serializable;

public class DataBaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataBaseException(String msg){
        super(msg);
    }
}
