package hoanghoi.datn.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;
@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parking_spots_now")
public class ParkingSpotNow {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "spotId", referencedColumnName = "id")
    private ParkingSpot spot;
//    @ManyToOne
//    @JoinColumn(name = "parkingId", referencedColumnName = "id")
//    private Parking parking;
    private int spotIndex;
    private Instant entryTime;
    private int dayTime;
    private int nightTime;
    private Instant checkoutTime;

    private long estCost;

}
