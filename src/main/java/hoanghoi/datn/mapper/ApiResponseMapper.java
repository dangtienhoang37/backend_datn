package hoanghoi.datn.mapper;


import hoanghoi.datn.dto.response.ApiResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApiResponseMapper {
    ApiResponse toApiResponse(ApiResponse res);
}
