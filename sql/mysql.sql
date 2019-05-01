create database yf_user;
use yf_user;
create table IF NOT EXISTS t_yf_user(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`phone` VARCHAR(255) DEFAULT null COMMENT '电话',
`type` VARCHAR(255) DEFAULT null COMMENT '用户类型',
`username` VARCHAR(255) DEFAULT null COMMENT '用户名',
`password` VARCHAR(255) DEFAULT null COMMENT '用户密码',
`status` INT(11) not null COMMENT '状态',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='用户主表';


create table IF NOT EXISTS t_yf_authorization(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`type` VARCHAR(255) DEFAULT NULL COMMENT '授权来源类型',
`open_id` VARCHAR(255) not null COMMENT '授权方提供的open_id',
`nick_name` VARCHAR(255) not null COMMENT '昵称，从授权应用获取',
`avatar_url` VARCHAR(255) not null COMMENT '头像url',
`user_id` INT(11) DEFAULT NULL COMMENT 'user_id,没有绑定就为空',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `idx_user_id` (`user_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='授权信息表';





create table IF NOT EXISTS t_yf_level(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`level_name` VARCHAR(255) DEFAULT NULL COMMENT '等级名称',
`remarks` VARCHAR(255) DEFAULT NULL COMMENT '等级备注',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='等级表';



 create table IF NOT EXISTS t_yf_user_level_r(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`user_id` INT(11) DEFAULT NULL COMMENT '会员id',#这一会员所在等级得所有id都得写  比如会员有三个等级 得写三个
`level_id` INT(11) DEFAULT NULL COMMENT '会员等级id',
`deadline_time` DATETIME not null COMMENT '保持会员等级的截止时间，生成订单时产生',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `idx_user_id` (`user_id`),
KEY `idx_level_id` (`level_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='会员和等级关联表';




 create table IF NOT EXISTS t_yf_level_tool__r(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`level_id` INT(11) DEFAULT NULL COMMENT '等级id',
`tool_id` INT(11) DEFAULT NULL COMMENT '工具id',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (`id`),
KEY `idx_level_id` (`level_id`),
KEY `idx_tool_id` (`tool_id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='等级和工具关联表';





create database yf_tool;
use yf_tool;
 create table IF NOT EXISTS t_yf_tool_r(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`tool_name` VARCHAR(255) DEFAULT NULL COMMENT '工具名称',
`tool_description` VARCHAR(255) DEFAULT NULL COMMENT '工具描述',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='工具表';



create database yf_shop;
use yf_shop;

create table IF NOT EXISTS t_yf_province(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`province_name` VARCHAR(255) DEFAULT NULL COMMENT '省名称',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='省表';


create table IF NOT EXISTS t_yf_city(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`parent_id` INT(11) NOT NULL COMMENT '省id',
`city_name` VARCHAR(255) DEFAULT NULL COMMENT '市名称',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
KEY `idx_parent_id` (`parent_id`),
PRIMARY KEY (`id`)

)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='市表';


create table IF NOT EXISTS t_yf_area(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`parent_id` INT(11) NOT NULL COMMENT '市id',
`area_name` VARCHAR(255) DEFAULT NULL COMMENT '区名称',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
KEY `idx_parent_id` (`parent_id`),
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='区表';



create table IF NOT EXISTS t_yf_shop(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`shop_name` VARCHAR(255) DEFAULT NULL COMMENT '门店名称',
`shop_code` VARCHAR(255) DEFAULT NULL COMMENT '门店编码，四位随机数字字母+年月日，不要O0I',
`shop_address` VARCHAR(255) DEFAULT NULL COMMENT '门店地址,省名称-市名称-区名称',
`shop_contact` VARCHAR(255) DEFAULT NULL COMMENT '联系人',
`shop_phone` VARCHAR(255) not null COMMENT '电话',
`shop_spider_code` VARCHAR(255) DEFAULT NULL COMMENT '爬虫编码',
`shop_province_id` INT(11) DEFAULT NULL COMMENT '省id',
`shop_city_id` INT(11) DEFAULT NULL COMMENT '市id',
`shop_area_id` INT(11) DEFAULT NULL COMMENT '区id',
`status` INT(11) not null COMMENT '状态',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='门店主表';


create table IF NOT EXISTS t_yf_shop_platform(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`shop_id` INT(11) DEFAULT NULL COMMENT '门店id',
`type` VARCHAR(255) DEFAULT NULL COMMENT '第三方平台类型',
`shop_account` VARCHAR(255) DEFAULT NULL COMMENT '账户',
`shop_password` VARCHAR(255) DEFAULT NULL COMMENT '账户密码',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
KEY `idx_shop_id` (`shop_id`),
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='门店平台信息表';

create table IF NOT EXISTS t_yf_shop_user_r(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`shop_id` INT(11) DEFAULT NULL COMMENT '门店id',
`user_id` INT(11) DEFAULT NULL COMMENT '会员id',
`shop_code` VARCHAR(255) DEFAULT NULL COMMENT '门店编码，四位随机数字字母+年月日，不要O0I',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
KEY `idx_shop_id` (`shop_id`),
KEY `idx_user_id` (`user_id`),
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='门店会员关联表';


create database yf_order;
use yf_order;
#未完 待续
#客服 mongodb














