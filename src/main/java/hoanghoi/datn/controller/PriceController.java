package hoanghoi.datn.controller;

import hoanghoi.datn.dto.request.Creation.PriceCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/Price")
public class PriceController {
    @Autowired
    private PriceService priceService;

    // tạo mới
    @PostMapping("/create")
    public ApiResponse create(@RequestBody PriceCreationRequest request) {
        return priceService.adminCreateNewPricing(request);

    }
    // get all
    @GetMapping("/get-all")
    public ApiResponse getAll(){
        return priceService.getAllPricing();
    }
    // get detail
    @GetMapping("/{id}")
    public ApiResponse getDetail(@PathVariable UUID id){
        return priceService.getDetailPricing(id);
    }
    //vô hiệu hóa
    @PatchMapping("/disable/{id}")
    public ApiResponse disable(@PathVariable UUID id){
        return priceService.adminRemovePricing(id);
    }
    // chỉnh sửa
    @PatchMapping("/{id}")
    public ApiResponse update(@PathVariable("id") UUID id, @RequestBody PriceCreationRequest request){
        return priceService.adminUpdatePricing(id, request);
    }
    // gán cho bãi
    @PatchMapping("/grant/{id}")
    public ApiResponse grant(){
        return null;
    }

}
