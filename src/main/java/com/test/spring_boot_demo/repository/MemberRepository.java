package com.test.spring_boot_demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.spring_boot_demo.domain.dao.Member;
import com.test.spring_boot_demo.domain.dto.RegistMemberDto;
import com.test.spring_boot_demo.domain.dto.UpdateMemberDto;
import com.test.spring_boot_demo.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Repository
public class MemberRepository {

    private final MemberMapper memberMapper;

    // 전체 유저 조회
    public List<Member> getMemberList() {
        return memberMapper.getMemberList();
    }

    // 특정 유저 조회
    public Member getMember(Long id) {
        return memberMapper.getMember(id);
    }

    // 유저 추가
    public int saveMember(RegistMemberDto registMemberDto) {
        return memberMapper.saveMember(registMemberDto);
    }

    // 유저 정보 수정
    public int updateMember(UpdateMemberDto updateMemberDto) {
        return memberMapper.updateMember(updateMemberDto);
    }

    // 유저 정보 삭제
    public int deleteMember(Long id) {
        return memberMapper.deleteMember(id);
    }

}
