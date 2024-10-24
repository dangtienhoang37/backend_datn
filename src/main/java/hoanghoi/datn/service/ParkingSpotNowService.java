package hoanghoi.datn.service;

import hoanghoi.datn.dto.response.ApiResponse;

public interface ParkingSpotNowService {
    ApiResponse getAllSpotStatusService();
    ApiResponse getDetailSpotStatusService();

}
