package top.huhuiyu.forum.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DaoUtil {
  private static DaoUtil util = new DaoUtil();
  private SqlSessionFactory factory;

  private DaoUtil() {
    try {
      factory = new SqlSessionFactoryBuilder().build(
          Resources.getResourceAsReader("mybatis-config.xml"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public SqlSession getSession() {
    return factory.openSession(true);
  }

  public static DaoUtil getUtil() {
    return util;
  }

}
