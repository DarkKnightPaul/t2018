package top.huhuiyu.forum.dao;

import org.apache.ibatis.annotations.Mapper;

import top.huhuiyu.forum.entity.TbUser;

/**
 * TbUser表的数据操作类
 * 
 * @author huhuiyu
 *
 */
@Mapper
public interface TbUserDAO {

  /**
   * 添加一个普通用户信息
   * 
   * @param user
   *          用户信息
   * @return 数据库影响行数
   * @throws Exception
   */
  int add(TbUser user) throws Exception;

  /**
   * 校验普通用户登录信息
   * 
   * @param user
   *          登录用户信息
   * @return 信息正确返回用户详细信息,否则返回null
   * @throws Exception
   */
  TbUser login(TbUser user) throws Exception;
}
