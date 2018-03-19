package top.huhuiyu.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DaoUtil {
  private static DaoUtil daoUtil = new DaoUtil();
  private SqlSessionFactory sqlSessionFactory;

  private DaoUtil() {
    try {
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public SqlSession getSqlSession() {
    return sqlSessionFactory.openSession(true);
  }

  public static DaoUtil getDaoUtil() {
    return daoUtil;
  }

}
