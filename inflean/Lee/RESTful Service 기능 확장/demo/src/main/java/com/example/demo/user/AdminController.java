package com.example.demo.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private UserDaoService service;

    public AdminController(UserDaoService service){
        this.service =service;
    }

    //전체 검색
    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers(){
        List<User> users = service.findAll();
        SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","joinDate","password");


        FilterProvider filters =new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping =new MappingJacksonValue(users);
        mapping.setFilters(filters);

        return mapping;
    }

    // 사용자 검색
//    @GetMapping("/v1/users/{id}")
//    public MappingJacksonValue retrieveUserV1(@PathVariable int id){
//        User user = service.findOne(id);
//        if(user == null){
//            throw new UserNotFoundException(String.format("ID[%s] not found",id));
//        }
//
//        SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter
//                .filterOutAllExcept("id","name","password","ssn");
//
//        FilterProvider filters =new SimpleFilterProvider().addFilter("UserInfo", filter);
//
//        MappingJacksonValue mapping =new MappingJacksonValue(user);
//        mapping.setFilters(filters);
//
//        return mapping;
//    }
//
//    @GetMapping("/v2/users/{id}")
//    public MappingJacksonValue retrieveUserV2(@PathVariable int id){
//        User user = service.findOne(id);
//        if(user == null){
//            throw new UserNotFoundException(String.format("ID[%s] not found",id));
//        }
//
//        UserV2 userV2 =new UserV2();
//        //두 인스턴스간의 공통 필드 copy
//        BeanUtils.copyProperties(user, userV2);
//        userV2.setGrade("VIP");
//
//        SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter
//                .filterOutAllExcept("id","name","password","ssn");
//
//        FilterProvider filters =new SimpleFilterProvider().addFilter("UserInfoV2", filter);
//
//        MappingJacksonValue mapping =new MappingJacksonValue(userV2);
//        mapping.setFilters(filters);
//
//        return mapping;
//    }


//    @GetMapping(value = "/users/{id}/",params = "version=1")
//    @GetMapping(value = "/users/{id}/",headers = "X-API-VERSION=1")
    @GetMapping(value = "/users/{id}/",produces = "application/vnd.company.appv1+json")
    public MappingJacksonValue retrieveUserV1(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found",id));
        }

        SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","password","ssn");

        FilterProvider filters =new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping =new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }



//    @GetMapping(value = "/users/{id}/",params = "X-API-VERSION=2")
    @GetMapping(value = "/users/{id}/",produces = "application/vnd.company.appv2+json")
    public MappingJacksonValue retrieveUserV2(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found",id));
        }

        UserV2 userV2 =new UserV2();
        //두 인스턴스간의 공통 필드 copy
        BeanUtils.copyProperties(user, userV2);
        userV2.setGrade("VIP");

        SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","password","ssn");

        FilterProvider filters =new SimpleFilterProvider().addFilter("UserInfoV2", filter);

        MappingJacksonValue mapping =new MappingJacksonValue(userV2);
        mapping.setFilters(filters);

        return mapping;
    }
}
