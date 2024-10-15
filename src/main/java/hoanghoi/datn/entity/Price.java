package hoanghoi.datn.entity;

import java.util.UUID;

public class Price {
    private UUID id;
    private Long dayTimeRate;
    private Long nightTimeRate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getDayTimeRate() {
        return dayTimeRate;
    }

    public void setDayTimeRate(Long dayTimeRate) {
        this.dayTimeRate = dayTimeRate;
    }

    public Long getNightTimeRate() {
        return nightTimeRate;
    }

    public void setNightTimeRate(Long nightTimeRate) {
        this.nightTimeRate = nightTimeRate;
    }
}
