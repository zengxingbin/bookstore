package com.service.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.domain.User;
import com.exception.UserException;
import com.service.UserService;
import com.util.SendJMail;
@Service
public class UserServiceImpl implements UserService {

    //private UserDao userDao = new UserDaoImpl();
    @Resource
    private UserMapper userMapper;

    public void register(User newUser) throws UserException {
        try {
            userMapper.addUser(newUser);
            String emailMsg = "注册成功,请<a href = 'http://localhost:8080/bookstore/user/activeUser.do?activeCode=\"+ user.getActiveCode()+\"'>激活</a>后登录";
            SendJMail.sendMail(newUser.getEmail(), emailMsg );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void activerUser(String activeCode) throws UserException {
        // TODO Auto-generated method stub
        
    }

    public User login(String username, String password) throws UserException {
        // TODO Auto-generated method stub
        return null;
    }

    public void modifyUserInfo(User loginUser) throws UserException {
        // TODO Auto-generated method stub
        
    }

    public User findUserByEmail(String email) throws UserException {
        // TODO Auto-generated method stub
        return null;
    }

    public User findUserByUsername(String username) throws UserException {
        // TODO Auto-generated method stub
        return null;
    }
    

}
