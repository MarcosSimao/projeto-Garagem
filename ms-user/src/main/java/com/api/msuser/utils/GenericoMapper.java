package com.api.msuser.utils;

import org.modelmapper.ModelMapper;

public class GenericoMapper {

    public static <T extends Object> T map(Object object, Class<T> t){
        return new ModelMapper().map(object,t);
    }
}
