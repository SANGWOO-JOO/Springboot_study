package com.example.demo.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.TYPE}) // Target의 기능은 어노테이션을 붙일 수 있는 대상을 지정하는 것이다.
@Retention(RetentionPolicy.RUNTIME) // 런타임 까지 유지
@Documented
@AuthenticationPrincipal //핸들러 매개변수로 현재 인증된 Principal 을 참조할 수 있다.
// Principal 을 다이나믹 하게 꺼내기 위해 @CurrentUser 생성
public @interface CurrentUser {

}