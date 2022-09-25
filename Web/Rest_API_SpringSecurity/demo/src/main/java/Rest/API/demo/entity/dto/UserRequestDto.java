package Rest.API.demo.entity.dto;

import Rest.API.demo.entity.User;
import lombok.Builder;

public class UserRequestDto {

    private String uid;
    private String email;
    private String name;


    @Builder
    public UserRequestDto(String uid, String email, String name) {
        this.uid =uid;
        this.email = email;
        this.name = name;
    }


    public User toEntity() {
        return User.builder()
                .email(email)
                .name(name)
                .build();
    }
}
