package top.huhuiyu.springboot.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbGoods implements Serializable {

  private static final long serialVersionUID = -1861552014839692752L;
  private int gid;
  private String gname;
  private String ginfo;
  private BigDecimal price;
  private int amount;
  private BigDecimal sellprice;

  public TbGoods() {
  }

  public int getGid() {
    return gid;
  }

  public void setGid(int gid) {
    this.gid = gid;
  }

  public String getGname() {
    return gname;
  }

  public void setGname(String gname) {
    this.gname = gname;
  }

  public String getGinfo() {
    return ginfo;
  }

  public void setGinfo(String ginfo) {
    this.ginfo = ginfo;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public BigDecimal getSellprice() {
    return sellprice;
  }

  public void setSellprice(BigDecimal sellprice) {
    this.sellprice = sellprice;
  }

  @Override
  public String toString() {
    return "TbGoods [gid=" + gid + ", gname=" + gname + ", ginfo=" + ginfo + ", price=" + price + ", amount=" + amount
        + ", sellprice=" + sellprice + "]";
  }

}
