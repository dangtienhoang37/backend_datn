package hoanghoi.datn.controller;

import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.dto.request.Creation.loginRequest;

import hoanghoi.datn.dto.request.Update.AccountUpdatePassword;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.enumvar.Role;
import hoanghoi.datn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;



@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;


    @GetMapping("/infor")
    public ApiResponse getInformation(@RequestHeader("Authorization") String token) {
        return accountService.getDetailAccount(token);
    }

    @PostMapping("/change-password")
    public ApiResponse changePassword(@RequestHeader("Authorization") String token,@RequestBody AccountUpdatePassword request) {return accountService.changePassword(token,request);}

    @PostMapping("/forgot")
    public ApiResponse forgot(@RequestParam String email){
        return accountService.forgotPassword(email);
    }



    // vô hiệu hóa staff

    // logout
}
