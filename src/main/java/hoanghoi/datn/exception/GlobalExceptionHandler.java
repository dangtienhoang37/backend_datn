package hoanghoi.datn.exception;

import hoanghoi.datn.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse<?>> handlingRuntimeException(RuntimeException exception) {
        ApiResponse<?> res = new ApiResponse<>();
        res.setCode(1001);
        res.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(res);
    }
}
