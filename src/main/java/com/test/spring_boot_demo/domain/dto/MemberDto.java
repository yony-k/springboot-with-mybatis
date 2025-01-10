package com.test.spring_boot_demo.domain.dto;

import com.test.spring_boot_demo.domain.dao.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String name;
    private int age;
    private String email;
    private String phone;

    public static MemberDto toMemberDto(Member memberDao) {
        return new MemberDto().builder()
        .id(memberDao.getId())
        .name(memberDao.getName())
        .age(memberDao.getAge())
        .email(memberDao.getEmail())
        .phone(memberDao.getPhone())
        .build();
    }
}
