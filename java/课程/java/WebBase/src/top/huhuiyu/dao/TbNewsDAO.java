package top.huhuiyu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.entity.TbNews;

@Mapper
public interface TbNewsDAO {
  int add(TbNews news) throws Exception;
  
  List<TbNews> queryAll() throws Exception;
}
