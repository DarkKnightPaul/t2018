package top.huhuiyu.mybatis;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.alibaba.fastjson.JSONObject;

import top.huhuiyu.mybatis.dao.TbUsersDAO;
import top.huhuiyu.mybatis.entity.TbUsers;

public class Test {

  public static void main(String[] args) throws Exception {
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
        .build(Resources.getResourceAsReader("mybatis-config.xml"));
    SqlSession session = sqlSessionFactory.openSession();
    TbUsersDAO dao = session.getMapper(TbUsersDAO.class);
    TbUsers users = new TbUsers();
    Random random = new Random();
    users.setUsername("test" + random.nextInt());
    users.setPassword("test123");
    users.setNickname("昵称" + random.nextInt());
    users.setPhone(random.nextInt() + "");
    dao.add(users);
    System.out.println(users);
    List<TbUsers> list = dao.queryAll();
    System.out.println(list);
    System.out.println(JSONObject.toJSON(list));
    session.close();
  }
}
