package com.api.parkingcontrol.model.exception;

public class ObjectConflictException extends RuntimeException{

    public ObjectConflictException(String msg){
        super(msg);
    }
}
