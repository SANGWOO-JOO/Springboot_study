package Rest.API.demo.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    /*
    로직
     */
    @ExceptionHandler(NullPointerException.class)
    public Object nullEx(Exception e) {
        System.out.println(e.getClass());
        return "myServiceException";
    }
}