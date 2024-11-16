package hoanghoi.datn.service;

import hoanghoi.datn.dto.request.Creation.UserCreationRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public interface UserService {
    //admin space
    public ApiResponse adminGetAllUser();
    public ApiResponse adminGetDetailUser();


    //end Admin space

    public ApiResponse booking();
    public ApiResponse getListParking();
    public ApiResponse updateAvatar(String token, MultipartFile file);
    public ApiResponse addInfor(String token, UserCreationRequest request);
    public ApiResponse updatePersonalInformation();

    ApiResponse getDetailUser(String token);
}
