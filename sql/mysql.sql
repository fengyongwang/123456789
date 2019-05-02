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


create table IF NOT EXISTS t_yf_shop_user(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`user_id` INT(11) DEFAULT NULL COMMENT '会员id',
`shop_name` VARCHAR(255) DEFAULT NULL COMMENT '商铺名称',
`shop_code` VARCHAR(255) DEFAULT NULL COMMENT '商铺编码，四位随机数字字母+年月日，不要O0I',
`shop_address` VARCHAR(255) DEFAULT NULL COMMENT '商铺地址,省名称-市名称-区名称',
`shop_contact` VARCHAR(255) DEFAULT NULL COMMENT '联系人',
`shop_phone` VARCHAR(255) not null COMMENT '电话',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`status` INT(11) not null COMMENT '状态',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
KEY `idx_user_id` (`user_id`),
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='商铺会员关联表';


create table IF NOT EXISTS t_yf_shop_commodity(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`shop_id` INT(11) DEFAULT NULL COMMENT '商铺id',
`shop_code` VARCHAR(255) DEFAULT NULL COMMENT '商铺编码，四位随机数字字母+年月日，不要O0I',
`unit_price` DOUBLE(20,2) NULL COMMENT '单价',
`stock` INT(20)  NULL COMMENT '库存',
`image_url` VARCHAR(255) DEFAULT NULL COMMENT '商品图片',
`commodity_description` VARCHAR(255) DEFAULT NULL COMMENT '商品描述',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`status` INT(11) not null COMMENT '状态',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
KEY `idx_shop_id` (`shop_id`),
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='商铺商品关联表';



create database yf_order;
use yf_order;
#未完 待续
#客服 mongodb














