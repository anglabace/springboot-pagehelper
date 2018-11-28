package com.xiao.service;

import com.github.pagehelper.PageInfo;
import com.xiao.domain.dto.User;

import java.util.List;

/**
 * Created by sunjinwei on 2018/11/28.
 *
 * @author sunjinwei
 */
public interface UserService {

    /**
     * 添加一个用户
     *
     * @param user
     */
    int addUser(User user);

    /**
     * 删除一个用户
     */
    int deleteUser(Integer id);


    /**
     * 修改用户
     *
     * @param user
     */
    int updateUser(User user);

    /**
     * 查询所有用户列表
     *
     * @param user
     * @return
     */
    PageInfo<User> getUserList(User user, int page, int pageSize);

}
