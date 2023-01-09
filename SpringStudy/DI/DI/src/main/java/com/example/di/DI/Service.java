package com.example.di.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {


    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }

}
