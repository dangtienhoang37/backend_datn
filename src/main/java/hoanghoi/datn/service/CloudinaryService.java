package hoanghoi.datn.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    String uploadImg(MultipartFile file) throws IOException;
}
