package hoanghoi.datn.controller;


import hoanghoi.datn.dto.response.ApiResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/current-parking")
public class CurrentVehicleParkingController {

    // get all current parking by parking lot - bãi đỗ
    @GetMapping("/")
    public ApiResponse getAllByParkingLot(@PathVariable String ParkingId){
        return null;
    }
    // get detail parking by parking spot
    @GetMapping("/get-detail")
    public ApiResponse getDetailByParkingSpot(@PathVariable String SpotId){
        return null;
    }
    // disable checkout
//    @GetMapping("/")
//    public ApiResponse getAllByParkingLot(@PathVariable String ParkingId){
//        return null;
//    }
    // check in
    @PostMapping("/check-in")
    public ApiResponse checkIn(@RequestParam UUID accountId, @RequestParam("file") MultipartFile img){
        return null;
    }
    // checkout
    @PostMapping("/check-out")
    public ApiResponse checkOut(@RequestParam UUID accountId, @RequestParam("file") MultipartFile img){
        return null;
    }



}
