package com.fastcampus.ch4.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.fastcampus.ch4.user.UserMapper.";

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
}