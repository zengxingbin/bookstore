package com.dao;

import com.domain.User;
import com.domain.UserExample;

import java.sql.SQLException;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 添加新用户
     * @param newUser
     * @throws SQLException
     */
    void addUser(User newUser) throws SQLException;

    /**
     * 通过激活码查找用户
     * @param activeCode
     * @return
     * @throws SQLException
     */
    User findUserByActiveCode(String activeCode) throws SQLException;

    /**
     * 激活用户
     * @param id
     * @throws SQLException
     */
    void activeUser(int id) throws SQLException;

    /**
     * 通过用户名和密码查找用户
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    User findUserByUserNameAndPassword(@Param("username")String username, @Param("password")String password) throws SQLException;

    /**
     * 修改用户信息
     * @throws SQLException
     */
    void modifyUserInfo(User loginUser) throws SQLException;

    /**
     * 通过邮箱查找用户
     * @param email
     * @return
     * @throws SQLException
     */
    User findUserByEmail(String email) throws SQLException;

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     * @throws SQLException
     */
    User findUserByUsername(String username) throws SQLException;
}