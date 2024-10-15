package hoanghoi.datn.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public class RecordHistory {
    private UUID id;
    private UUID parkingId;
    private int spotIndex;
    private String lplateNumber;
    private Instant entryTime;
    private Instant endTime;
    private Instant dayTime;
    private Instant nightTime;
    private Long totalCost;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getParkingId() {
        return parkingId;
    }

    public void setParkingId(UUID parkingId) {
        this.parkingId = parkingId;
    }

    public int getSpotIndex() {
        return spotIndex;
    }

    public void setSpotIndex(int spotIndex) {
        this.spotIndex = spotIndex;
    }

    public String getLplateNumber() {
        return lplateNumber;
    }

    public void setLplateNumber(String lplateNumber) {
        this.lplateNumber = lplateNumber;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }

    public Instant getDayTime() {
        return dayTime;
    }

    public void setDayTime(Instant dayTime) {
        this.dayTime = dayTime;
    }

    public Instant getNightTime() {
        return nightTime;
    }

    public void setNightTime(Instant nightTime) {
        this.nightTime = nightTime;
    }

    public Long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }
}
