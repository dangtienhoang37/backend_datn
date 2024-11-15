package hoanghoi.datn.dto.request.Creation;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParkingCreationRequest {
    int areaId;
    UUID priceId;
    UUID staffId;
    Double latitude;
    Double longtitude;
    String parkingName;
    int directSpacesCap;
    int directSpacesAvailible;
    int reservedSpacesCap;
    int reservedSpacesAvailible;
}
