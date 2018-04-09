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
import top.huhuiyu.dao.TbUserDAO;
import top.huhuiyu.entity.TbUser;

@WebServlet(urlPatterns = "/json/reg.servlet", name = "RegServlet")
public class RegServlet extends HttpServlet {

  private static final long serialVersionUID = -1052702903058381101L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");

    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String nickname = req.getParameter("nickname");

    JSONObject json = new JSONObject();

    if (username == null || username.trim().equals("")) {
      json.put("error", "用户名必须填写");
      resp.getWriter().println(json.toString());
      return;
    }
    if (password == null || password.trim().equals("")) {
      json.put("error", "密码必须填写");
      resp.getWriter().println(json.toString());
      return;
    }
    if (nickname == null || nickname.trim().equals("")) {
      json.put("error", "昵称必须填写");
      resp.getWriter().println(json.toString());
      return;
    }

    try {
      SqlSession sqlSession = DaoUtil.getUtil().getSession();
      TbUserDAO dao = sqlSession.getMapper(TbUserDAO.class);
      TbUser user = new TbUser();
      user.setUsername(username);
      user.setPassword(password);
      user.setNickname(nickname);
      dao.add(user);
      json.put("message", "注册成功");
      resp.getWriter().println(json.toString());
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
