package com.example.WebDev.Service;

import com.example.WebDev.Dto.UserDto;
import com.example.WebDev.Entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByUserName(String userName);

    List<UserDto> findAllUsers();
}
