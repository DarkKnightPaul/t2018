package top.huhuiyu.forum.test;

import org.apache.ibatis.session.SqlSession;

import top.huhuiyu.forum.dao.TbUserDAO;
import top.huhuiyu.forum.entity.TbUser;
import top.huhuiyu.forum.dao.DaoUtil;

public class TestTbUserDAO {
  public static void main(String[] args) throws Exception {
    SqlSession sqlSession = DaoUtil.getUtil().getSession();
    TbUserDAO dao = sqlSession.getMapper(TbUserDAO.class);
    System.out.println("====================================");
    TbUser user = new TbUser();
    user.setUsername("user");
    user.setPassword("pwduser");
    user = dao.login(user);
    System.out.println(user);
    System.out.println("====================================");
    user = new TbUser();
    user.setUsername("admin");
    user.setPassword("pwdadmin");
    user = dao.login(user);
    System.out.println(user);
    sqlSession.close();
  }
}
