package hoanghoi.datn.entity;

import java.time.Instant;
import java.util.UUID;

public class ApiKey {
    private UUID id;
    private Instant createdAt;
    private String key;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
