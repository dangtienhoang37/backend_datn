package hoanghoi.datn.service;

import hoanghoi.datn.dto.response.ApiResponse;

public interface PriceService {
    ApiResponse adminCreateNewPricing();
    ApiResponse adminUpdatePricing();
    ApiResponse adminRemovePricing();

}
