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
            String emailMsg = "注册成功,请<a href = 'http://localhost:8080/bookstore/user/activeUser.do?activeCode="+newUser.getActivecode()+"'>激活</a>后登录";
            SendJMail.sendMail(newUser.getEmail(), emailMsg );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void activerUser(String activeCode) throws UserException {
        try {
            User user = userMapper.findUserByActiveCode(activeCode);
            if(user != null)
                userMapper.activeUser(user.getId());
            else 
                throw new UserException("用户激活失败");
        } catch (SQLException e) {
            throw new UserException("用户激活失败");
        }
        
    }

    public User login(User user) throws UserException {
        User loginUser = null;
        try {
            loginUser = userMapper.findUserByUserNameAndPassword(user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return loginUser;
    }

    public void modifyUserInfo(User loginUser) throws UserException {
        // TODO Auto-generated method stub
        
    }

    public User findUserByEmail(String email) throws UserException {
        User user = null;
        try {
            user = userMapper.findUserByEmail(email);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    public User findUserByUsername(String username) throws UserException {
        User user = null;
        try {
            user = userMapper.findUserByUsername(username);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }
    

}
