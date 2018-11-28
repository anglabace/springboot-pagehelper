# springboot-pagehelper
使用springboot+mybatis+pageHelper实现分页


# 创建库表
create database demo 
CHARACTER   SET   'utf8'
COLLATE   'utf8_general_ci';


use demo;

CREATE TABLE IF NOT EXISTS `t_user`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `user_name` VARCHAR(10) NOT NULL,
   `sex` int ,
   `addr` VARCHAR(10),
   `birth_day` DATE ,
   `update_date` TIMESTAMP ,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

