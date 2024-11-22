package hoanghoi.datn.controller;


import hoanghoi.datn.dto.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {
    // đặt trước




    // get all by Parking
    @GetMapping("/{parkingId}")
    public ApiResponse getAll(@PathVariable UUID parkingId) {
        return null;
    }

    // kiểm tra đặt trước - get all by parking
    // get all by Account ID
    @GetMapping("/user/{id}")
    public ApiResponse getAllByAcc(@PathVariable UUID id) {
        return null;
    }


}
