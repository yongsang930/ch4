package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.dao.UserDao;
import com.fastcampus.ch4.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.fastcampus.ch4.dao.UserMapper.";

    @Override
    public int deleteUser(String id) throws Exception {
        return session.delete(namespace + "deleteUser", id);
    }

    @Override
    public UserDto selectUser(String id) throws Exception {
        return session.selectOne(namespace + "selectUser", id);
    }

    @Override
    public int insertUser(UserDto user) throws Exception {
        return session.insert(namespace + "insertUser", user);
    }

    @Override
    public int updateUser(UserDto user) throws Exception {
        return session.update(namespace + "updateUser", user);
    }

    @Override
    public List selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }
}