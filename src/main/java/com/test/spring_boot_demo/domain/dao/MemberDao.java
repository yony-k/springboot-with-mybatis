package com.test.spring_boot_demo.domain.dao;

import lombok.Builder;
import com.test.spring_boot_demo.domain.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDao {
    private long id;
    private String name;
    private int age;
    private String email;
    private String phone;

    public static MemberDao toMemberDao(MemberDto memberDto) {
        return new MemberDao().builder()
        .id(memberDto.getId())
        .name(memberDto.getName())
        .age(memberDto.getAge())
        .email(memberDto.getEmail())
        .phone(memberDto.getPhone())
        .build();
    }
}