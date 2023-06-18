package com.msalab.authservice.controllers;

import com.msalab.authservice.mapstruct.dtos.AuthorAllDto;
import com.msalab.authservice.mapstruct.mappers.MapStructMapper;
import com.msalab.authservice.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auths")
public class AuthController {

    private MapStructMapper mapstructMapper;

    private AuthRepository authRepository;

    @Autowired
    public AuthController(
            MapStructMapper mapstructMapper,
            AuthRepository authRepository
    ) {
        this.mapstructMapper = mapstructMapper;
        this.authRepository = authRepository;
    }

    @GetMapping()
    public ResponseEntity<List<AuthAllDto>> getAll() {
        return new ResponseEntity<>(
                mapstructMapper.authsToAuthAllDtos(
                        authRepository.findAll()
                ),
                HttpStatus.OK
        );
    }

}
