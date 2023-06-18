package com.msalab.authservice.mapstruct.mappers;

import com.msalab.authservice.entities.AuthService;
import com.msalab.authservice.mapstruct.dtos.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface MapStructMapper {

    AuthServiceDto authServiceToAuthServiceDto(
            AuthService authService
    );

    AuthServiceAllDto authServiceToAuthServiceAllDto(
            AuthService authService
    );

    List<AuthServiceAllDto> authServicesToAuthServiceAllDtos(
            List<AuthService> authServices
    );

}