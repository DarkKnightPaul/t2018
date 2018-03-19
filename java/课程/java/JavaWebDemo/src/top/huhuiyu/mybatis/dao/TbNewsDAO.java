package top.huhuiyu.mybatis.dao;

import java.util.List;

import top.huhuiyu.mybatis.entity.TbNews;

public interface TbNewsDAO {
  List<TbNews> queryAll() throws Exception;

  int add(TbNews news) throws Exception;

  int delete(TbNews news) throws Exception;

  int modify(TbNews news) throws Exception;

  int count() throws Exception;
}
