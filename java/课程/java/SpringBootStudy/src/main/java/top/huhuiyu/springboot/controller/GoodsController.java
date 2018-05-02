package top.huhuiyu.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springboot.entity.TbGoods;
import top.huhuiyu.springboot.model.GoodsModel;
import top.huhuiyu.springboot.util.JsonMessage;

@RestController
@RequestMapping("/goods")
public class GoodsController {
  private static final Logger LOG = LoggerFactory.getLogger(GoodsController.class);

  @RequestMapping("/echo")
  @ResponseBody
  public TbGoods echo(TbGoods goods) {
    LOG.debug("提交的商品信息：" + goods);
    return goods;
  }

  @RequestMapping("/testException")
  @ResponseBody
  public String testExecption() throws Exception {
    throw new Exception("异常处理测试");
  }

  @RequestMapping("/echo2")
  @ResponseBody
  public JsonMessage echo2(GoodsModel model) {
    JsonMessage json = JsonMessage.getSuccess(model.getMessage());
    json.putData("echo", model.getGoods());
    return json;
  }

}
