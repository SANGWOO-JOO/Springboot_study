package com.example.demo.common;

public class Constants {

    public enum ExceptionClass {

        PRODUCT("Product"), ORDER("order"),PROVIDER("provider");

        private String exceptionClass;

        ExceptionClass(String exceptionClass) {
            this.exceptionClass = exceptionClass;
        }

        public String getExceptionClass() {
            return exceptionClass;
        }

        @Override
        public String toString() {
            return getExceptionClass() + " Exception. ";
        }
        // String 값 리턴 받고
        // 지금은 Product만 쓰고 있기에 Product Exception 이라는 toString 값만 출력이 되낟.
    }

}