package hoanghoi.datn.service;

import com.fasterxml.jackson.databind.DatabindException;
import hoanghoi.datn.dto.request.Creation.AreaCreationRequest;
import hoanghoi.datn.dto.request.granted.AreaStaffGrantedRequest;
import hoanghoi.datn.dto.response.ApiResponse;

import java.io.IOException;


public interface AreaService {


    ApiResponse initLocation() throws IOException;

    ApiResponse initWard() throws IOException;

    ApiResponse getAllDistrict();

    ApiResponse getDistrict(String id);

    ApiResponse getWard(String id);

    ApiResponse getAllWard(String id);


    //
}
