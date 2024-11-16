package hoanghoi.datn.controller;

import hoanghoi.datn.dto.request.Creation.UserCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PatchMapping("/img")
    public ApiResponse uploadAvatar(@RequestHeader("Authorization") String token, @RequestParam("file")MultipartFile file) {
        return userService.updateAvatar(token,file);
    }
    // api lấy ảnh avt

    @PatchMapping
    public ApiResponse changeInfor(@RequestHeader("Authorization") String token, @RequestBody UserCreationRequest request) {
        return userService.updatePersonalInformation();
    }



}
