package hoanghoi.datn.mapper;

import hoanghoi.datn.dto.request.Creation.UserCreationRequest;
import hoanghoi.datn.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

}
