package hoanghoi.datn.mapper;


import hoanghoi.datn.dto.request.Creation.AreaCreationRequest;
import hoanghoi.datn.entity.Area;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AreaMapper {

    Area toArea(AreaCreationRequest areaCreationRequest);
    
}
