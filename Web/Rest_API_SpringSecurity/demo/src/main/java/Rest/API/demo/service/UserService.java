package Rest.API.demo.service;


import Rest.API.demo.advice.exception.CUserNotFoundException;
import Rest.API.demo.entity.User;
import Rest.API.demo.entity.dto.UserRequestDto;
import Rest.API.demo.entity.dto.UserResponseDto;
import Rest.API.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepo userJpaRepo;


    @Transactional
    public Long save(UserRequestDto userDto){

        userJpaRepo.save(userDto.toEntity());
        return userJpaRepo.save(userDto.toEntity()).getUserId();
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) {
        User user = userJpaRepo.findById(id)
                .orElseThrow(CUserNotFoundException::new);
        return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public UserResponseDto findByEmail(String email) {
        User user = userJpaRepo.findByEmail(email);
        if (user == null) throw new CUserNotFoundException();
        else return new UserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAllUser() {
        return userJpaRepo.findAll()
                .stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long update(Long id, UserRequestDto userRequestDto) {
        User modifiedUser = userJpaRepo
                .findById(id).orElseThrow(CUserNotFoundException::new);
//        modifiedUser.setNickName(userRequestDto.getNickName());
        modifiedUser.setName(userRequestDto.toEntity().getName());
        return id;
    }

    @Transactional
    public void delete(Long id) {
        userJpaRepo.deleteById(id);
    }
}
