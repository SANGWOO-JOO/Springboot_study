package Rest.API.demo.controller;

import Rest.API.demo.advice.exception.CUserNotFoundException;
import Rest.API.demo.entity.User;
import Rest.API.demo.entity.dto.UserRequestDto;
import Rest.API.demo.entity.dto.UserResponseDto;
import Rest.API.demo.model.response.CommonResult;
import Rest.API.demo.model.response.ListResult;
import Rest.API.demo.model.response.SingleResult;
import Rest.API.demo.repository.UserRepo;
import Rest.API.demo.service.UserService;
import Rest.API.demo.service.response.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"1. User"})
@Controller
@RequiredArgsConstructor
@RequestMapping("/v1")

public class UserController {

    private final UserRepo userRepo;

    private final ResponseService responseService;
    private final UserService userService;


    @ApiOperation(value = "회원 단건 검색", notes = "id로 회원을 조회합니다.")
    @GetMapping(value = "/user/{id}")
    public SingleResult<UserResponseDto> findUserById(@ApiParam(value = "회원ID", required = true) @PathVariable long id)   {
        return responseService.getSingleResult(userService.findById(id));
        // 결과 데이터가 단일건인 경우 getSingleResult를 이용하여 결과를 출력
    }

    @ApiOperation(value = "회원 목록 조회", notes = "모든 회원을 조회합니다.")
    @GetMapping("/users")
    public ListResult<UserResponseDto> findAllUser(){
        return responseService.getListResult(userService.findAllUser());
    }


    @ApiOperation(value = "회원 등록", notes = "회원을 등록합니다.")
    @PostMapping(value = "/user") // user 테이블에 데이터를 입력하는 부분 insert into user (msrl, name, uid) values (null, ?, ?) 와 같음
    public SingleResult<Long> save(@ApiParam(value = "회원아이디", required = true) @RequestParam String uid, // 파라미터의 설명을 보여주기 위해 세팅
                                   @ApiParam(value = "회원이름", required = true) @RequestParam String name,
                                   @ApiParam(value = "회원 이메일", required = true) @RequestParam String email) {

        UserRequestDto user = UserRequestDto.builder()
                .uid(uid)
                .name(name)
                .email(email)
                .build();

        return responseService.getSingleResult(userService.save(user));
    }

    @ApiOperation(value = "회원 수정", notes = "회원정보를 수정한다.")
    @PutMapping(value = "/user")
    public SingleResult<Long> modify(
            @ApiParam(value = "회원번호", required = true) @RequestParam long id,
            @ApiParam(value = "회원아이디", required = true) @RequestParam String uid,
            @ApiParam(value = "회원이름", required = true) @RequestParam String name) {
        UserRequestDto userRequestDto = UserRequestDto.builder()

                .uid(uid)
                .name(name)
                .build();

        return responseService.getSingleResult(userService.update(id,userRequestDto));
    }

    @ApiOperation(value = "회원 삭제", notes = "msrl로 회원정보를 삭제한다.")
    @DeleteMapping(value = "/user/{msrl}")
    public CommonResult delete (
            @ApiParam(value = "회원정보", required = true) @PathVariable long id ) {
        userRepo.deleteById(id); // deleteById id를 받아 delete query 실행
        return responseService.getSuccessResult();
        // 성공 결과 정보만 필요한 경우 getSuccessResult()를 이용하여 결과를 출력
    }
}


