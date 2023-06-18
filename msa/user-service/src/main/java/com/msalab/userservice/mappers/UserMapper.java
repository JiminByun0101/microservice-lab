package com.msalab.userservice.mappers;

import com.msalab.userservice.entities.User;
import com.msalab.userservice.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserGetDto userToUserGetDto(
            User user
    );

    User userPostDtoToUser(
            UserPostDto userPostDto
    );

    List<UserGetDto> userToUserGetDto(
            List<User> users
    );
}
