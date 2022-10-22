package com.example.jwt.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoogleOauth implements SocialOauth {
    @Override
    public String getOauthRedirectURL(){
        return "";
    }
}