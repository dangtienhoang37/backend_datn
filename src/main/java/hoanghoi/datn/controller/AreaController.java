package hoanghoi.datn.controller;

import hoanghoi.datn.dto.request.Creation.AreaCreationRequest;
import hoanghoi.datn.dto.request.granted.AreaStaffGrantedRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Area")
public class AreaController {
    @Autowired
    private AreaService areaService;
    // get all`
    @GetMapping("/get-all")
    public ApiResponse getAll() {
        return areaService.getAllAreaService();
    }
    // get detail
    @GetMapping("/{id}")
    public ApiResponse getDetail(@PathVariable int id) {
        return areaService.getDetailAreaService(id);
    }
    // create
    @PostMapping("/create")
    public ApiResponse create(@RequestBody AreaCreationRequest request) {
        return areaService.adminAddAreaService(request);
    }
    // update
    @PostMapping("/update/{id}")
    public ApiResponse update(@PathVariable int id, @RequestBody AreaCreationRequest request) {
        return areaService.changeAreaInforService(id, request);
    }
    // gan quyen - id user
    @PostMapping("/granted/{id}")
    public ApiResponse grantedArea(@PathVariable int id, @RequestBody AreaStaffGrantedRequest request) {
        return areaService.adminGrantStaffService(id, request);
    }
    // vo hieu hoa
    @PostMapping("/disable/{id}")
    public ApiResponse disableArea(@PathVariable int id) {
        return areaService.adminRemoveAreaService(id);
    }

    // tam khoa

}
