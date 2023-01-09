package com.example.bean.Bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {

        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository()); //memberService()에서 리턴되는 객체(MemberService)가 IoC Container 안에 Bean으로 등록된다.
        }

        @Bean
        public MemberRepository memberRepository() {
            return new MemberRepository();
        }

}
