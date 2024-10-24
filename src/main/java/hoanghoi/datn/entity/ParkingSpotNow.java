package hoanghoi.datn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;
@Setter
@Getter
@Entity
@Table(name = "parking_spots_now")
public class ParkingSpotNow {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID accountId;
    private UUID parkingId;
    private int spotIndex;
    private Instant entryTime;
    private int dayTime;
    private int nightTime;
    private long estCost;

}
