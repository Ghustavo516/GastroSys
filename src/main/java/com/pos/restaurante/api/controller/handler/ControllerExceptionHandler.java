package com.pos.restaurante.api.controller.handler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pos.restaurante.api.controller.handler.exception.BusinessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.pos.restaurante.api.controller.handler.dto.ErrorDTO;
import com.pos.restaurante.api.controller.handler.exception.ConflictException;
import com.pos.restaurante.api.controller.handler.exception.ResourceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerResourceNotFoundException(ResourceNotFoundException e) {
        var status = HttpStatus.NOT_FOUND;
        var errors = e.getMessage();

        return ResponseEntity.status(status.value()).body(new ErrorDTO(List.of(errors), status.value()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handlerIllegalArgumentException(IllegalArgumentException e) {
        var status = HttpStatus.CONFLICT;
        var errors = e.getMessage();

        return ResponseEntity.status(status.value()).body(new ErrorDTO(List.of(errors), status.value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        var status = HttpStatus.BAD_REQUEST;
        var errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.status(status.value()).body(new ErrorDTO(errors, status.value()));
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ErrorDTO> handlerMissingPathVariableException(MissingPathVariableException e) {
        var status = HttpStatus.BAD_REQUEST;
        var errors = e.getMessage();

        return ResponseEntity.status(status.value()).body(new ErrorDTO(List.of(errors), status.value()));
    }

    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorDTO> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        var status = HttpStatus.BAD_REQUEST;
        var errors = e.getMessage();

        return ResponseEntity.status(status.value()).body(new ErrorDTO(List.of(errors), status.value()));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorDTO> handlerNoResourceFoundException(NoResourceFoundException e) {
        var status = HttpStatus.NOT_FOUND;

        return ResponseEntity.status(status.value()).body(new ErrorDTO(List.of("api nao encontrada"), status.value()));
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<Map<String, Object>> handleConflict(ConflictException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", ex.getMessage());
        body.put("status", HttpStatus.CONFLICT.value());

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDTO> handlerBusinessException(BusinessException e) {
        var status = HttpStatus.BAD_REQUEST;
        var errors = e.getMessage();

        return ResponseEntity.status(status.value()).body(new ErrorDTO(List.of(errors), status.value()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDTO> handlerDataIntegrityViolationException(DataIntegrityViolationException e) {
        var status = HttpStatus.CONFLICT;
        var error = "Este registro está vinculado a outros dados e não pode ser excluído.";
        return ResponseEntity.status(status.value()).body(new ErrorDTO(List.of(error), status.value()));
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ErrorDTO> handlerDuplicateKeyException(DuplicateKeyException e) {
        var status = HttpStatus.CONFLICT;
        var error = "Já existe um registro utilizando essa mesma chave";
        return ResponseEntity.status(status.value()).body(new ErrorDTO(List.of(error), status.value()));
    }
}