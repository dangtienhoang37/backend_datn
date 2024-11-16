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
    // get all by Area
    @GetMapping("/get-all/{areaId}")
    public ApiResponse getAllbyArea(@PathVariable int areaId) {
        return parkingService.getAllParkingByArea(areaId);
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


    // gan quyền
    // vô hiệu hóa



}
