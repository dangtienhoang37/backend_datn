package hoanghoi.datn.controller;

import hoanghoi.datn.dto.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    // tao moi
    @PostMapping("/create")
    public ApiResponse create() {
        return null;
    }
    // get all
    @GetMapping("/get-all")
    public ApiResponse getAll() {
        return null;
    }
    // get all by Area
    @GetMapping("/get-all-by-area")
    public ApiResponse getAllbyArea() {
        return null;
    }
    // get detail
    @GetMapping("/{id}")
    public ApiResponse getDetail(@PathVariable UUID id) {
        return null;
    }
    // chinh sua
    @PostMapping("/update")
    public ApiResponse update() {
        return null;
    }


    // gan quyền
    // vô hiệu hóa

}
