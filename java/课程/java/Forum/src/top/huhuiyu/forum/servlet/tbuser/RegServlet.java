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

@WebServlet(name = "RegServlet", urlPatterns = "/reg.servlet")
public class RegServlet extends HttpServlet {

  private static final long serialVersionUID = -5067903025640036107L;

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
      String nickname = req.getParameter("nickname");
      TbUser user = new TbUser();
      user.setUsername(username);
      user.setPassword(password);
      user.setNickname(nickname);

      SqlSession sqlSession = DaoUtil.getUtil().getSession();
      TbUserDAO dao = sqlSession.getMapper(TbUserDAO.class);
      dao.add(user);
      sqlSession.close();
      json.put("message", "注册成功");

    } catch (Exception ex) {
      json.put("error", ex.getMessage());
    }
    resp.getWriter().println(json.toString());

  }

}
