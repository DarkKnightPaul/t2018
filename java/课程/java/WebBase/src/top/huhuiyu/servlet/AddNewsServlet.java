package top.huhuiyu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import top.huhuiyu.dao.DaoUtil;
import top.huhuiyu.dao.TbNewsDAO;
import top.huhuiyu.entity.TbNews;

@WebServlet(urlPatterns = "/addnews.servlet", name = "AddNewsServlet")
public class AddNewsServlet extends HttpServlet {

  private static final long serialVersionUID = 8279028449655911876L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    String title = req.getParameter("title");
    String content = req.getParameter("content");

    if (title == null || title.trim().equals("")) {
      resp.getWriter().println("标题必须填写");
      return;
    }
    if (content == null || content.trim().equals("")) {
      resp.getWriter().println("内容必须填写");
      return;
    }
    try {
      SqlSession sqlSession = DaoUtil.getUtil().getSession();
      TbNewsDAO dao = sqlSession.getMapper(TbNewsDAO.class);
      TbNews news = new TbNews();
      news.setTitle(title);
      news.setContent(content);
      dao.add(news);
      resp.getWriter().println(news);
    } catch (Exception e) {
      throw new ServletException(e);
    }

  }
}
