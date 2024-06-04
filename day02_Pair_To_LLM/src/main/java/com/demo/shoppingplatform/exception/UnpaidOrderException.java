package com.demo.shoppingplatform.exception;

public class UnpaidOrderException extends RuntimeException {
  public UnpaidOrderException(String message) {
    super(message);
  }
}
