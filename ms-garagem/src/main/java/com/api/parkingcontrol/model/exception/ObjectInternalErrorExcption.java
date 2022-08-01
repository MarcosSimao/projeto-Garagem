package com.api.parkingcontrol.model.exception;

import lombok.AllArgsConstructor;


public class ObjectInternalErrorExcption extends RuntimeException{
    public ObjectInternalErrorExcption(String msg){
        super(msg);
    }
}
