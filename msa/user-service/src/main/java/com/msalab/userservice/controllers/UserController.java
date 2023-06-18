package com.msalab.userservice.controllers;

import com.msalab.userservice.dtos.UserGetDto;
import com.msalab.userservice.dtos.UserPostDto;
import com.msalab.userservice.services.UserService;
import com.msalab.userservice.mappers.UserMapper;
import com.msalab.userservice.exception.DataNotFoundException;
import com.msalab.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public UserPostDto create(@RequestBody UserPostDto userPostDto){

        return userService.create(userPostDto);
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", value ="USER")
    public UserGetDto getById(@PathVariable("id") int id) throws DataNotFoundException {
        return userService.getById(id);
    }

    @GetMapping()
    public List<UserGetDto> getAll(){
        return userService.getAll();
    }

}
