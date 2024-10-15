package hoanghoi.datn.controller;

import hoanghoi.datn.dto.AccountCreationRequest;
import hoanghoi.datn.dto.ApiResponse;
import hoanghoi.datn.dto.loginRequest;
import hoanghoi.datn.entity.Account;
import hoanghoi.datn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;


    @PostMapping("/register")
    ApiResponse createAccount(@RequestBody AccountCreationRequest request) {
        return accountService.createUserAccount(request);
    }

//    @PostMapping("/login")
//    Account login(@RequestBody LoginRequest request) {
//        return accountService.login(request);
//    }

}
