package com.codewithhims.blog_app_apis.controllers;

import com.codewithhims.blog_app_apis.payloads.ApiResponse;
import com.codewithhims.blog_app_apis.payloads.UserDto;
import com.codewithhims.blog_app_apis.services.UserService;
import com.codewithhims.blog_app_apis.services.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import java.util.Map;

@RestController
@RequestMapping("/api/users")
public  class UserController {

    @Autowired
    private UserServiceImpl userService;

    //POST-create user

    @PostMapping("/")
    public ResponseEntity<UserDto>createUser(@Valid @RequestBody UserDto userDto)
    {
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    //PUT- update user
    @PutMapping("/{userId}")
    public  ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid)
    {
       UserDto updatedUser= this.userService.updateUser(userDto, uid);
       return ResponseEntity.ok(updatedUser);

    }
    //DELETE- delete user
    @DeleteMapping
     public ResponseEntity<?>deleteUser(@PathVariable("userId")Integer uid)
    {
        this.userService.deleteUser(uid);
        return new ResponseEntity(new ApiResponse("USer Deleted Successfully",true),HttpStatus.OK);
    }
    //GET-user
    @GetMapping("/")
     public ResponseEntity<List<UserDto>> getAllUsers()
    {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
    //GET-user
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId)
    {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
