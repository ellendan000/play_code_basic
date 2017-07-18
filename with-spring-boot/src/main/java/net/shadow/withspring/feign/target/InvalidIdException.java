package net.shadow.withspring.feign.target;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This id is invalid.")
public class InvalidIdException extends RuntimeException {
    InvalidIdException() {
        super();
    }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
