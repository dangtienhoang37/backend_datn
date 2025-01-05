package hoanghoi.datn.service;

import hoanghoi.datn.dto.request.Creation.ParkingCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;

import java.util.UUID;

public interface ParkingService {
    //admin space
    ApiResponse adminCreateParkingService(ParkingCreationRequest request);
    ApiResponse adminUpdateParkingService(UUID id, ParkingCreationRequest request);
    ApiResponse adminDisableParkingService();

    //end admin space
    ApiResponse slotRemainingservice();
    ApiResponse bookingService();
    ApiResponse getAllParking();
    ApiResponse getDetailParking(UUID id);

    ApiResponse getAllParkingByDistrict(String districtId);

    ApiResponse getAllParkingByWard(String wardId);
}
