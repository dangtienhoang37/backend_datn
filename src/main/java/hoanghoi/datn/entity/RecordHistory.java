package hoanghoi.datn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
@Setter
@Getter
@Entity
@Table(name = "record_histories")

public class RecordHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID parkingId;
    private int spotIndex;
    private String lPlateNumber;
    private Instant entryTime;
    private Instant endTime;
    private Instant dayTime;
    private Instant nightTime;
    private Long totalCost;

}
