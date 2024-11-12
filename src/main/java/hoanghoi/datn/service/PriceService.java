package hoanghoi.datn.service;

import hoanghoi.datn.dto.request.Creation.PriceCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;

import java.util.UUID;

public interface PriceService {
    ApiResponse adminCreateNewPricing(PriceCreationRequest request);
    ApiResponse adminUpdatePricing(UUID id, PriceCreationRequest request);

//    ApiResponse adminUpdatePricing();

//    ApiResponse adminRemovePricing();

    ApiResponse adminRemovePricing(UUID id);

    ApiResponse getAllPricing();
//    ApiResponse getDetailPricing();

    ApiResponse getDetailPricing(UUID id);

    ApiResponse grantedPriority();

}
  