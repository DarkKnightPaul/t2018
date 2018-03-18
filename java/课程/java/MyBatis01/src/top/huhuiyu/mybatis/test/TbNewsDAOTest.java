package top.huhuiyu.mybatis.test;

import java.util.List;
import java.util.Random;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import top.huhuiyu.mybatis.dao.TbNewsDAO;
import top.huhuiyu.mybatis.entity.TbNews;

public class TbNewsDAOTest {

  public static void main(String[] args) throws Exception {
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
        .build(Resources.getResourceAsReader("mybatis-config.xml"));
    SqlSession session = sqlSessionFactory.openSession(true);
    TbNewsDAO dao = session.getMapper(TbNewsDAO.class);
    Random random = new Random();
    System.out.println("添加...............");
    // 添加几笔记录
    for (int i = 0; i < 2; i++) {
      TbNews news = new TbNews();
      news.setTitle("标题" + random.nextInt());
      news.setContent("内容" + random.nextInt());
      dao.add(news);
    }
    System.out.println("添加后查询............");
    // 显示全部数据
    List<TbNews> list = dao.queryAll();
    for (TbNews tbNews : list) {
      System.out.println(tbNews);
    }
    // 修改最后一笔记录
    TbNews news = list.get(list.size() - 1);
    news.setContent("修改内容" + random.nextInt());
    dao.modify(news);
    System.out.println("修改后查询............");
    // 显示全部数据
    list = dao.queryAll();
    for (TbNews tbNews : list) {
      System.out.println(tbNews);
    }
    // 随机删除一笔记录
    System.out.println("删除前的记录数:" + dao.count());
    dao.delete(list.get(random.nextInt(list.size())));
    System.out.println("删除后的记录数:" + dao.count());

    session.close();
  }
}
