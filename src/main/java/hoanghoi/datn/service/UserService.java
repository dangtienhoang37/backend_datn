package hoanghoi.datn.service;

import hoanghoi.datn.dto.response.ApiResponse;

public interface UserService {
    //admin space
    public ApiResponse adminGetAllUser();
    public ApiResponse adminGetDetailUser();


    //end Admin space

    public ApiResponse booking();
    public ApiResponse getListParking();
    public ApiResponse updateAvatar();
    public ApiResponse addInfor();
    public ApiResponse updatePersonalInformation();
}
