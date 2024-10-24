package hoanghoi.datn.controller;

import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.dto.request.Creation.loginRequest;

import hoanghoi.datn.dto.request.Update.AccountUpdatePassword;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@RequestMapping("/api/v1")
public class AccountController {
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

    @GetMapping("/infor/{id}")
    public ApiResponse getInformation(@PathVariable("id") UUID id) {
        return accountService.getDetailAccount(id);
    }

    @PostMapping("/change-password")
    public ApiResponse changePassword(@RequestBody AccountUpdatePassword request) {return accountService.changePassword(request);}

    // for admin
    @GetMapping("/get-all")
    public ApiResponse getAll() {return accountService.adminGetAllAccount();}

}
