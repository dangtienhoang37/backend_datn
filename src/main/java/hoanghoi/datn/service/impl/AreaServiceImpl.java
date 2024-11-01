package hoanghoi.datn.service.impl;

import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.repository.AreaRepository;
import hoanghoi.datn.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaRepository areaRepository;



    @Override
    public ApiResponse adminAddAreaService() {
        return null;
    }

    @Override
    public ApiResponse adminGrantStaffService() {
        return null;
    }

    @Override
    public ApiResponse adminRemoveAreaService() {
        return null;
    }

    @Override
    public ApiResponse changeAreaInforService() {
        return null;
    }

    @Override
    public ApiResponse getAllAreaService() {
        ApiResponse response = new ApiResponse();
        response.setCode(1000);
        response.setMessage("");
        response.setResult(areaRepository.findAll());
        return response;
    }

    @Override
    public ApiResponse getDetailAreaService() {
        return null;
    }
}
