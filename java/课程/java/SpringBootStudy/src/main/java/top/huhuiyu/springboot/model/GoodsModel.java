package top.huhuiyu.springboot.model;

import java.io.Serializable;

import top.huhuiyu.springboot.entity.TbGoods;

public class GoodsModel implements Serializable {

  private static final long serialVersionUID = -1041696755720724225L;
  private TbGoods goods;
  private String message;

  public GoodsModel() {
  }

  public TbGoods getGoods() {
    return goods;
  }

  public void setGoods(TbGoods goods) {
    this.goods = goods;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "GoodsModel [goods=" + goods + ", message=" + message + "]";
  }

}
