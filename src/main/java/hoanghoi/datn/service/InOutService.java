package hoanghoi.datn.service;

import hoanghoi.datn.dto.response.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface InOutService {
      ApiResponse checkin(UUID deviceId, UUID accountId, long timestamp, MultipartFile file);

     ApiResponse checkout(UUID deviceId, UUID accountId, long timestamp, MultipartFile file);

}
