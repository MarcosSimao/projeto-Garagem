package com.api.parkingcontrol.controller.excepcionController;

import com.api.parkingcontrol.model.exception.ObjectConflictException;
import com.api.parkingcontrol.model.exception.ObjectInternalErrorExcption;
import com.api.parkingcontrol.model.exception.ObjectNotFoundException;
import com.api.parkingcontrol.model.exception.StandarErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@ControllerAdvice
public class PatterbControllerExceptions {
    @ExceptionHandler(ObjectConflictException.class)
    public ResponseEntity<StandarErrorResponse> conflict(ObjectConflictException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        return ResponseEntity
                .status(status)
                .body(new StandarErrorResponse(LocalDateTime.now(),status.value() ,e.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(ObjectInternalErrorExcption.class)
    public ResponseEntity<StandarErrorResponse> internalError(ObjectInternalErrorExcption e,HttpServletRequest request){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(status)
                .body(new StandarErrorResponse(LocalDateTime.now(),status.value(), e.getMessage(), request.getRequestURI()));
    }
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandarErrorResponse> notFound(ObjectNotFoundException e,HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity
                .status(status)
                .body(new StandarErrorResponse(LocalDateTime.now(),status.value(), e.getMessage(), request.getRequestURI()));
    }
}
