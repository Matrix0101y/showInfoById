package com.example.showinfoproject.service;

import com.example.showinfoproject.data.dto.request.UserInfoRequestDto;
import com.example.showinfoproject.data.dto.response.UserInfoResponseDto;
import com.example.showinfoproject.data.entity.User;

public interface UserService {

    UserInfoResponseDto getUserById(Long id);

    void saveUser(UserInfoRequestDto userInfoRequestDto);
}
