package hoanghoi.datn.controller;


import hoanghoi.datn.dto.request.Creation.BookingCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.ReservationScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private ReservationScheduleService reservationScheduleService;
    // đặt trước
    @PostMapping()
    public ApiResponse booking(@RequestBody BookingCreationRequest request,@RequestHeader("Authorization") String token) {
        return reservationScheduleService.booking(request,token);
    }



    // get all by Parking
    @GetMapping("/{parkingId}")
    public ApiResponse getAll(@PathVariable UUID parkingId,@RequestHeader("Authorization") String token) {
        return reservationScheduleService.getAllByParking(parkingId,token);
    }

    // kiểm tra đặt trước - get all by parking
    // get all by Account ID
    @GetMapping({"/user/{id}", "/user"})
    public ApiResponse getAllByAcc(@PathVariable(required = false) UUID id,@RequestHeader("Authorization") String token) {
        return reservationScheduleService.getByUser(id,token);
    }


}
