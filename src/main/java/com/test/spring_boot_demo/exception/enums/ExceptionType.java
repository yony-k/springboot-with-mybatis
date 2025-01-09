package com.test.spring_boot_demo.exception.enums;

import org.springframework.http.HttpStatus;

public interface ExceptionType {
    HttpStatus status();

  String message();

  default int getHttpStatusCode() {
    return status().value();
  }
}
