package com.test.spring_boot_demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;
import com.test.spring_boot_demo.domain.dao.MemberDao;
import com.test.spring_boot_demo.domain.dto.RegistMemberDto;
import com.test.spring_boot_demo.domain.dto.UpdateMemberDto;

@Mapper
public interface MemberMapper {
    // 전체 유저 조회
    @Select("SELECT * FROM member")
    List<MemberDao> getMemberList();

    // 특정 유저 조회
    @Select("SELECT * FROM member WHERE id=#{id}")
    MemberDao getMember(@Param("id") Long id);

    // 유저 추가
    @Insert(
    "INSERT INTO member (name, age, email, phone) " +
    "VALUES(#{registMemberDto.name}, " +
    "#{registMemberDto.age}, " +
    "#{registMemberDto.email}, " +
    "#{registMemberDto.phone})")
    int saveMember(@Param("registMemberDto") RegistMemberDto registMemberDto);

    // 유저 정보 수정
    @Update(
        "UPDATE member " +
        "SET email=#{updateMemberDto.email}, " +
        "phone=#{updateMemberDto.phone} " +
        "WHERE id=#{updateMemberDto.id}")
    int updateMember(@Param("updateMemberDto") UpdateMemberDto updateMemberDto);
    
    // 유저 정보 삭제
    @Delete("DELETE FROM member WHERE id=#{id}")
    int deleteMember(@Param("id")long id);
}