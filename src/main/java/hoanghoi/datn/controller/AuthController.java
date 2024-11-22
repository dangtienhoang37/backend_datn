package hoanghoi.datn.controller;

import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.dto.request.Creation.loginRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AccountService accountService;


    @PostMapping("/register")
    public ApiResponse createAccount(@RequestBody AccountCreationRequest request) {
        return accountService.register(request);

    }
    @PostMapping("/login")
    public ApiResponse login(@RequestBody loginRequest request) {
        return accountService.login(request);
    }

    @PostMapping("/logout")
    public ApiResponse logout(@RequestHeader("Authorization") String token) {
        return null;
    }


}
