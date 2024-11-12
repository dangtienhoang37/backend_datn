package hoanghoi.datn.enumvar;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum Role {
    ADMIN,
    STAFF,
    USER
}
