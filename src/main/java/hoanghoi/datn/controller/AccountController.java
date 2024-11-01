package hoanghoi.datn.controller;

import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.dto.request.Creation.loginRequest;

import hoanghoi.datn.dto.request.Update.AccountUpdatePassword;
import hoanghoi.datn.dto.response.ApiResponse;
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

    @GetMapping("/infor/{id}")
    public ApiResponse getInformation(@PathVariable("id") UUID id) {
        return accountService.getDetailAccount(id);
    }

    @PostMapping("/change-password")
    public ApiResponse changePassword(@RequestHeader("Authorization") String token,@RequestBody AccountUpdatePassword request) {return accountService.changePassword(token,request);}

    // for admin
    @GetMapping("/get-all")
    public ApiResponse getAll() {return accountService.adminGetAllAccount();}

}
