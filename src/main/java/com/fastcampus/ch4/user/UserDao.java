package com.fastcampus.ch4.user;

public interface UserDao {
    UserDto selectUser(String id) throws Exception;

    int deleteUser(String id) throws Exception;

    int insertUser(UserDto user) throws Exception;

    int updateUser(UserDto user) throws Exception;
}