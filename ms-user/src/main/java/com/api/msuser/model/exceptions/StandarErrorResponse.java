package com.api.msuser.model.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandarErrorResponse implements Serializable {
    private LocalDateTime timeStamp;
    private Integer status;
    private String message;
    private String path;


}
