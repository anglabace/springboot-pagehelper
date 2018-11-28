package com.xiao.dao.mapper;

import com.xiao.domain.dto.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by sunjinwei on 2018/11/28.
 *
 * @author sunjinwei
 */
public interface UserMapper {

    /**
     * 添加一个用户
     *
     * @param user
     */
    @Insert("insert into t_user (id, user_name, addr, birth_Day, sex) values (#{id}, #{userName}, #{addr}, #{birthDay}, #{sex})")
    int addUser(User user);

    /**
     * 删除一个用户
     */
    @Delete("delete from t_user where id= #{id}")
    int deleteUser(Integer id);


    /**
     * 修改用户
     *
     * @param user
     */
    @Update("update t_user set user_name=#{userName}, addr=#{addr}, update_Date=#{updateDate} where id=#{id}")
    int updateUser(User user);

    /**
     * 查询所有用户列表
     *
     * @param user
     * @return
     */
    List<User> getUserList(User user);

}
