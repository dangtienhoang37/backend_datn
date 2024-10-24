package hoanghoi.datn.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Long dayTimeRate;
    private Long nightTimeRate;

}
