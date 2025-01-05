package hoanghoi.datn.controller;


import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.InOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/user-parking")
public class UserParkingController {
    // checkin
    @Autowired
    private InOutService inOutService;
    @PostMapping("/checkin")
    public ApiResponse checkin(
                                @RequestParam("file")MultipartFile file,
                                @RequestParam("deviceId")UUID deviceId,
                                @RequestParam("accountId") UUID accountId,
                                @RequestParam("timestamp") long timestamp

                                ) {

        return inOutService.checkin(deviceId, accountId, timestamp, file);
    }
    @PostMapping("/checkout")
    public ApiResponse checkout(
                                @RequestParam("file")MultipartFile file,
                                @RequestParam("deviceId")UUID deviceId,
                                @RequestParam("accountId") UUID accountId,
                                @RequestParam("timestamp") long timestamp
    ) {
        return inOutService.checkout(deviceId, accountId, timestamp, file);
    }
    // checkout

}
