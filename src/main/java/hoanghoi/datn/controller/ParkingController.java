package hoanghoi.datn.controller;

import hoanghoi.datn.dto.request.Creation.ParkingCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    // tao moi
    @Autowired
    private ParkingService parkingService;
    @PostMapping("/create")
    public ApiResponse create(@RequestBody ParkingCreationRequest request) {
        return parkingService.adminCreateParkingService(request);
    }
    // get all
    @GetMapping("/get-all")
    public ApiResponse getAll() {
        return parkingService.getAllParking();
    }
    // get all by district
    @GetMapping("/get-all-by-district/{districtId}")
    public ApiResponse getAllbyDistrict(@PathVariable String districtId) {
        return parkingService.getAllParkingByDistrict(districtId);
    }
    @GetMapping("/get-all-by-ward/{wardId}")
    public ApiResponse getAllbyWard(@PathVariable String wardId) {
        return parkingService.getAllParkingByWard(wardId);
    }
    // get detail
    @GetMapping("/{id}")
    public ApiResponse getDetail(@PathVariable UUID id) {
        return parkingService.getDetailParking(id);
    }
    // chinh sua
    @PatchMapping("/{id}")
    public ApiResponse update(@PathVariable UUID id, @RequestBody ParkingCreationRequest request) {
        return parkingService.adminUpdateParkingService(id, request);
    }

    @GetMapping("/staff/get-all")
    public ApiResponse getAllByStaff(@RequestHeader("Authorization") String token) {
        return parkingService.getAllParkingByStaff(token);
    }



    // get all parking spot now by Area (admin- staff)
    // get detail parking spot now bằng id record gửi xe ( sử dụng redis)(admin-staff-user)
    // gan quyền
    // vô hiệu hóa



}
