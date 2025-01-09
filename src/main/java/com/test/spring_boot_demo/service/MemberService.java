package com.test.spring_boot_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.spring_boot_demo.domain.dao.MemberDao;
import com.test.spring_boot_demo.domain.dto.MemberDto;
import com.test.spring_boot_demo.domain.dto.RegistMemberDto;
import com.test.spring_boot_demo.domain.dto.UpdateMemberDto;
import com.test.spring_boot_demo.exception.CustomException;
import com.test.spring_boot_demo.exception.enums.MemberExceptionType;
import com.test.spring_boot_demo.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
    
    private final MemberRepository memberRepository;

    // 전체 유저 조회
    public List<MemberDto> getMemberList() {
        return memberRepository.getMemberList().stream()
        .map(memberDao -> MemberDto.toMemberDto(memberDao))
        .toList();
    }

    // 특정 유저 조회
    public MemberDto getMember(Long id) {
        MemberDao memberDao = memberRepository.getMember(id);
        if(memberDao == null) {
            log.error("getMember 조회 결과: null");
            throw new CustomException(MemberExceptionType.MEMBER_NOT_FOUND);
        }
        return MemberDto.toMemberDto(memberDao);
    }

    // 유저 추가
    public int saveMember(RegistMemberDto registMemberDto) {
        int saveResult = memberRepository.saveMember(registMemberDto);
        if(saveResult == 0) {
            log.error("saveMember 실패");
            throw new CustomException(MemberExceptionType.MEMBER_SAVE_FAIL);
        }
        return saveResult;
    }

    // 유저 정보 수정
    public int updateMember(UpdateMemberDto updateMemberDto) {
        int updateResult = memberRepository.updateMember(updateMemberDto);
        if(updateResult == 0) {
            log.error("updateMember 실패");
            throw new CustomException(MemberExceptionType.MEMBER_UPDATE_FAIL);
        }
        return updateResult;
    }

    // 유저 정보 삭제
    public int deleteMember(Long id) {
        int deleteResult = memberRepository.deleteMember(id);
        if(deleteResult == 0) {
            log.error("deleteMember 실패");
            throw new CustomException(MemberExceptionType.MEMBER_DELETE_FAIL);
        }
        return deleteResult;
    }
}
