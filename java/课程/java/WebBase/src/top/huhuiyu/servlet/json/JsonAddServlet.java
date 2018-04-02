package top.huhuiyu.servlet.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSONObject;

import top.huhuiyu.dao.DaoUtil;
import top.huhuiyu.dao.TbNewsDAO;
import top.huhuiyu.entity.TbNews;

@WebServlet(urlPatterns = "/json/add.servlet", name = "JsonAddServlet")
public class JsonAddServlet extends HttpServlet {

  private static final long serialVersionUID = -5794075115733377621L;

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
    JSONObject json = new JSONObject();

    if (title == null || title.trim().equals("")) {
      json.put("error", "标题必须填写");
      resp.getWriter().println(json.toString());
      return;
    }
    if (content == null || content.trim().equals("")) {
      json.put("error", "内容必须填写");
      resp.getWriter().println(json.toString());
      return;
    }

    try {
      SqlSession sqlSession = DaoUtil.getUtil().getSession();
      TbNewsDAO dao = sqlSession.getMapper(TbNewsDAO.class);
      TbNews news = new TbNews();
      news.setTitle(title);
      news.setContent(content);
      dao.add(news);
      json.put("message", "添加成功");
      resp.getWriter().println(json.toString());
    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

}
