package top.huhuiyu.forum.servlet.goods;

import java.io.IOException;
import java.math.BigDecimal;

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

@WebServlet(name = "GoodsModifyServlet", urlPatterns = "/goods/modify.servlet")
public class GoodsModifyServlet extends HttpServlet {

  private static final long serialVersionUID = 6362545329850043734L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    JSONObject json = new JSONObject();
    try {
      String gname = req.getParameter("gname");
      String ginfo = req.getParameter("ginfo");
      String sprice = req.getParameter("price");
      String samount = req.getParameter("amount");
      String ssellprice = req.getParameter("sellprice");
      String sgid = req.getParameter("gid");
      if (!Utils.isInt(sgid)) {
        json.put("error", "商品编号必须填写且是整数");
        resp.getWriter().println(json);
        return;
      }
      int gid = Integer.parseInt(sgid);
      if (gname == null || gname.trim().equals("")) {
        json.put("error", "商品名称必须填写");
        resp.getWriter().println(json);
        return;
      }
      if (ginfo == null || ginfo.trim().equals("")) {
        json.put("error", "商品描述必须填写");
        resp.getWriter().println(json);
        return;
      }
      if (!Utils.isNumber(sprice)) {
        json.put("error", "商品价格必须填写且是数值");
        resp.getWriter().println(json);
        return;
      }
      BigDecimal price = new BigDecimal(sprice.trim());
      if (price.compareTo(Utils.ZERO) < 1) {
        json.put("error", "商品价格必须大于0");
        resp.getWriter().println(json);
        return;
      }

      if (!Utils.isInt(samount)) {
        json.put("error", "商品数量必须填写且是整数");
        resp.getWriter().println(json);
        return;
      }
      int amount = Integer.parseInt(samount.trim());

      if (amount <= 0) {
        json.put("error", "商品数量必须必须大于0");
        resp.getWriter().println(json);
        return;
      }

      if (!Utils.isNumber(ssellprice)) {
        json.put("error", "商品销售价格必须填写且是数值");
        resp.getWriter().println(json);
        return;
      }
      BigDecimal sellprice = new BigDecimal(ssellprice.trim());
      if (sellprice.compareTo(Utils.ZERO) < 1) {
        json.put("error", "商品销售价格必须大于0");
        resp.getWriter().println(json);
        return;
      }
      TbGoods goods = new TbGoods();
      goods.setGid(gid);
      goods.setGname(gname);
      goods.setGinfo(ginfo);
      goods.setPrice(price);
      goods.setAmount(amount);
      goods.setSellprice(sellprice);

      SqlSession sqlSession = DaoUtil.getUtil().getSession();
      TbGoodsDAO dao = sqlSession.getMapper(TbGoodsDAO.class);
      dao.modify(goods);
      sqlSession.close();

      json.put("message", "商品修改成功！");
      resp.getWriter().println(json);
    } catch (Exception e) {
      e.printStackTrace();
      json.put("error", "错误：" + e.getMessage());
      resp.getWriter().println(json);
    }

  }
}
