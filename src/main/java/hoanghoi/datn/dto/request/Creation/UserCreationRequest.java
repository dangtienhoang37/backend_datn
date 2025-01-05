package hoanghoi.datn.dto.request.Creation;

import hoanghoi.datn.enumvar.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
     String fullName;
     Gender gender;
     String phoneNumber;
     String PID;
     String email;
     String address;
//     Optional<MultipartFile> file;
}
