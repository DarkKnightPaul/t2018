use MyDB;

/*日期函数*/
select curdate();
select curtime();
select now();
/*时间戳*/
select unix_timestamp();
select unix_timestamp('2017-10-11 12:34:56');
select from_unixtime(unix_timestamp());
/*截取时间*/
select year(now()),month(now()),day(now());
select hour(now()),minute(now()),second(now());
/*格式化*/
select date_format(now(),'%Y年%m月%d日 %H:%i:%s');
/*日期计算*/
select date_add(now(),interval 31 day);
select date_add(now(),interval -10 hour);
select timestampdiff(year,now(),'2019-10-1');
select timestampdiff(month,now(),'2019-10-1');
select timestampdiff(day,now(),'2019-10-1');
select timestampdiff(hour,now(),'2019-10-1');
select timestampdiff(month,now(),'2019-10-1');
select timestampdiff(day,now(),'2019-10-1');


insert into TbDept(deptName,deptInfo,createDate)
  values('办公室','创始部门','2010-10-10');
select deptName
  ,date_format(createDate,'%Y年%m月%d日 %H:%i:%s')
  ,timestampdiff(year,createDate,now())
from TbDept;

/*字符串函数*/
select concat(deptId,'-',deptName) from TbDept;
select concat_ws('-',deptId,deptName,deptInfo) from TbDept;

select empName,substr(empName,1,1) from TbEmployee;
select empName,length(empName),char_length(empName) from TbEmployee;
select empName,replace(empName,'测试','姓名') from TbEmployee;

