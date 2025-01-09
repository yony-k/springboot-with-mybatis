package com.test.spring_boot_demo.domain.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMemberDto {
    @NotNull(message = "아이디를 입력해주세요.")
    private Long id;

    @NotBlank(message = "이메일 주소를 입력해주세요")
    @Email(message = "이메일 형식에 맞춰 입력해주세요")
    private String email;

    @NotBlank(message = "휴대폰 번호를 입력해주세요")
    @Pattern(regexp = "^01[0-9]-\\d{3,4}-\\d{4}$", message = "올바른 휴대폰번호를 입력해주세요")
    private String phone;
}
