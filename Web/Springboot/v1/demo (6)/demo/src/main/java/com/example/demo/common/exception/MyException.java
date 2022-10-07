package com.example.demo.common.exception;


import com.example.demo.common.Constants;
import org.springframework.http.HttpStatus;


public class MyException extends Exception {

    private static final long serialVersionUID = 4663380430591151694L;

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public MyException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus,
                              String message) {
        super(exceptionClass.toString() + message); // 상수값 + 디테일한 메시지
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass() {
        return exceptionClass;
    }

    public int getHttpStatusCode() { // 번호 리턴
        return httpStatus.value();
    }

    public String getHttpStatusType() { // 원인
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
        // 객체 자체 리턴턴
    }

}