package hoanghoi.datn.service.impl;

import hoanghoi.datn.dto.request.Creation.AreaCreationRequest;
import hoanghoi.datn.dto.request.granted.AreaStaffGrantedRequest;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.entity.Area;
import hoanghoi.datn.exception.CustomException;
import hoanghoi.datn.exception.ErrorCode;
import hoanghoi.datn.mapper.ApiResponseMapper;
import hoanghoi.datn.mapper.AreaMapper;
import hoanghoi.datn.repository.AreaRepository;
import hoanghoi.datn.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private ApiResponseMapper responseMapper;


    @Override
    public ApiResponse<Area> adminAddAreaService(AreaCreationRequest request) {
        try{
            Area newArea = areaMapper.toArea(request);

            ApiResponse<Area> res = new ApiResponse<>();
            res.setCode(1000);
            res.setMessage("add new Area Sucessfully!");
            res.setResult(areaRepository.save(newArea));
            return res;

        } catch (Exception e) {
            throw new CustomException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }

    }

    @Override
    public ApiResponse adminAddAreaService() {
        return null;
    }

    @Override
    public ApiResponse adminGrantStaffService(int id, AreaStaffGrantedRequest request) {


        return null;
    }


    @Override
    public ApiResponse adminRemoveAreaService(int id) {
        try {
            var targetArea = areaRepository.findById(id).orElse(null);
            if(Objects.isNull(targetArea)){
                throw new CustomException(ErrorCode.NOT_EXISTED);
            }
            targetArea.setActive(false);
            ApiResponse<Area> res = new ApiResponse<>();
            res.setCode(1000);
            res.setMessage("add new Area Sucessfully!");
            res.setResult(areaRepository.save(targetArea));
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

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
    public ApiResponse getDetailAreaService(int id) {
        var targetArea = areaRepository.findById(id).orElse(null);
        if(Objects.isNull(targetArea)) {
            throw new CustomException(ErrorCode.NOT_EXISTED); 
        }
        ApiResponse response = new ApiResponse();
        response.setCode(1000);

        response.setMessage("");
        response.setResult(targetArea);

        return response;
    }

    @Override
    public ApiResponse changeAreaInforService(int id, AreaCreationRequest request) {

        var targetArea = areaRepository.findById(id).orElse(null);
        if(Objects.isNull(targetArea)) {
            throw new RuntimeException("Cant find area id");
        }


        targetArea.setAreaName(request.getAreaName());
        targetArea.setWard(request.getWard());
        targetArea.setDistrict(request.getDistrict());
        targetArea.setCity(request.getCity());
        targetArea.setStaffId(request.getStaffId());


        ApiResponse response = new ApiResponse();
        response.setCode(1000);
        response.setMessage("change area info sucessfully");
        response.setResult(areaRepository.save(targetArea));
        return null;
    }


}
