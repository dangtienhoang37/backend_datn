package hoanghoi.datn.service.impl;

import hoanghoi.datn.dto.request.Creation.ParkingCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.entity.Parking;
import hoanghoi.datn.exception.CustomException;
import hoanghoi.datn.exception.ErrorCode;
import hoanghoi.datn.mapper.ParkingMapper;
import hoanghoi.datn.repository.ParkingRepository;
import hoanghoi.datn.service.ParkingService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private ParkingMapper parkingMapper;
    private static final Logger logger = LoggerFactory.getLogger(ParkingServiceImpl.class);
//    @Autowired
//    private ApiResponse apiResponse;
    @Override
    public ApiResponse adminCreateParkingService(ParkingCreationRequest request) {
        try{
            Parking newParking = parkingMapper.toParking(request);
//            logger.info("mappp", newParking);
//            return null;
            return new ApiResponse<>(1000,"create Parking Sucessfully",true,parkingRepository.save(newParking));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse adminUpdateParkingService(UUID id, ParkingCreationRequest request) {
        try{
            var target = parkingRepository.findById(id).orElse(null);
            if(Objects.isNull(target)){
                throw new CustomException(ErrorCode.NOT_EXISTED);
            }
            target = parkingMapper.toParking(request);
            ApiResponse<Parking> response = new ApiResponse<>(1000,"update Parking Sucessfully",true, parkingRepository.save(target));
            return response;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResponse adminDisableParkingService() {
        return null;
    }

    @Override
    public ApiResponse slotRemainingservice() {
        return null;
    }

    @Override
    public ApiResponse bookingService() {
        return null;
    }

    @Override
    public ApiResponse getAllParking() {
        try{
            return new ApiResponse<List<Parking>>(1000,"get all sucessfully",true,parkingRepository.findAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // get by area
    @Override
    public ApiResponse getAllParkingByArea(int areaId) {
        new ApiResponse<List<Parking>>();
        return  ApiResponse.builder()
                .code(1000)
                .message("get by Area sucessfully")
                .isSucess(true)
                .result(parkingRepository.findByareaId(areaId))
                .build();
    }

    @Override
    public ApiResponse getDetailParking(UUID id) {
        new ApiResponse<Parking>();
        return ApiResponse.builder()
                .code(1000)
                .message("get detail sucessfully")
                .isSucess(true)
                .result(parkingRepository.findById(id))
                .build();
    }


}
