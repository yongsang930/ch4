package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dto.UserDto;

import java.util.List;

public interface UserService {
    int addUser(UserDto userDto) throws Exception;

    int editUser(UserDto userDto) throws Exception;

    int removeUser(String id) throws Exception;

    UserDto readUser(String id) throws Exception;

    List readAllUser() throws Exception;
}
