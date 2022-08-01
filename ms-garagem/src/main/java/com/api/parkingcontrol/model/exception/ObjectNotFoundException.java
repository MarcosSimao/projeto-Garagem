package com.api.parkingcontrol.model.exception;

import lombok.AllArgsConstructor;


public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
