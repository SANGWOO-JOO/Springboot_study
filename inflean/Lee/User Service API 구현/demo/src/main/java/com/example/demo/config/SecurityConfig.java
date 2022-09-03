package com.example.demo.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

//@Configuration 메모리에 설정정보
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @SneakyThrows
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("Kenneth")
                    .password("{noop}test1234")
                    .roles("USER");
    }
}