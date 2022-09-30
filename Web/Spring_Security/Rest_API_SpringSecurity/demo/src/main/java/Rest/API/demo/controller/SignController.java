package Rest.API.demo.controller;

import Rest.API.demo.config.security.JwtProvider;
import Rest.API.demo.service.response.ResponseService;
import Rest.API.demo.advice.exception.CEmailSigninFailedException;

import Rest.API.demo.entity.User;
import Rest.API.demo.model.response.CommonResult;
import Rest.API.demo.model.response.SingleResult;
import Rest.API.demo.repository.UserRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Api(tags = {"1. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserRepo userJpaRepo; // jpa 쿼리 활용
    private final JwtProvider jwtProvider; // jwt 토큰 생성
    private final ResponseService responseService; // API 요청 결과에 대한 code, message
    private final PasswordEncoder passwordEncoder; // 비밀번호 암호화

    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인을 한다.")
    @PostMapping(value = "/signin")
    public SingleResult<String> signin(@ApiParam(value = "회원ID : 이메일", required = true) @RequestParam String id,
                                       @ApiParam(value = "비밀번호", required = true) @RequestParam String password) {

        User user = userJpaRepo.findByUid(id).orElseThrow(CEmailSigninFailedException::new);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            // matches : 평문, 암호문 패스워드 비교 후 boolean 결과 return
            throw new CEmailSigninFailedException();
        }
        return responseService.getSingleResult(jwtProvider.createToken(String.valueOf(user.getUserId()), user.getRoles()));
    }

    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @PostMapping(value = "/signup")
    public CommonResult signup(@ApiParam(value = "회원ID : 이메일", required = true) @RequestParam String email,
                               @ApiParam(value = "회원 가입 닉네임", required = true) @RequestParam String uid,
                               @ApiParam(value = "비밀번호", required = true) @RequestParam String password,
                               @ApiParam(value = "이름", required = true) @RequestParam String name) {

        userJpaRepo.save(User.builder()
                .email(email)
                .uid(uid)
                .password(passwordEncoder.encode(password))
                .name(name)
                .roles(Collections.singletonList("ROLE_USER"))
                .build());

        return responseService.getSuccessResult();
    }
}