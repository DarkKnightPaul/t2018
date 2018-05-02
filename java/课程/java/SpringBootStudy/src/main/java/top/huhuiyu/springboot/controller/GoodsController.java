package top.huhuiyu.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springboot.dao.TbGoodsDAO;
import top.huhuiyu.springboot.util.JsonMessage;

@RestController
@RequestMapping("/goods")
public class GoodsController {

  @Autowired
  private TbGoodsDAO tbGoodsDAO;

  @RequestMapping("/queryAll")
  @ResponseBody
  public JsonMessage query() throws Exception {
    JsonMessage json = JsonMessage.getSuccess("查询成功");
    json.putData("list", tbGoodsDAO.query());
    return json;
  }

}
