package hoanghoi.datn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "areas")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int areaId;
    @NotNull
    private String areaName;
    @NotNull
    private String Ward;
    @NotNull
    private String District;
    @NotNull
    private String City;
    @NotNull
    private boolean isActive = true;

    private UUID staffId;

}
