package com.example.di.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BService {
    @Autowired
    private AService aService;

}
