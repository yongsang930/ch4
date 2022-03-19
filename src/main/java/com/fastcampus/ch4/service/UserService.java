package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.UserDao;
import com.fastcampus.ch4.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public int addUser(UserDto userDto) throws Exception {
        return userDao.insertUser(userDto);
    }

    public int editUser(UserDto userDto) throws Exception {
        return userDao.updateUser(userDto);
    }

    public int removeUser(String id) throws Exception {
        return userDao.deleteUser(id);
    }

    public UserDto readUser(String id) throws Exception {
        return userDao.selectUser(id);
    }

    public List readAllUser() throws Exception {
        return userDao.selectAll();
    }
}
