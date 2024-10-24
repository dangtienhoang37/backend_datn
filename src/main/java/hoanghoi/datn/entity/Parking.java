package hoanghoi.datn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "parking")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int areaId;
    private UUID priceId;
    private UUID staffId;
    private Double latitude;
    private Double longtitude;
    private String parkingName;
    private int directSpacesCap;
    private int directSpacesAvailible;
    private int reservedSpacesCap;
    private int reservedSpacesAvailible;

}
