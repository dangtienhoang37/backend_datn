package hoanghoi.datn.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "areas")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
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
    @ManyToOne
    @JoinColumn(name="staffId",referencedColumnName = "id")
    private Account account;

    @PrePersist
    public void setDefaultValues() {
        if(City == null) {
            City = "Hanoi";
        }
    }
}
