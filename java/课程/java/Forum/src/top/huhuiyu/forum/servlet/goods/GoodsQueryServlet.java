package top.huhuiyu.forum.servlet.goods;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.alibaba.fastjson.JSONObject;

import top.huhuiyu.forum.dao.DaoUtil;
import top.huhuiyu.forum.dao.TbGoodsDAO;

@WebServlet(name = "GoodsQueryServlet", urlPatterns = "/goods/query.servlet")
public class GoodsQueryServlet extends HttpServlet {

  private static final long serialVersionUID = 6761338437462862342L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    JSONObject json = new JSONObject();
    try {
      SqlSession sqlSession = DaoUtil.getUtil().getSession();
      TbGoodsDAO dao = sqlSession.getMapper(TbGoodsDAO.class);
      json.put("list", dao.query());
      sqlSession.close();
      resp.getWriter().println(json);
    } catch (Exception e) {
      e.printStackTrace();
      json.put("error", "错误：" + e.getMessage());
      resp.getWriter().println(json);
    }

  }

}
