package com.learning.exception;

public class EmailAlreadyExistsException extends BusinessException {

  public EmailAlreadyExistsException(String message) {
    super(message);
  }
}
