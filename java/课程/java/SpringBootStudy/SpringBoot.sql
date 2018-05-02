/*SpringBoot.sql*/
use mysql;
drop database if exists SpringBoot;
create database SpringBoot 
  default charset utf8 collate utf8_general_ci;
use SpringBoot;

/*测试Spring服务的相关表*/
create table TbGoods
(
	gid  int auto_increment primary key not null comment '商品编号',
	gname varchar(20) not null comment '商品名称',
	ginfo varchar(500) not null comment '商品描述',
	price decimal(10,2) not null comment '商品价格',
	amount int not null comment '数量',
	sellprice decimal(10,2) not null comment '商品销售价格'
)comment '商品表';

select * from TbGoods;

create table TbVipRecord
(
	vrid int  auto_increment primary key not null comment '消费记录编号',
	vipcard int not null comment 'vip卡号',
	info varchar(50) not null comment '消费记录信息',
	rtype tinyint(1) default -1 not null comment '消费类型，-1为消费，1为充值',
	amount decimal(10,2) not null comment '金额',
	rdate timestamp default now() not null comment '消费日期'
)comment 'vip消费记录表';

select * from TbVipRecord;

create table TbSeller
(
	sid int  auto_increment primary key not null comment '商家编号',
	sname varchar(20) not null comment '商家名称',
	phone varchar(20) not null comment '商家电话',
	qq varchar(20) comment '商家qq',
	url varchar(255) comment '商家网址',
	sinfo varchar(500) comment '商家简介',
	sdata timestamp default now() not null comment '添加日期'
)comment '商家信息记录表';

select * from TbSeller;
