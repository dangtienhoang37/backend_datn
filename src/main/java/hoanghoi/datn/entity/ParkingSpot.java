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
@Table(name = "parking_spots")
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "accountId", referencedColumnName = "id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "parkingId", referencedColumnName = "id")
    private Parking parking;
    private int spotIndex;
    private Instant entryTime;
    private int dayTime;
    private int nightTime;
    private long estCost;

}
