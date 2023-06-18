package com.msalab.userservice.services;

import com.msalab.userservice.dtos.UserGetDto;
import com.msalab.userservice.dtos.UserPostDto;
import com.msalab.userservice.entities.User;
import com.msalab.userservice.exception.DataNotFoundException;
import com.msalab.userservice.mappers.UserMapper;
import com.msalab.userservice.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    public UserPostDto create(UserPostDto userPostDto) {
        userRepository.save(userMapper.userPostDtoToUser(userPostDto));
        return userPostDto;
    }

    public UserGetDto getById(int id) throws DataNotFoundException {
        User user = userRepository.findById(id).orElseThrow(DataNotFoundException::new);
        return userMapper.userToUserGetDto(user);
    }

    public List<UserGetDto> getAll() {
        List<User> users = userRepository.findAll();
        return userMapper.userToUserGetDto(users);
    }

}
