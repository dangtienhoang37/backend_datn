package hoanghoi.datn.dto.dbobj;

import hoanghoi.datn.entity.District;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class warDTO {

    String id;
    String name;
    String enName;
    String fullName;
    String enFullName;
    String codeName;
    String district_id;

}
