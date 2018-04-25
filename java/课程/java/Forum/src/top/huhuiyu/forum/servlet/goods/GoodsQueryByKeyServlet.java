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
import top.huhuiyu.forum.entity.TbGoods;
import top.huhuiyu.forum.entity.Utils;

@WebServlet(name = "GoodsQueryByKeyServlet", urlPatterns = "/goods/queryByKey.servlet")
public class GoodsQueryByKeyServlet extends HttpServlet {

  private static final long serialVersionUID = 2491517252212023929L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    JSONObject json = new JSONObject();
    try {

      String sgid = req.getParameter("gid");
      if (!Utils.isInt(sgid)) {
        json.put("error", "商品编号必须填写且是整数");
        resp.getWriter().println(json);
        return;
      }
      int gid = Integer.parseInt(sgid);
      TbGoods goods = new TbGoods();
      goods.setGid(gid);

      SqlSession sqlSession = DaoUtil.getUtil().getSession();
      TbGoodsDAO dao = sqlSession.getMapper(TbGoodsDAO.class);
      goods = dao.queryByKey(goods);
      sqlSession.close();

      json.put("goods", goods);
      resp.getWriter().println(json);
    } catch (Exception e) {
      e.printStackTrace();
      json.put("error", "错误：" + e.getMessage());
      resp.getWriter().println(json);
    }

  }
}
