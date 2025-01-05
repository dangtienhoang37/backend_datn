package hoanghoi.datn.controller;


import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.dto.request.Creation.UserCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.enumvar.Gender;
import hoanghoi.datn.enumvar.Role;
import hoanghoi.datn.service.AccountService;
import hoanghoi.datn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;


    // get detail user
    @GetMapping("/getDetail/{id}")
    public ApiResponse getInformation(@PathVariable UUID id) {
        return accountService.getDetailAccByAdmin(id);
    }
    // get detail staff
    // disable staff
    // get all staff / user + paging
    @GetMapping("/get-all")
    public ApiResponse getAll(@RequestParam Role role) {return accountService.adminGetAllAccount(role);}
    // vô hiệu hóa người dùng

    @GetMapping("/disable/{id}")
    public ApiResponse disable(@PathVariable UUID id) {return accountService.adminDisableAccount(id);}

    @PostMapping("/create-staff-account")
    public ApiResponse createStaffAccount(@RequestBody AccountCreationRequest request) {
        return accountService.createStaffAccount(request);
    }
    @PostMapping("/create-account")
    public ApiResponse createAccount(@RequestBody AccountCreationRequest request) {
        return accountService.adminCreateAccount(request);
    }

    // sua tai day
    @PostMapping("/create-user-infor/{id}")
    public ApiResponse createUserInfor(@RequestHeader("Authorization") String token,
                                       @RequestPart("fullName") String fullName,
                                       @RequestPart("gender") String gender,
                                       @RequestPart("phoneNumber") String phoneNumber,
                                       @RequestPart("email") String email,
                                       @RequestPart("address") String address,
                                       @RequestPart("userImg") String userImg,
                                       @RequestPart("pid") String pid,
                                       @PathVariable UUID id,
                                       @RequestPart("file") MultipartFile file) {
        UserCreationRequest request = UserCreationRequest.builder()
                .fullName(fullName)
                .gender(Gender.valueOf(gender)) // Nếu Gender là enum
                .phoneNumber(phoneNumber)
                .email(email)
                .address(address)
                .PID(pid)
                .build();
        return userService.adminCreateUserInfor(token, request, id,file);
    }
}
