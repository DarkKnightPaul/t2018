use MyDB;

/*别名称*/
select d.deptId '编号',d.deptName as '名称' from TbDept d;

select e.empId '员工编号',d.deptName '所属部门',
  case e.sex when 'm' then '男'
   when 'f' then '女' else '未知' end '性别',
  e.salary '工资'
from TbEmployee e 
inner join TbDept d on e.deptId=d.deptId;

/*限制查询数量*/
select * from TbEmployee limit 2;

select * from TbEmployee limit 2,2;

/*查询排序*/
select * from TbEmployee order by sex,salary desc;

/*聚合查询*/
select max(salary) from TbEmployee;
select min(salary) from TbEmployee;
select avg(salary) from TbEmployee;
select sum(salary) from TbEmployee;
select count(*) from TbEmployee;

/*分组聚合,如果select的列中出现聚合函数,非聚合的列必须在group by中*/
select sex,sum(salary) from TbEmployee
group by sex;

select deptId,avg(salary) from TbEmployee
group by deptId;

select sex from TbEmployee
group by sex;

select distinct sex from TbEmployee;


