/*Forum.sql*/
use mysql;
drop database if exists Forum;
create database Forum 
  default charset utf8 collate utf8_general_ci;
use Forum;

create table TbUser
(
  uid int auto_increment primary key not null
    comment '用户编号',
  username varchar(20) unique not null
    comment '用户登录名称',
  password varchar(20) not null
    comment '用户登录密码',
  nickname varchar(200) not null
    comment '用户昵称',
  isEnable enum('y','n') default 'y' not null
    comment '账户是否启用，y:启用，n：禁用,默认为y',
  isAdmin enum('y','n') default 'n' not null
    comment '是否为管理员账户,y:是，n:否,默认为n',
  regDate timestamp default now() not null
    comment '用户注册时间'
)comment '用户表';

/*默认帐号*/
insert into TbUser(username,password,nickname)
  values('user','pwduser','默认用户');
insert into TbUser(username,password,nickname,isAdmin)
  values('admin','pwdadmin','默认管理员','y');

select * from TbUser;

create table TbType
(
  tid int auto_increment primary key not null
    comment '分类编号',
  typename varchar(50) unique not null
    comment '分类名称',
  typeinfo varchar(500) not null
    comment '分类描述',
  isEnable enum('y','n') default 'y' not null
    comment '是否启用,y:启用,n:停用,默认y',
  created timestamp default now()
    comment '创建时间'
)comment '帖子分类';

select * from TbType;

create table TbSubject
(
  sid int auto_increment primary key not null
    comment '主题编号',
  sname varchar(20) unique not null
    comment '主题名称',
  sinfo varchar(200) not null
    comment '主题描述',
  tid int not null comment '所属分类',
  created timestamp default now() not null
    comment '创建时间'
)comment '主题表';

select * from TbSubject;

create table TbInfo
(
  iid int auto_increment primary key not null
    comment '信息编号',
  title varchar(50) not null 
    comment '信息标题', 
  content varchar(500) not null
    comment '信息内容',
  created timestamp default now() not null
    comment '发帖时间',
  isDelete enum('y','n') default 'n' not null
    comment '帖子是否已经删除，y:删除,n:未删除,默认n',
  uid int not null comment '发帖人',
  sid int not null comment '所属主题'
)comment '发帖信息';

select * from TbInfo;

create table TbRetruns
(
  rid int auto_increment primary key not null
    comment '回帖编号',
  content varchar(200) not null
    comment '回帖内容',
  created timestamp default now() not null
    comment '回帖时间',
  iid int not null comment '回复的帖子编号',
  uid int not null comment '回帖人'
)comment '回帖表';

select * from TbRetruns;

/*测试Servlet服务器的相关表*/
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




