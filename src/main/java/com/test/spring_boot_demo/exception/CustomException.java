package com.test.spring_boot_demo.exception;

import com.test.spring_boot_demo.exception.enums.ExceptionType;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    private final ExceptionType exceptionType;

  public CustomException(ExceptionType exceptionType) {
    super(exceptionType.message());
    this.exceptionType = exceptionType;
  }
}
