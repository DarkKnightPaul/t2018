package top.huhuiyu.forum.servlet.tbuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout.servlet")
public class LogoutServlet extends HttpServlet {

  private static final long serialVersionUID = 7372327555945806632L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    JSONObject json = new JSONObject();
    req.getSession().removeAttribute(LoginServlet.SESSION_USER_KEY);
    json.put("message", "安全退出成功。");
    resp.getWriter().println(json.toString());
  }

}
