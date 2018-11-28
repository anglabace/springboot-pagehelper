package com.xiao.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by sunjinwei on 2018/11/28.
 *
 * @author sunjinwei
 */
@Data
@ApiModel(description = "用户实体")
public class User {

    @ApiModelProperty(value = "主键自增", hidden = true)
    private int id;

    @ApiModelProperty(value = "用户姓名", example = "张三")
    private String userName;

    @ApiModelProperty(value = "地址", example = "北京")
    private String addr;

    @ApiModelProperty(value = "生日", example = "1988-01-01")
    private Date birthDay;

    @ApiModelProperty(value = "性别(1男, 0女)", example = "1", allowableValues = "1, 0")
    private Integer sex;

    @ApiModelProperty(value = "更新时间", example = "1988-12-31")
    private Date updateDate;

}
