package hoanghoi.datn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "reservation_schedules")
public class ReservationSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID accountId;
    private UUID parkingId;
    private Instant startTime;
    private Instant endTime;

}
