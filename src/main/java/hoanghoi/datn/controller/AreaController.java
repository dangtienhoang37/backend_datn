package hoanghoi.datn.controller;

import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ApiResponse getDetail() {
        return null;
    }
    // create
    @PostMapping("/create")
    public ApiResponse create() {
        return null;
    }
    // update
    @PostMapping("/update")
    public ApiResponse update() {
        return null;
    }
    // gan quyen - id user
    @PostMapping("/granted")
    public ApiResponse grantedArea() {
        return null;
    }
    // vo hieu hoa

    // tam khoa

}
