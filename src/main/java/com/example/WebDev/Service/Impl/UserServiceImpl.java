package com.example.WebDev.Service.Impl;

import com.example.WebDev.Entity.Role;
import com.example.WebDev.Enums.Roles;
import com.example.WebDev.Dto.UserDto;
import com.example.WebDev.Entity.User;
import com.example.WebDev.Repository.RoleRepository;
import com.example.WebDev.Repository.UserRepository;
import com.example.WebDev.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUserName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = new Role(Roles.USER, "User");
        user.setRole(role);

        userRepository.save(user);
    }

    private UserDto mapToUserDto (User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUserName(user.getUsername());
        return userDto;
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

}
