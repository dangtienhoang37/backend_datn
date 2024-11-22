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
@Table(name = "parking")
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "wardId", referencedColumnName = "id")
    private Ward ward;
    @OneToOne
    @JoinColumn(name ="priceId" , referencedColumnName = "id")
    private Price price;
    @ManyToOne
    @JoinColumn(name ="staffId" , referencedColumnName = "id")
    private Account account;
    private Double latitude;
    private Double longtitude;
    private String parkingName;
    private int directSpacesCap;
    private int directSpacesAvailible;
    private int reservedSpacesCap;
    private int reservedSpacesAvailible;

}
