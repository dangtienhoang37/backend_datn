package hoanghoi.datn.controller;

import com.fasterxml.jackson.databind.DatabindException;
import hoanghoi.datn.dto.request.Creation.AreaCreationRequest;
import hoanghoi.datn.dto.request.granted.AreaStaffGrantedRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/Area")
public class AreaController {
    @Autowired
    private AreaService areaService;




    // init location
    @GetMapping("/init-district")
    public ApiResponse initLocation() throws IOException {
        return areaService.initLocation();
    }
    // init location
    @GetMapping("/init-ward")
    public ApiResponse initWard() throws IOException {
        return areaService.initWard();
    }

    @GetMapping("/get-all-district")
    public ApiResponse getAllDistrict() throws IOException {
        return areaService.getAllDistrict();
    }
    @GetMapping("/get-detail-district/{id}")
    public ApiResponse getDistrict(@PathVariable String id) throws IOException {
        return areaService.getDistrict(id);
    }
    @GetMapping("/get-detail-ward/{id}")
    public ApiResponse getWard(@PathVariable String id) throws IOException {
        return areaService.getWard(id);
    }
    @GetMapping("/get-all-ward-district/{id}")
    public ApiResponse getAllWard(@PathVariable String id) throws IOException {
        return areaService.getAllWard(id);
    }

}
