package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {


    // http://localhost:8080/api/v1/put-api/member2
    @PutMapping(value = "/member2")
    public MemberDto putMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    // http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> putMemberDto3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);

    }
}