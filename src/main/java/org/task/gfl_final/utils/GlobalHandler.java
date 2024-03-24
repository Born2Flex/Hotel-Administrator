package org.task.gfl_final.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        log.info("Validation on controller failed: {}", errors);
        ApiError response = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, "Validation failed", 1, errors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<ApiError> handleNoSuchEntityException(UserNotFoundException e) {
//        log.info("User not found: {}", e.getMessage());
//        ApiError response = new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND, e.getMessage(), 2, List.of(e.getMessage()));
//        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler({EmailDuplicateException.class, IpnDuplicateException.class})
//    public ResponseEntity<ApiError> handleEmailDuplicateException(Exception e) {
//        ApiError response = new ApiError(LocalDateTime.now(), HttpStatus.BAD_REQUEST, e.getMessage(), 3, List.of(e.getMessage()));
//        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//    }
}