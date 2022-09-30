package Rest.API.demo.advice;

import Rest.API.demo.advice.exception.CEmailSigninFailedException;
import Rest.API.demo.advice.exception.CUserNotFoundException;
import Rest.API.demo.model.response.CommonResult;
import Rest.API.demo.service.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestControllerAdvice
// 예외 발생 시 json 형태로 결과 반환 | 프로젝트의 모든 Controller에 로직 적용
// @RestControllerAdvice(basePackages = "Rest.API.demo") : demo 하위의 Controller 에만 로직 적용


public class ExceptionAdvice {

    private final ResponseService responseService;
    private final MessageSource messageSource;
    // 결과에 대한 정보를 도출하는 클래스 명시

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    protected CommonResult defaultException(HttpServletRequest request, Exception e) {
//        // CommonResult : 응답 결과에 대한 정보
//        return responseService.getFailResult();
//        // getFailResult : setSuccess, setCode, setMsg
//    }


    @ExceptionHandler(CUserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult userNotFoundException(HttpServletRequest request, CUserNotFoundException e) {
        // CommonResult : 응답 결과에 대한 정보
        return responseService.getFailResult(Integer.parseInt(getMessage("userNotFound.code")), getMessage("userNotFound.code"));
        // getFailResult : setSuccess, setCode, setMsg
    }

    private String getMessage(String code) {
        return getMessage(code, null);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    // 이메일 예외 처리

    @ExceptionHandler(CEmailSigninFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected CommonResult emailSigninFailed(HttpServletRequest request, CEmailSigninFailedException e) {
        return responseService.getFailResult(Integer.valueOf(getMessage("emailSigninFailed.code")), getMessage("emailSigninFailed.msg"));
    }

}
