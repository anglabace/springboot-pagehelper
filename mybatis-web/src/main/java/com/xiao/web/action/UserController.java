package com.xiao.web.action;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.xiao.domain.dto.User;
import com.xiao.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * Created by sunjinwei on 2018/1/4.
 *
 * @author sunjinwei
 * 使用 spring boot 测试访问
 */
@Slf4j
@Api(description = "用户操作")
@Controller
@RequestMapping("userManager")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询所有用户")
    @RequestMapping(value = "/getUserList", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getUserList(@ApiIgnore ModelMap map, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize ) {

        User user = new User();
        PageInfo<User> pageInfo = userService.getUserList(user, pageNum, pageSize);
        pageInfo.getList().stream().forEach(user1 -> System.out.println(user1));

        map.addAttribute("userList", pageInfo.getList());

        //获得当前页
        map.addAttribute("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        map.addAttribute("pageSize", pageInfo.getPageSize());
        //是否是第一页
        map.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        map.addAttribute("totalPages", pageInfo.getPages());
        //是否是最后一页
        map.addAttribute("isLastPage", pageInfo.isIsLastPage());

        return "userList";
    }


    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> addUser(@ApiParam("用户实体") @RequestBody User user) {
        log.info("### addUser input, user:{}", JSONUtil.toJsonStr(user));
        Map<String, Object> resultMap = Maps.newHashMap();

        resultMap.put("user", user);
        resultMap.put("time", DateUtil.now());
        int num = userService.addUser(user);
        resultMap.put("num", num);

        return resultMap;
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> deleteUser(@PathVariable String id) {
        log.info("### deleteUser input, delete id:{}", id);
        Map<String, Object> resultMap = Maps.newHashMap();

        resultMap.put("id", id);
        resultMap.put("time", DateUtil.now());
        int num = userService.deleteUser(Integer.valueOf(id));

        resultMap.put("num", num);
        return resultMap;
    }


    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, Object> updateUser(@ApiParam(value = "用户实体") @RequestBody User user) {
        log.info("### updateUser input, user:{}", JSONUtil.toJsonStr(user));
        Map<String, Object> resultMap = Maps.newHashMap();

        resultMap.put("user", user);
        resultMap.put("time", DateUtil.now());
        int num = userService.updateUser(user);

        resultMap.put("num", num);
        return resultMap;
    }

}
