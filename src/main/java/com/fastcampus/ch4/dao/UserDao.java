package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface UserDao {

    UserDto selectUser(String id) throws Exception;

    int deleteUser(String id) throws Exception;

    int insertUser(UserDto user) throws Exception;

    int updateUser(UserDto user) throws Exception;

    List selectAll() throws Exception;
}