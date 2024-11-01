package hoanghoi.datn.mapper;

import hoanghoi.datn.config.CustomPasswordEncoder;
import hoanghoi.datn.dto.request.Creation.AccountCreationRequest;
import hoanghoi.datn.entity.Account;
import hoanghoi.datn.enumvar.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AccountMapper {
//    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);


//    @Mapping(target = "role", constant = "USER")
//    @Mapping(target = "password",expression = "java(passwordEncoder.encode(request.getPassword()))")
    @Mappings({
            @Mapping(target = "role", constant = "USER" ),
            @Mapping(target = "password",expression = "java(passwordEncoder.encode(request.getPassword()))")
    })
    Account toAccount(AccountCreationRequest request, CustomPasswordEncoder passwordEncoder);
}
