package com.go2climb.app.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceValidationException extends RuntimeException {
  public ResourceValidationException(String resourceName, String message) {
    super(message);
  }
}
