package hoanghoi.datn.controller;

import hoanghoi.datn.dto.request.Creation.UserCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    // sửa thông tin
    @Autowired
    private UserService userService;

    @GetMapping
    public ApiResponse getUserInfor(@RequestHeader("Authorization") String token){
        return userService.getDetailUser(token);
    }

    @PostMapping
    public ApiResponse createUserInfor(@RequestHeader("Authorization") String token, @RequestBody UserCreationRequest request) {
        return userService.addInfor(token, request);
    }

    @PatchMapping
    public ApiResponse changeInfor(@RequestHeader("Authorization") String token, @RequestBody UserCreationRequest request) {
        return userService.updatePersonalInformation();
    }



}
