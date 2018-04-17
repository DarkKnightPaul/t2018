package top.huhuiyu.forum.servlet.tbuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSONObject;

import top.huhuiyu.forum.dao.DaoUtil;
import top.huhuiyu.forum.dao.TbUserDAO;
import top.huhuiyu.forum.entity.TbUser;

@WebServlet(name = "LoginServlet", urlPatterns = "/login.servlet")
public class LoginServlet extends HttpServlet {

  private static final long serialVersionUID = -1080164854791559616L;
  public static final String SESSION_USER_KEY = "login_user";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    JSONObject json = new JSONObject();
    try {
      String username = req.getParameter("username");
      String password = req.getParameter("password");
      TbUser user = new TbUser();
      user.setUsername(username);
      user.setPassword(password);
      SqlSession sqlSession = DaoUtil.getUtil().getSession();
      TbUserDAO dao = sqlSession.getMapper(TbUserDAO.class);
      user = dao.login(user);
      sqlSession.close();
      if (user == null) {
        json.put("error", "用户名或者密码错误，登录失败");
      } else {
        user.setPassword("*******");//去掉密码
        // 放置用户信息到Session中
        req.getSession().setAttribute(SESSION_USER_KEY, user);
        json.put("user", user);
      }
    } catch (Exception ex) {
      json.put("eror", ex.getMessage());
    }
    resp.getWriter().println(json.toString());
  }

}
