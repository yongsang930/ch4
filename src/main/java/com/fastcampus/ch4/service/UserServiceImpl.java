package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.UserDao;
import com.fastcampus.ch4.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public int addUser(UserDto userDto) throws Exception {
        return userDao.insertUser(userDto);
    }

    @Override
    public int editUser(UserDto userDto) throws Exception {
        return userDao.updateUser(userDto);
    }

    @Override
    public int removeUser(String id) throws Exception {
        return userDao.deleteUser(id);
    }

    @Override
    public UserDto readUser(String id) throws Exception {
        return userDao.selectUser(id);
    }

    @Override
    public List readAllUser() throws Exception {
        return userDao.selectAll();
    }
}
