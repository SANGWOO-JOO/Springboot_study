package Rest.API.demo.entity.dto;

import Rest.API.demo.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class UserLoginResponseDto {
    private final Long userId;
    private final List<String> roles;


    public UserLoginResponseDto(User user) {
        this.userId = user.getUserId();
        this.roles = user.getRoles();

    }
}