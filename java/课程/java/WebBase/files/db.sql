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
