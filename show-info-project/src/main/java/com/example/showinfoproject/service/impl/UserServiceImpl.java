package com.example.showinfoproject.service.impl;

import com.example.showinfoproject.config.ApplicationConfiguration;
import com.example.showinfoproject.data.dto.request.UserInfoRequestDto;
import com.example.showinfoproject.data.dto.response.UserInfoResponseDto;
import com.example.showinfoproject.data.entity.User;
import com.example.showinfoproject.data.repository.UserRepository;
import com.example.showinfoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ApplicationConfiguration applicationConfiguration;

    //best way

    @Override
    public void saveUser(UserInfoRequestDto userInfoRequestDto) {
        User user = userRepository.save(dtoToEntity(userInfoRequestDto));
    }

    public User dtoToEntity(UserInfoRequestDto userInfoRequestDto){
        ModelMapper mapper = new ModelMapper();
        User map = mapper.map(userInfoRequestDto, User.class);
        return map;
    }

    //second way

//    @Override
//    public void saveUser(UserInfoRequestDto userInfoRequestDto) {
//        User entity = applicationConfiguration.getModelMapper().map(userInfoRequestDto, User.class);
//        userRepository.save(entity);
//    }

     //third way

//    @Override
//    public void saveUser(UserInfoRequestDto userInfoRequestDto) {
//        userRepository.save(mapDtoToEntity(userInfoRequestDto));
//    }
//
//    private User mapDtoToEntity(UserInfoRequestDto userInfoRequestDto) {
//        User user = new User();
//        user.setName(userInfoRequestDto.getName());
//        user.setSurname(userInfoRequestDto.getSurname());
//        user.setAge(userInfoRequestDto.getAge());
//        return user;
//    }

    @Override
    public UserInfoResponseDto getUserById(Long id) {

        User user = userRepository.findById(id).get();
        ModelMapper mapper = new ModelMapper();
        UserInfoResponseDto map = mapper.map(user, UserInfoResponseDto.class);
        return map;

    }



}
