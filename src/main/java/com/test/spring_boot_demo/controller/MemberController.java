package com.test.spring_boot_demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.test.spring_boot_demo.domain.dto.MemberDto;
import com.test.spring_boot_demo.domain.dto.RegistMemberDto;
import com.test.spring_boot_demo.domain.dto.UpdateMemberDto;
import com.test.spring_boot_demo.service.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    // 전체 유저 조회
    @GetMapping
    public ResponseEntity<List<MemberDto>> getMemberList() {
        return ResponseEntity.ok(memberService.getMemberList());
    }

    // 특정 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> getMember(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMember(id));
    }

    // 유저 추가
    @PostMapping
    public ResponseEntity<String> saveMember(@Valid @RequestBody RegistMemberDto registMemberDto, BindingResult bindingResult) {
        // 유효성 검사 오류가 발생했는지 확인
        if (bindingResult.hasErrors()) {
            // 오류 메시지를 수집
            StringBuilder errorMessage = new StringBuilder("Validation failed for fields: ");
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessage.append(error.getField())
                            .append(" (")
                            .append(error.getDefaultMessage())
                            .append("), ");
            }
            // 오류 메시지 반환
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        memberService.saveMember(registMemberDto);
        return ResponseEntity.ok("유저 추가가 성공적으로 완료되었습니다.");
    }

    // 유저 정보 수정
    @PutMapping
    public ResponseEntity<String> updateMember(@Valid @RequestBody UpdateMemberDto updateMemberDto, BindingResult bindingResult) {
        // 유효성 검사 오류가 발생했는지 확인
        if (bindingResult.hasErrors()) {
            // 오류 메시지를 수집
            StringBuilder errorMessage = new StringBuilder("Validation failed for fields: ");
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessage.append(error.getField())
                            .append(" (")
                            .append(error.getDefaultMessage())
                            .append("), ");
            }
            // 오류 메시지 반환
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        
        memberService.updateMember(updateMemberDto);
        return ResponseEntity.ok("유저 정보 수정이 성공적으로 완료되었습니다.");
    }

    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok("유저 삭제가 성공적으로 완료되었습니다.");
    }
}
