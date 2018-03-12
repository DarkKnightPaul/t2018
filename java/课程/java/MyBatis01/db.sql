/*创建数据库*/
use mysql;
drop database if exists mybatis;
create database mybatis default charset utf8 collate utf8_general_ci;
use mybatis;
/*创建数据表*/
create table TbUsers
(
  uid int auto_increment primary key not null comment '用户编号,主键',
  username varchar(50) unique not null comment '登陆名称,不可以有同名的',
  password varchar(20) not null  comment '登陆密码',
  nickname varchar(100) not null comment '用户昵称',
  phone varchar(50) not null comment '用户联系电话',
  regDate timestamp default now() not null comment '用户注册时间'
);

/*默认内置用户*/
insert into TbUsers(username,password,nickname,phone) values('admin','adm-123','内置用户','1234567890');

select * from TbUsers;
