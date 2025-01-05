package hoanghoi.datn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import hoanghoi.datn.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {


    @Override
    public String uploadImg(MultipartFile file) throws IOException {
        Map<String, Object> uploadParams = new HashMap<>();
        uploadParams.put("folder", "avt");
        Cloudinary cloudinary = new Cloudinary();
        Map uploadRes = cloudinary.uploader().upload(file.getBytes(), uploadParams);
        return uploadRes.get("url").toString();
    }
}
