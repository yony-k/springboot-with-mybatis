package com.test.spring_boot_demo.exception.enums;

import org.springframework.http.HttpStatus;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum MemberExceptionType implements ExceptionType {
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "아이디에 해당하는 유저가 존재하지 않습니다."),
    MEMBER_SAVE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "유저 추가에 실패하였습니다. 잠시 후 다시 시도해주세요."),
    MEMBER_UPDATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "유저 정보 수정에 실패하였습니다. 잠시 후 다시 시도해주세요."),
    MEMBER_DELETE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "유저 삭제에 실패하였습니다. 잠시 후 다시 시도해주세요.")
    ;
  private final HttpStatus status;
  private final String message;

  @Override
  public HttpStatus status() {
    return this.status;
  }

  @Override
  public String message() {
    return this.message;
  }
}