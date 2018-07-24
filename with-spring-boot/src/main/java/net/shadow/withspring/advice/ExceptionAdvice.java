package net.shadow.withspring.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> logException(Throwable e) throws Throwable {
        log.warn(e.getMessage(), e);
        throw e;
    }
}
