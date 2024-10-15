package hoanghoi.datn.entity;

import java.util.UUID;

public class Parking {
    private UUID id;
    private int areaId;
    private UUID priceId;
    private UUID staffId;
    private String parkingName;
    private int directSpacesCap;
    private int directSpacesAvailible;
    private int reservedSpacesCap;
    private int reservedSpacesAvailible;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public UUID getPriceId() {
        return priceId;
    }

    public void setPriceId(UUID priceId) {
        this.priceId = priceId;
    }

    public UUID getStaffId() {
        return staffId;
    }

    public void setStaffId(UUID staffId) {
        this.staffId = staffId;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public int getDirectSpacesCap() {
        return directSpacesCap;
    }

    public void setDirectSpacesCap(int directSpacesCap) {
        this.directSpacesCap = directSpacesCap;
    }

    public int getDirectSpacesAvailible() {
        return directSpacesAvailible;
    }

    public void setDirectSpacesAvailible(int directSpacesAvailible) {
        this.directSpacesAvailible = directSpacesAvailible;
    }

    public int getReservedSpacesCap() {
        return reservedSpacesCap;
    }

    public void setReservedSpacesCap(int reservedSpacesCap) {
        this.reservedSpacesCap = reservedSpacesCap;
    }

    public int getReservedSpacesAvailible() {
        return reservedSpacesAvailible;
    }

    public void setReservedSpacesAvailible(int reservedSpacesAvailible) {
        this.reservedSpacesAvailible = reservedSpacesAvailible;
    }
}
