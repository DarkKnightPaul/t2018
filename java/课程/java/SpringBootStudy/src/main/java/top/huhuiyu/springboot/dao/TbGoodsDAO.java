package top.huhuiyu.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.springboot.entity.TbGoods;

@Mapper
public interface TbGoodsDAO {
  int add(TbGoods goods) throws Exception;

  List<TbGoods> query() throws Exception;

  int delete(TbGoods goods) throws Exception;

  TbGoods queryByKey(TbGoods goods) throws Exception;

  int modify(TbGoods goods) throws Exception;

}
