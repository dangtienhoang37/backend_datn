package hoanghoi.datn.service.impl;

import hoanghoi.datn.dto.request.Creation.PriceCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.entity.Price;
import hoanghoi.datn.exception.CustomException;
import hoanghoi.datn.exception.ErrorCode;
import hoanghoi.datn.repository.PriceRepository;
import hoanghoi.datn.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;
    @Override
    public ApiResponse adminCreateNewPricing(PriceCreationRequest priceCreationRequest) {
        Price newPriceRecord = new Price();
        newPriceRecord.setName(priceCreationRequest.getName());
        newPriceRecord.setDayTimeRate(priceCreationRequest.getDayTimeRate());
        newPriceRecord.setNightTimeRate(priceCreationRequest.getNightTimeRate());

        ApiResponse response = new ApiResponse<>().builder()
                .code(1000)
                .isSucess(true)
                .message("Sucessfully")
                .data(priceRepository.save(newPriceRecord))
                .build();
//        response.setCode(1000);
//        res.
//        response.setMessage("Sucessfully");
//        response.setResult(priceRepository.save(newPriceRecord));
        return response;
    }

    @Override
    public ApiResponse adminUpdatePricing(UUID id, PriceCreationRequest request) {
//        Optional<Price> targetPrice = priceRepository.findById(id);
        var targetPrice = priceRepository.findById(id).orElse(null);
        if (Objects.isNull(targetPrice)) {
            throw new RuntimeException("cant find price record");
        }
        targetPrice.setName(request.getName());
        targetPrice.setDayTimeRate(request.getDayTimeRate());
        targetPrice.setNightTimeRate(request.getNightTimeRate());

        ApiResponse response = new ApiResponse<>();
        response.setCode(1000);
        response.setSucess(true);
        response.setMessage("Sucessfully");
        response.setData(priceRepository.save(targetPrice));
        return response ;



    }

//    @Override
//    public ApiResponse adminUpdatePricing(UUID id,PriceCreationRequest request) {
//
//        try{
//            var detailPricingRecord = priceRepository.findById(id).orElse(null);
//            if(Objects.isNull(detailPricingRecord)) {
//                throw new CustomException(ErrorCode.NOT_EXISTED);
//            }
//            detailPricingRecord.setNightTimeRate(request.getNightTimeRate());
//            detailPricingRecord.setDayTimeRate(request.getDayTimeRate());
//
//            ApiResponse response = new ApiResponse();
//            response.setCode(1000);
//            response.setMessage("sucessfully");
//            response.setResult(detailPricingRecord);
//            return response;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }


    @Override
    public ApiResponse adminRemovePricing(UUID id) {
        try{
            var priceRecord = priceRepository.findById(id).orElse(null);
            if(!Objects.nonNull(priceRecord)) {
                throw new CustomException(ErrorCode.UNCATEGORIZED_EXCEPTION);
            }
            priceRecord.setIsActive(false);
            ApiResponse response = new ApiResponse();
            response.setCode(1000);
            response.setSucess(true);

            response.setMessage("remove sucessfully");
            response.setData(priceRepository.save(priceRecord));
            return response;
        } catch (Exception e) {
            throw new CustomException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
    }

    @Override
    public ApiResponse getAllPricing() {
        try{
            ApiResponse response = new ApiResponse();
            response.setSucess(true);
            response.setCode(1000);

            response.setMessage("get all sucessfully");
            response.setData(priceRepository.findAll());
            return response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public ApiResponse getDetailPricing(UUID id) {
        try{
            var detailPricingRecord = priceRepository.findById(id).orElse(null);
            if(Objects.isNull(detailPricingRecord)) {
                throw new CustomException(ErrorCode.NOT_EXISTED);
            }

            ApiResponse response = new ApiResponse();
            response.setSucess(true);
            response.setCode(1000);
            response.setMessage("sucessfully");
            response.setData(detailPricingRecord);
            return  response;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse grantedPriority() {
        return null;
    }
}
