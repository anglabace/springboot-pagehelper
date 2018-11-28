package com.xiao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiao.dao.mapper.UserMapper;
import com.xiao.domain.dto.User;
import com.xiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sunjinwei on 2018/11/28.
 *
 * @author sunjinwei
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public PageInfo<User> getUserList(User user, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<User> userList = userMapper.getUserList(user);

        return new PageInfo<>(userList);
    }
}
