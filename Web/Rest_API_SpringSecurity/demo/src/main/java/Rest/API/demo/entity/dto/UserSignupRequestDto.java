package Rest.API.demo.entity.dto;

import Rest.API.demo.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;

@Getter
public class UserSignupRequestDto {
    private String email;
    private String password;
    private String name;
    private String uid;

    @Builder
    public UserSignupRequestDto(String email, String password, String name, String uid) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.uid = uid;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .uid(uid)
                .name(name)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
    }
}