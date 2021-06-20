package com.ppoox.api.sys.exception;

import com.ppoox.api.sys.util.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class RestControllerException {

    /**
     * 유효성 검증간에 발생하는 Exception 처리
     * @param be - BindException
     * @return Result
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Result> bindExceptionHandler(BindException be) {
        Result result = new Result();
        result.setStatusCode(HttpStatus.BAD_REQUEST);
        result.setMessage("파라미터 유효성 검증에 실패하였습니다.");
        result.setData(
          be.getAllErrors()
          .stream()
          .map(ObjectError::getDefaultMessage)
          .collect(Collectors.toList())
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
