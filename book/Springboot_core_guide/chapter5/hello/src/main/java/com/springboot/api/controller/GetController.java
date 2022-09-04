package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDTO) {
        return memberDTO.toString();
    }

}
