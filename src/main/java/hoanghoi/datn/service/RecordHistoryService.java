package hoanghoi.datn.service;

import hoanghoi.datn.dto.response.ApiResponse;

public interface RecordHistoryService {

    ApiResponse getRecordByUserService();
    ApiResponse getRecordByParkingService();
    ApiResponse getDetailRecordByUserService();
    // get record chi tiết bởi staff

}
