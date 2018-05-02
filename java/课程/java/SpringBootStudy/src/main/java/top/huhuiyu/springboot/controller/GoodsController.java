package top.huhuiyu.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springboot.entity.TbGoods;

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
}
