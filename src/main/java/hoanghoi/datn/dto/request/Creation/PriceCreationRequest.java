package hoanghoi.datn.dto.request.Creation;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PriceCreationRequest {
   Long dayTimeRate;
   Long nightTimeRate;
}
