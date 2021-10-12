package com.personal.financial.mapper;

import com.personal.financial.document.User;
import com.personal.financial.resource.request.UserRequest;
import com.personal.financial.resource.response.UserResponse;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(componentModel = "spring")
public interface UserMapper extends Mapper<UserRequest, User, UserResponse> {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
