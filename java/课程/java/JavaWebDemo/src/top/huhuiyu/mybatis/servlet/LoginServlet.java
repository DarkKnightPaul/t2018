package top.huhuiyu.mybatis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import top.huhuiyu.mybatis.dao.DaoUtil;
import top.huhuiyu.mybatis.dao.TbUsersDAO;
import top.huhuiyu.mybatis.entity.TbUsers;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.servlet")
public class LoginServlet extends HttpServlet {

  private static final long serialVersionUID = -4073170142486520632L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      SqlSession sqlSession = DaoUtil.getDaoUtil().getSqlSession();
      TbUsersDAO dao = sqlSession.getMapper(TbUsersDAO.class);
      String username = req.getParameter("username");
      String password = req.getParameter("password");
      TbUsers users = new TbUsers();
      users.setUsername(username);
      users.setPassword(password);
      users = dao.check(users);
      sqlSession.close();
      if (users == null) {
        resp.getWriter().println("用户名或者密码错误,登陆失败.");
      } else {
        resp.getWriter().println(users);
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

}
