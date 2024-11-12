package hoanghoi.datn.controller;

import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.dto.request.Creation.loginRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/create-staff-account")
    public ApiResponse createStaffAccount(@RequestBody AccountCreationRequest request) {
        return accountService.createStaffAccount(request);
    }

}
