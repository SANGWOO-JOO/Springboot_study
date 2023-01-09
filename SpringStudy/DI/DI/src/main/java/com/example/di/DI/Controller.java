package com.example.di.DI;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Controller {
//    Service service = new Service(); // @Component 주입 후 사용을 안해도 된다.

    @Autowired
    Service service;



}
