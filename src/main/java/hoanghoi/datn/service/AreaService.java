package hoanghoi.datn.service;

import hoanghoi.datn.dto.response.ApiResponse;


public interface AreaService {
    // admin space
    ApiResponse adminAddAreaService();
    ApiResponse adminGrantStaffService();
    ApiResponse adminRemoveAreaService();
    // end admin space
    //
    ApiResponse changeAreaInforService();
    ApiResponse getAllAreaService();
    ApiResponse getDetailAreaService();

    //
}
