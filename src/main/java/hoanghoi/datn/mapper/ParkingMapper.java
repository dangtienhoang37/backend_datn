package hoanghoi.datn.mapper;


import hoanghoi.datn.dto.request.Creation.ParkingCreationRequest;
import hoanghoi.datn.entity.Parking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParkingMapper {
    Parking toParking(ParkingCreationRequest parkingCreationRequest);
}
