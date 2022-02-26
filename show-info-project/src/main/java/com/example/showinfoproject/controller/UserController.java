package com.example.showinfoproject.controller;

import com.example.showinfoproject.data.dto.request.UserInfoRequestDto;
import com.example.showinfoproject.data.dto.response.UserInfoResponseDto;
import com.example.showinfoproject.data.entity.User;
import com.example.showinfoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public void saveUser(@RequestBody UserInfoRequestDto userInfoRequestDto){
        userService.saveUser(userInfoRequestDto);
    }

    @GetMapping("/userById/{id}")
    public UserInfoResponseDto findUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}
