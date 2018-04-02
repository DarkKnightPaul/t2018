package top.huhuiyu.servlet.json;

import java.io.IOException;
import java.util.List;

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

@WebServlet(urlPatterns = "/json/query.servlet", name = "JsonQueryServlet")
public class JsonQueryServlet extends HttpServlet{

  private static final long serialVersionUID = -6143625063129762287L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   doPost(req, resp);
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    
    try {
      SqlSession sqlSession = DaoUtil.getUtil().getSession();
      TbNewsDAO dao = sqlSession.getMapper(TbNewsDAO.class);
      List<TbNews> list=dao.queryAll();
      //转换成json数据
      JSONObject json=new JSONObject();
      json.put("list", list);
      resp.getWriter().println(json.toString());
    } catch (Exception e) {
      throw new ServletException(e);
    }
    
  }
  
}
