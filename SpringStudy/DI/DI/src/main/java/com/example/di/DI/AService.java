package com.example.di.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AService {
    @Autowired
    private BService bService;

    public void hello(BService serviceB) {
      //  bService.hello(); //AService 객체가 BService 메서드 호출
        this.bService =serviceB;
    }
}
