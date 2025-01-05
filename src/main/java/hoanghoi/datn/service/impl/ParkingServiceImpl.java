package hoanghoi.datn.service.impl;

import hoanghoi.datn.dto.request.Creation.ParkingCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.entity.*;
import hoanghoi.datn.exception.CustomException;
import hoanghoi.datn.exception.ErrorCode;
import hoanghoi.datn.mapper.ParkingMapper;
import hoanghoi.datn.repository.*;
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
    private AccountRepository accountRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private WardRepository wardRepository;
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private ParkingMapper parkingMapper;
    private static final Logger logger = LoggerFactory.getLogger(ParkingServiceImpl.class);
//    @Autowired
//    private ApiResponse apiResponse;
    @Override
    // them hasrole admin
    public ApiResponse adminCreateParkingService(ParkingCreationRequest request) {
        try{
            System.out.println("entry");
            Ward targetWard = wardRepository.findById(request.getWardId()).orElse(null);
            Price targetPrice = priceRepository.findById(request.getPriceId()).orElse(null);
            Account targetStaff = accountRepository.findById(request.getStaffId()).orElse(null);
            District targetDistrict = districtRepository.findById(request.getDistrictId()).orElse(null);
            // mapper
            Parking newParking = Parking.builder()
                    .parkingName(request.getParkingName())
                    .price(targetPrice)
                    .account(targetStaff)
                    .directSpacesAvailible(request.getDirectSpacesAvailible())
                    .directSpacesCap(request.getDirectSpacesCap())
                    .deviceId(request.getDeviceId())
                    .longtitude(request.getLongtitude())
                    .latitude(request.getLatitude())
                    .reservedSpacesCap(request.getReservedSpacesCap())
                    .reservedSpacesAvailible(request.getReservedSpacesAvailible())
                    .ward(targetWard)
                    .district(targetDistrict)
                    .build();
            log.info("okkkkkkk1");
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
            Ward targetWard = wardRepository.findById(request.getWardId()).orElse(null);
            Price targetPrice = priceRepository.findById(request.getPriceId()).orElse(null);
            Account targetStaff = accountRepository.findById(request.getStaffId()).orElse(null);
            District targetDistrict = districtRepository.findById(request.getDistrictId()).orElse(null);
            // mapper
            target.setParkingName(request.getParkingName());
            target.setPrice(targetPrice);
            target.setAccount(targetStaff);
            target.setDirectSpacesAvailible(request.getDirectSpacesAvailible());
            target.setDirectSpacesCap(request.getDirectSpacesCap());
            target.setLongtitude(request.getLongtitude());
            target.setLatitude(request.getLatitude());
            target.setReservedSpacesCap(request.getReservedSpacesCap());
            target.setReservedSpacesAvailible(request.getReservedSpacesAvailible());
            target.setWard(targetWard);
            target.setDistrict(targetDistrict);


//            target = parkingMapper.toParking(request);
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
    public ApiResponse getAllParkingByDistrict(String districtId) {
        new ApiResponse<List<Parking>>();
        var targetDistrict = districtRepository.findById(districtId).orElse(null);
        return  ApiResponse.builder()
                .code(1000)
                .message("get by Area sucessfully")
                .isSucess(true)
                .data(parkingRepository.findAllByDistrict(targetDistrict))
                .build();
    }

    @Override
    public ApiResponse getAllParkingByWard(String wardId) {
        new ApiResponse<List<Parking>>();
        var targetWard = wardRepository.findById(wardId).orElse(null);

        return  ApiResponse.builder()
                .code(1000)
                .message("get by Area sucessfully")
                .isSucess(true)
                .data(parkingRepository.findAllByWard(targetWard))
                .build();
    }

    @Override
    public ApiResponse getDetailParking(UUID id) {
        new ApiResponse<Parking>();
        return ApiResponse.builder()
                .code(1000)
                .message("get detail sucessfully")
                .isSucess(true)
                .data(parkingRepository.findById(id))
                .build();
    }


}
