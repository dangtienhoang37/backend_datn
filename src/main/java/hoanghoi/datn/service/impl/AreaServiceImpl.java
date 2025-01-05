package hoanghoi.datn.service.impl;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import hoanghoi.datn.dto.dbobj.warDTO;
import hoanghoi.datn.dto.response.ApiResponse;
import hoanghoi.datn.entity.District;
import hoanghoi.datn.entity.Ward;
import hoanghoi.datn.mapper.ApiResponseMapper;
import hoanghoi.datn.mapper.AreaMapper;
import hoanghoi.datn.repository.AccountRepository;
import hoanghoi.datn.repository.DistrictRepository;
import hoanghoi.datn.repository.WardRepository;
import hoanghoi.datn.service.AreaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class AreaServiceImpl implements AreaService {


    @Autowired
    private AreaMapper areaMapper;
    @Autowired
    private ApiResponseMapper responseMapper;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private WardRepository wardRepository;



    @Override
    public ApiResponse initLocation() throws IOException {
            try{
                ObjectMapper objectMapper = new ObjectMapper();
                List<District> districts = objectMapper.readValue(new File("src/main/resources/locationResource/district.json"),objectMapper.getTypeFactory().constructCollectionType(List.class, District.class));
                districtRepository.saveAll(districts);
                return null;
            } catch (DatabindException e) {
                throw new RuntimeException(String.valueOf(e));
            } catch (IOException e) {
                throw new RuntimeException(e);

            }


    }

    @Override
    public ApiResponse initWard() throws IOException {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            log.info("okkkkkk");
            List<warDTO> wards = objectMapper.readValue(new File("src/main/resources/locationResource/ward.json"),objectMapper.getTypeFactory().constructCollectionType(List.class, warDTO.class));
            log.info(wards.toString());

            List<Ward> wardList = new ArrayList<>();
            for(warDTO w: wards){
                var district = districtRepository.findById(w.getDistrict_id()).orElse(null);
                if(Objects.isNull(district)) {
                    throw new RuntimeException("cant find district");
                }
                Ward indexWard = new Ward();
                indexWard.setId(w.getId());
                indexWard.setName(w.getName());
                indexWard.setEnName(w.getEnName());
                indexWard.setFullName(w.getFullName());
                indexWard.setEnFullName(w.getEnFullName());
                indexWard.setCodeName(w.getCodeName());
                indexWard.setDistrict(district);

                wardList.add(indexWard);
            }
            wardRepository.saveAll(wardList);
            return null;
        } catch (DatabindException e) {
            throw new RuntimeException(String.valueOf(e));
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public ApiResponse getAllDistrict() {
        new ApiResponse<>();

        return ApiResponse.builder()
                .code(1000)
                .message("get all sucessfully")
                .isSucess(true)
                .data(districtRepository.findAll())
                .build();
    }

    @Override
    public ApiResponse getDistrict(String id) {
        new ApiResponse<>();

        return ApiResponse.builder()
                .code(1000)
                .message("get all sucessfully")
                .isSucess(true)
                .data(districtRepository.findById(id))
                .build();
    }

    @Override
    public ApiResponse getWard(String id) {
        new ApiResponse<>();

        return ApiResponse.builder()
                .code(1000)
                .message("get all sucessfully")
                .isSucess(true)
                .data(wardRepository.findById(id))
                .build();
    }

    @Override
    public ApiResponse getAllWard(String districtId) {
        var district = districtRepository.findById(districtId).orElse(null);

        if(Objects.isNull(district)) {
            throw  new RuntimeException("cant find district by id");
        }
        new ApiResponse<>();
        var listd = wardRepository.findAllByDistrict(district);
        // khai mapper
        ObjectMapper mapper = new ObjectMapper();
        List<ObjectNode> newListRes = new ArrayList<>();
        for(Ward index : listd){
            ObjectNode node =  mapper.valueToTree(index);
            node.remove("district");
            newListRes.add(node);        }

        return ApiResponse.builder()
                .code(1000)
                .message("get all sucessfully")
                .isSucess(true)
                .data(newListRes)
                .build();
    }
}
