/*切换当前使用的数据库为mysql(管理数据库)*/ 
use mysql;

/*如果数据库MyDB存在就删除*/
drop database if exists MyDB;

/*创建数据库MyDB,default charset utf8指定数据库默认编码为utf-8,collate utf8_general_ci表示指定默认字符排序规则也是utf-8*/
create database MyDB default charset utf8 collate utf8_general_ci;

use MyDB;

/*创建部门表*/
create table TbDept
(
  deptId int auto_increment primary key not null comment 'auto_increment表示自动增长,primary key主键,not null非空',
  deptName varchar(50) unique not null comment 'unique唯一约束',
  deptInfo varchar(200),
  createDate timestamp default now() not null
);

/*创建员工表*/
create table TbEmployee
(
  empId int auto_increment primary key not null,
  empName varchar(50) not null,
  password varchar(20) not null,
  sex enum('m','f') not null comment 'enmu取值范围',
  salary decimal(10,2) not null,
  deptId int not null,
  foreign key(deptId) references TbDept(deptId) /*foreign key外键,必须是references后面指定列的数据*/  
);

/*添加数据*/
insert into TbDept(deptName,deptInfo) values('人事部','人员管理');
insert into TbDept(deptName,deptInfo) values('销售部','推销东西');

insert into TbEmployee(empName,password,sex,salary,deptId) values('张三','abc123','m',1230.4,1);
insert into TbEmployee(empName,password,sex,salary,deptId) values('李四','123456','m',2901.45,2);
insert into TbEmployee(empName,password,sex,salary,deptId) values('Lisa','123456','f',1888.456,1);
insert into TbEmployee(empName,password,sex,salary,deptId) values('test','test123','f',10000,2);
insert into TbEmployee(empName,password,sex,salary,deptId) values('李龙','abc-123','m',6789.12,2);
insert into TbEmployee(empName,password,sex,salary,deptId) values('Mary','111111','m',5012,2);

/*基本查询*/
select * from TbDept;
select * from TbEmployee;

/*简单的联合查询*/
select e.*,d.* from TbEmployee e
inner join TbDept d on e.deptId=d.deptId;

/*修改数据*/
update TbEmployee set password='modi',sex='f' where empId=4;

/*删除数据*/
delete from TbEmployee where empId=4;