package hoanghoi.datn.service;

import hoanghoi.datn.dto.request.Creation.BookingCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;

import java.util.UUID;

public interface ReservationScheduleService {
    ApiResponse booking(BookingCreationRequest request, String token);
    ApiResponse getAllService();
//    ApiResponse getAllByAreaService();

    ApiResponse getAllByParking(UUID parkingId, String token);

    ApiResponse getByUser(UUID id, String token);
    // get all theo staff
}
