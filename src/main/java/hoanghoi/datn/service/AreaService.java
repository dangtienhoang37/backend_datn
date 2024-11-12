package hoanghoi.datn.service;

import hoanghoi.datn.dto.request.Creation.AreaCreationRequest;
import hoanghoi.datn.dto.request.granted.AreaStaffGrantedRequest;
import hoanghoi.datn.dto.response.ApiResponse;


public interface AreaService {
    // admin space
    ApiResponse adminAddAreaService(AreaCreationRequest request);

    ApiResponse adminAddAreaService();

    ApiResponse adminGrantStaffService(int id,AreaStaffGrantedRequest request);

    ApiResponse adminRemoveAreaService(int id);

    // end admin space
    //
    ApiResponse changeAreaInforService();
    ApiResponse getAllAreaService();

    ApiResponse getDetailAreaService(int id);

    ApiResponse changeAreaInforService(int id, AreaCreationRequest request);


    //
}
