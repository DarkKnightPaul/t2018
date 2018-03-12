package top.huhuiyu.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.mybatis.entity.TbUsers;

@Mapper
public interface TbUsersDAO {
  List<TbUsers> queryAll() throws Exception;

  int add(TbUsers users) throws Exception;
}
