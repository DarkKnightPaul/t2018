use mysql;
drop database if exists WebBase;
create database WebBase 
  default charset utf8 collate utf8_general_ci;
use WebBase;

create table TbNews
(
  nid int auto_increment primary key not null
    comment '新闻编号',
  title varchar(20) not null
    comment '新闻标题',
  content varchar(500) not null
    comment '新闻内容',  
  created timestamp default now() not null
    comment '发帖时间'
)comment '发帖表';

select * from TbNews;

create table TbUser
(
	uid int auto_increment primary key not null comment '用户编号',
	username varchar(20) unique not null comment '登录名',
	password varchar(20) not null comment '登录密码',
	nickname varchar(50) not null comment '用户昵称',
	isEnable enum('y','n') default 'y' not null comment '是否启用',
	regDate  timestamp default now() not null comment '注册时间'
)comment '登录用户信息表';

/*默认账号*/
insert into TbUser(username,password,nickname) values('admin','adminpwd','默认账号');

select * from TbUser;
