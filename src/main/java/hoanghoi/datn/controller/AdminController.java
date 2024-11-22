package hoanghoi.datn.controller;


import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.enumvar.Role;
import hoanghoi.datn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AccountService accountService;

    // get all user + paging
    // get all staff + paging
    // get detail user
    // get detail staff
    // disable staff
    // for admin
    @GetMapping("/get-all")
    public ApiResponse getAll(@RequestParam Role role) {return accountService.adminGetAllAccount(role);}
    // vô hiệu hóa người dùng

    @GetMapping("/disable/{id}")
    public ApiResponse disable(@PathVariable UUID id) {return accountService.adminDisableAccount();}

    @PostMapping("/create-staff-account")
    public ApiResponse createStaffAccount(@RequestBody AccountCreationRequest request) {
        return accountService.createStaffAccount(request);
    }
}
