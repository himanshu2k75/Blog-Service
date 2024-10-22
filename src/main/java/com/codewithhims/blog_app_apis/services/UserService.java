package com.codewithhims.blog_app_apis.services;

import com.codewithhims.blog_app_apis.entities.User;
import com.codewithhims.blog_app_apis.payloads.UserDto;
import jakarta.persistence.Entity;

import java.util.List;

public interface   UserService {



    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user ,Integer userId);
    UserDto getUserById(Integer id);
    List<UserDto>getAllUsers();

    void deleteUser(Integer userId);

}
