package hoanghoi.datn.service;

import hoanghoi.datn.dto.response.ApiResponse;

public interface ParkingService {
    //admin space
    ApiResponse adminCreateParkingService();
    ApiResponse adminUpdateParkingService();
    ApiResponse adminDisableParkingService();

    //end admin space
    ApiResponse slotRemainingservice();
    ApiResponse bookingService();
    ApiResponse getAllParking();
    ApiResponse getDetalParking();
}
