use mysql;

drop database if exists TbStudentManager;

/*创建学生管理数据库*/
create database TbStudentManager default charset utf8 collate utf8_general_ci;

use TbStudentManager;

/*创建学生信息表*/
create table TbStudent
(
  /*学号*/
  sid int auto_increment primary key not null,
  /*姓名*/
  sname char(20) unique not null,
  /*性别*/
  sex enum('男','女'),
  /*出生日期*/
  birthday timestamp
);

/*创建科目表*/
create table TbSubject
(
  /*科目号*/
  sid char(10) primary key not null,
  /*科目姓名*/
  sname varchar(50) unique not null
);


/*创建成绩表*/
create table TbScore
(
  /*学生学号*/
  sid int not null,
  /*科目号*/
  subid char(10) not null,
  /*成绩*/
  TbScore decimal(5,2) default 0
);


/*插入记录*/
insert into TbStudent(sname,sex,birthday) values('张三','男','1983-01-01');
insert into TbStudent(sname,sex,birthday) values('李四','女','1984-02-01');
insert into TbStudent(sname,sex,birthday) values('王五','男','1985-01-01');
insert into TbStudent(sname,sex,birthday) values('赵勇','男','1983-03-01');
insert into TbStudent(sname,sex,birthday) values('张丽','女','1984-01-03');
insert into TbStudent(sname,sex,birthday) values('姚芳','女','1985-06-07');
insert into TbStudent(sname,sex,birthday) values('谢慧梅','女','1982-12-07');
insert into TbStudent(sname,sex,birthday) values('成文明','男','1983-10-09');
insert into TbStudent(sname,sex,birthday) values('张科望','男','1986-1-09');


insert into TbSubject(sid,sname) values('1_001','计算机基础');
insert into TbSubject(sid,sname) values('1_002','Office入门');
insert into TbSubject(sid,sname) values('1_003','WindowsXP操作系统');
insert into TbSubject(sid,sname) values('2_001','HTML');
insert into TbSubject(sid,sname) values('2_002','C编程语言基础');
insert into TbSubject(sid,sname) values('2_003','C#高级面向对象编程语言');
insert into TbSubject(sid,sname) values('2_004','C# Windows Form程序开发');
insert into TbSubject(sid,sname) values('2_005','SQL Server 2000数据库系统');
insert into TbSubject(sid,sname) values('3_001','java程序开发基础');
insert into TbSubject(sid,sname) values('3_002','java awt,swing界面开发');
insert into TbSubject(sid,sname) values('3_003','Servlet,jsp动态网页开发');


insert into TbScore(sid,subid,TbScore) values (1,'1_001',87);
insert into TbScore(sid,subid,TbScore) values (1,'1_002',73);
insert into TbScore(sid,subid,TbScore) values (1,'1_003',97);
insert into TbScore(sid,subid,TbScore) values (1,'2_001',83);
insert into TbScore(sid,subid,TbScore) values (1,'2_002',66);
insert into TbScore(sid,subid,TbScore) values (1,'2_003',62);
insert into TbScore(sid,subid,TbScore) values (1,'2_004',99);
insert into TbScore(sid,subid,TbScore) values (1,'2_005',73);


insert into TbScore(sid,subid,TbScore) values (2,'1_001',87);
insert into TbScore(sid,subid,TbScore) values (2,'1_002',72);
insert into TbScore(sid,subid,TbScore) values (2,'1_003',76);
insert into TbScore(sid,subid,TbScore) values (2,'2_001',76);
insert into TbScore(sid,subid,TbScore) values (2,'2_002',89);
insert into TbScore(sid,subid,TbScore) values (2,'2_003',76);
insert into TbScore(sid,subid,TbScore) values (2,'2_004',87);
insert into TbScore(sid,subid,TbScore) values (2,'2_005',78);


insert into TbScore(sid,subid,TbScore) values (3,'1_001',88);
insert into TbScore(sid,subid,TbScore) values (3,'1_003',62);
insert into TbScore(sid,subid,TbScore) values (3,'2_001',78);
insert into TbScore(sid,subid,TbScore) values (3,'2_002',87);
insert into TbScore(sid,subid,TbScore) values (3,'2_003',76);
insert into TbScore(sid,subid,TbScore) values (3,'2_005',89);


