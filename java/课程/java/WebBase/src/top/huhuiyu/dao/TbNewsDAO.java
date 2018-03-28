package top.huhuiyu.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.entity.TbNews;

@Mapper
public interface TbNewsDAO {
  int add(TbNews news) throws Exception;
}
