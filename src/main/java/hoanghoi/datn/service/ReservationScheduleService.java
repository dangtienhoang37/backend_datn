package hoanghoi.datn.service;

import hoanghoi.datn.dto.response.ApiResponse;

public interface ReservationScheduleService {
    ApiResponse getAllService();
    ApiResponse getAllByAreaService();
    ApiResponse getAllByParking();
}