insert into TbScore(sid,subid,TbScore) values (4,'1_002',72);
insert into TbScore(sid,subid,TbScore) values (4,'1_003',76);
insert into TbScore(sid,subid,TbScore) values (4,'2_002',89);
insert into TbScore(sid,subid,TbScore) values (4,'2_003',76);
insert into TbScore(sid,subid,TbScore) values (4,'2_004',87);


insert into TbScore(sid,subid,TbScore) values (5,'1_001',94);
insert into TbScore(sid,subid,TbScore) values (5,'1_002',76);
insert into TbScore(sid,subid,TbScore) values (5,'1_003',87);

insert into TbScore(sid,subid,TbScore) values (6,'1_001',80);
insert into TbScore(sid,subid,TbScore) values (6,'1_002',83);
insert into TbScore(sid,subid,TbScore) values (6,'1_003',99);

insert into TbScore(sid,subid,TbScore) values (7,'2_001',83);
insert into TbScore(sid,subid,TbScore) values (7,'2_002',97);
insert into TbScore(sid,subid,TbScore) values (7,'2_003',90);
insert into TbScore(sid,subid,TbScore) values (7,'2_004',90);
insert into TbScore(sid,subid,TbScore) values (7,'2_005',78);

insert into TbScore(sid,subid,TbScore) values (8,'2_001',70);
insert into TbScore(sid,subid,TbScore) values (8,'2_002',75);
insert into TbScore(sid,subid,TbScore) values (8,'2_003',78);
insert into TbScore(sid,subid,TbScore) values (8,'2_004',90);
insert into TbScore(sid,subid,TbScore) values (8,'2_005',88);

select * from TbStudent;
select * from TbSubject;
select * from TbScore;

select sc.*,su.*,st.* from TbScore sc
inner join TbSubject su on sc.subid=su.sid
inner join TbStudent st on sc.sid=st.sid;

/*
--建立课程备份表TbSubject_Bak(和TbSubject表结构一致,但是要求去掉所有约束),使用语句将TbSubject的所有数据复制到TbSubject_Bak表

--删除所有3开头的课程

--查询学生姓名,性别,出生年月

--查询所有男生信息(学号,姓名,出生年月)

--查询所有姓张的学生(姓名,性别,出生年月)

--查询出生日期大于或等于1984年的女生(姓名,性别,出生年月)

--查询出生日期在1983到1985之间的男生(姓名,性别,出生年月)

--查询出生在1983,1985,1986年的所有学生(姓名,性别,出生年月)

--查询学生信息,包括,姓名,性别,年龄

--查询学生信息,将学号,姓名,性别,出生日期组合在一起,格式为 学号_姓名(性别) 同时要求姓名信息不能有空格

--查询学生信息,将姓名,出生年月显示出来,但是要求出生年月的格式为 yyyy年m月

--查询考试成绩表(学号,学生姓名,科目号,考试科目名称,成绩)

--查询还没有参加过考试的学生信息(学号,姓名)

--查询参加过2_003科目考试的学生信息(学号,姓名)

--查询参加过2开头科目考试的女学生信息(学号,姓名)

--分组统计男女生数量

--按照出生年份分组统计学生数量

--按照出生年份分组统计学生数量,但是只要男生的数量

--按照科目分组统计学生人数,但是只要2开头的科目

--按科目统计最高分

--按科目统计最低分

--按科目统计平均分

--按科目统计平均分,并显示科目名称

--查找所有2_005号课程成绩比1的学生高的学生信息(只要显示学号和姓名)

--查询考试成绩,显示科目编号,学生姓名,和成绩,并且按照科目编号,学生编号排序

--查询考试成绩,显示学生姓名,科目编号,和成绩,并且按照学生编号,科目编号排序

--查询'1_001'科目的考试成绩,显示科目编号,学生姓名,和成绩,并且按照成绩降序排序

--统计学生考试成绩的总分

--按照科目统计学生考试成绩的总分

--查询考试人数最多的科目信息（科目编号和科目名称）没有学习子查询表不能做！

--查询学生名称中包含C#的课程的考试成绩

--显示课程名称，课程考试的最高分，课程考试的最低分，课程考试的平均分

--要求一个课程只要显示一次,平均分只要两位小数，最高分和最低分都不要小数

--查询前五个学生参加考试的科目数量,要求显示学生姓名和科目数量

--查询年龄最大的学生，和年龄最小的学生。显示学生姓名和出生年月

--查询男同学的所有1开头的课程成绩,以及女同学的所有2开头的课程成绩 (显示姓名，性别,课程号，成绩)
*/







