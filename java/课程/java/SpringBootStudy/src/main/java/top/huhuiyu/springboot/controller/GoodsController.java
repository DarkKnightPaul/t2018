package top.huhuiyu.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springboot.dao.TbGoodsDAO;
import top.huhuiyu.springboot.entity.TbGoods;
import top.huhuiyu.springboot.util.JsonMessage;

@RestController
@RequestMapping("/goods")
public class GoodsController {
  private static final Logger LOG = LoggerFactory.getLogger(GoodsController.class);

  @Autowired
  private TbGoodsDAO tbGoodsDAO;

  @RequestMapping("/queryAll")
  @ResponseBody
  public JsonMessage query() throws Exception {
    JsonMessage json = JsonMessage.getSuccess("查询成功");
    json.putData("list", tbGoodsDAO.query());
    return json;
  }

  @RequestMapping("/add")
  @ResponseBody
  public JsonMessage add(TbGoods goods) throws Exception {
    LOG.debug("goods:" + goods);
    if (JsonMessage.isEmpty(goods.getGname())) {
      return JsonMessage.getFail("商品名称必须填写！");
    }
    if (JsonMessage.isEmpty(goods.getGinfo())) {
      return JsonMessage.getFail("商品信息必须填写！");
    }
    if (goods.getAmount() <= 0) {
      return JsonMessage.getFail("商品数量必须大于0！");
    }
    if (goods.getPrice().compareTo(JsonMessage.ZERO) < 1) {
      return JsonMessage.getFail("商品价格必须大于0！");
    }
    if (goods.getSellprice().compareTo(JsonMessage.ZERO) < 1) {
      return JsonMessage.getFail("商品销售价格必须大于0！");
    }
    tbGoodsDAO.add(goods);
    JsonMessage json = JsonMessage.getSuccess("添加成功");
    return json;
  }

  @RequestMapping("/delete")
  @ResponseBody
  public JsonMessage delete(TbGoods goods) throws Exception {
    LOG.debug("goods:" + goods);
    if (goods.getGid() <= 0) {
      return JsonMessage.getFail("请提供商品编号！");
    }
    tbGoodsDAO.delete(goods);
    JsonMessage json = JsonMessage.getSuccess("删除成功");
    return json;
  }

  @RequestMapping("/queryByKey")
  @ResponseBody
  public JsonMessage queryByKey(TbGoods goods) throws Exception {
    LOG.debug("goods:" + goods);
    if (goods.getGid() <= 0) {
      return JsonMessage.getFail("请提供商品编号！");
    }
    goods = tbGoodsDAO.queryByKey(goods);
    JsonMessage json = JsonMessage.getSuccess("查询成功");
    json.putData("goods", goods);
    return json;
  }

  @RequestMapping("/modify")
  @ResponseBody
  public JsonMessage modify(TbGoods goods) throws Exception {
    LOG.debug("goods:" + goods);
    if (goods.getGid() < 1) {
      return JsonMessage.getFail("请选择商品！");
    }
    if (JsonMessage.isEmpty(goods.getGname())) {
      return JsonMessage.getFail("商品名称必须填写！");
    }
    if (JsonMessage.isEmpty(goods.getGinfo())) {
      return JsonMessage.getFail("商品信息必须填写！");
    }
    if (goods.getAmount() <= 0) {
      return JsonMessage.getFail("商品数量必须大于0！");
    }
    if (goods.getPrice().compareTo(JsonMessage.ZERO) < 1) {
      return JsonMessage.getFail("商品价格必须大于0！");
    }
    if (goods.getSellprice().compareTo(JsonMessage.ZERO) < 1) {
      return JsonMessage.getFail("商品销售价格必须大于0！");
    }
    tbGoodsDAO.modify(goods);
    JsonMessage json = JsonMessage.getSuccess("修改成功");
    return json;
  }

}
