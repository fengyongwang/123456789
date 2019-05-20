create database yf_user;
use yf_user;
create table IF NOT EXISTS t_yf_user(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`phone` VARCHAR(255) DEFAULT null COMMENT '电话',
`type` VARCHAR(255) DEFAULT null COMMENT '用户类型',
`user_name` VARCHAR(255) DEFAULT null COMMENT '用户名',
`pass_word` VARCHAR(255) DEFAULT null COMMENT '用户密码',
`status` INT(11) not null COMMENT '状态',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='用户主表';


create database yf_shop;
use yf_shop;

CREATE TABLE IF NOT EXISTS t_yf_region (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `region_name` varchar(50) NOT NULL COMMENT '地区名称',
  `region_short_name` varchar(10) DEFAULT NULL COMMENT '地区缩写',
  `region_code` varchar(20) DEFAULT NULL COMMENT '行政地区编号',
  `region_parent_id` int(10) DEFAULT NULL COMMENT '地区父id',
  `region_level` int(2) DEFAULT NULL COMMENT '地区级别 1-省、自治区、直辖市 2-地级市、地区、自治州、盟 3-市辖区、县级市、县',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`status` INT(11) not null COMMENT '状态',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
  KEY `idx_region_parent_id` (`region_parent_id`),
  KEY `idx_region_level` (`region_level`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地区表';



create table IF NOT EXISTS t_yf_shop_user(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`user_id` INT(11) DEFAULT NULL COMMENT '会员id',
`total_commodity_id` INT(11) DEFAULT NULL COMMENT '主营商品分类id',
`shop_name` VARCHAR(255) DEFAULT NULL COMMENT '商铺名称',
`shop_code` VARCHAR(255) DEFAULT NULL COMMENT '商铺编码，四位随机数字字母+年月日，不要O0I',
`shop_address` VARCHAR(255) DEFAULT NULL COMMENT '商铺地址,省名称-市名称-区名称-***',
`shop_contact` VARCHAR(255) DEFAULT NULL COMMENT '联系人',
`shop_phone` VARCHAR(255) not null COMMENT '电话',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`status` INT(11) not null COMMENT '状态',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
KEY `idx_user_id` (`user_id`),
KEY `idx_total_commodity_id` (`total_commodity_id`),
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='商铺会员关联表';





create table IF NOT EXISTS t_yf_total_commodity(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`commodity_type_name` VARCHAR(255) DEFAULT NULL COMMENT '商品分类名称',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`status` INT(11) not null COMMENT '状态',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';







create table IF NOT EXISTS t_yf_shop_commodity(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`shop_id` INT(11) DEFAULT NULL COMMENT '商铺id',
`total_commodity_id` INT(11) DEFAULT NULL COMMENT '商品分类id，即商品表的主键id',
`commodity_name` VARCHAR(255) DEFAULT NULL COMMENT '商品具体名称',
`unit_price` DOUBLE(20,2) NULL COMMENT '单价',
`stock` INT(20)  NULL COMMENT '库存',
`month_sale_number` INT(20) DEFAULT 0 COMMENT '每月售量',
`month_sale_price` DOUBLE(20,2)  DEFAULT 0 COMMENT '每月售量总价',
`total_sale_number` INT(20)  DEFAULT 0 COMMENT '总售量',
`total_sale_price` DOUBLE(30,2)  DEFAULT 0 COMMENT '售量总价',
`image_url` VARCHAR(255) DEFAULT NULL COMMENT '商品图片',
`commodity_description` VARCHAR(255) DEFAULT NULL COMMENT '商品描述',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`status` INT(11) not null COMMENT '状态',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
KEY `idx_shop_id` (`shop_id`),
KEY `idx_total_commodity_id` (`total_commodity_id`),
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='商铺商品关联表';



create database yf_order;
use yf_order;
create table IF NOT EXISTS t_yf_order(
`id` INT(11) NOT NULL AUTO_INCREMENT,
`user_id` INT(11) DEFAULT NULL COMMENT '顾客id',
`shop_id` INT(11) DEFAULT NULL COMMENT '商铺id',
`commodity_id` INT(11) DEFAULT NULL COMMENT '商品id',
`commodity_name` VARCHAR(255) DEFAULT NULL COMMENT '商品具体名称',
`unique_id` VARCHAR(255) DEFAULT NULL COMMENT '订单号',
`original_price` DOUBLE(20,2) NULL COMMENT '原价',
`current_price` DOUBLE(20,2)  NULL COMMENT '实付金额',
`order_status` VARCHAR(255) DEFAULT NULL COMMENT '订单状态：未付款，已付款，已发货，接物流信息，',
`last_modify_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
`create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`status` INT(11) not null COMMENT '状态',
`modify_by` VARCHAR(255) DEFAULT NULL,
`create_by` VARCHAR(255) DEFAULT NULL,
KEY `idx_shop_id` (`shop_id`),
KEY `idx_user_id` (`user_id`),
KEY `idx_commodity_id` (`commodity_id`),
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';


#未完 待续
#客服 mongodb














