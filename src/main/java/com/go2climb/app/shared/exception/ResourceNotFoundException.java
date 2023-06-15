package com.go2climb.app.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String resourceName, Integer resourceId) {
    super(String.format("%s with id %d: NOT FOUND", resourceName, resourceId));
    StackTraceElement[] mio = {};
    this.setStackTrace(mio);
  }
}
