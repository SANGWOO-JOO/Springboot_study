package com.example.demo;

import com.example.demo.user.UserDaoService;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class InternationalController {
    private MessageSource messageSource;

    public InternationalController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String Internationalized(@RequestHeader(name="Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("greeting_message", null, locale);
    }

}
