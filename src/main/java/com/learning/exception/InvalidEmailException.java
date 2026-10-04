package com.learning.exception;

public class InvalidEmailException extends BusinessException {

  public InvalidEmailException(String message) {
    super(message);
  }
}
