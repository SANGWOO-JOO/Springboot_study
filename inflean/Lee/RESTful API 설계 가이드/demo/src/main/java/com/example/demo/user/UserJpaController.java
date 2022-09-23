package com.example.demo.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkRelationProvider;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.server.reactive.WebFluxLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa")
public class UserJpaController {

    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        /*
          userRepository에 사용할 수 있는 메소드 목록이 나옴
         */
       return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new UserNotFoundException(String.format("ID[%S] not found", id));
        }

        EntityModel userModel = EntityModel.of(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        userModel.add(linkTo.withRel("all-users"));

        return userModel;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id); // 기본키로 id 삭제
    }

    @PostMapping("/users")
    //ResponseEntity<>: 사용자에게 상태코드 반영해서 적용
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
       User savedUser = userRepository.save(user); // 도메인 객체를 전달

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}") // 현재 생성되어 있는 id 값에
                .buildAndExpand(savedUser.getId()) //savedUser.getId() : {id} 가변변수에 새롭게 만들어진 id값 저장
                .toUri();
        return ResponseEntity.created(location).build();//.build() 메소드 붙히기
    }

}
