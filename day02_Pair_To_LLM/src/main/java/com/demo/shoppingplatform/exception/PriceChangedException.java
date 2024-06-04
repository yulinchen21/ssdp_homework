package com.demo.shoppingplatform.exception;

public class PriceChangedException extends RuntimeException {
  public PriceChangedException(String message) {
    super(message);
  }
}
