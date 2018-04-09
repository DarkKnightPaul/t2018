package top.huhuiyu.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.entity.TbUser;

@Mapper
public interface TbUserDAO {

  public int add(TbUser user) throws Exception;

  public TbUser login(TbUser user) throws Exception;

}
