package top.huhuiyu.forum.servlet.tbuser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

@WebServlet(name = "GetUserServlet", urlPatterns = "/getuser.servlet")
public class GetUserServlet extends HttpServlet {

  private static final long serialVersionUID = 1461672813432932102L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    JSONObject json = new JSONObject();
    json.put("user", req.getSession().getAttribute(LoginServlet.SESSION_USER_KEY));
    resp.getWriter().println(json.toString());
  }
}
