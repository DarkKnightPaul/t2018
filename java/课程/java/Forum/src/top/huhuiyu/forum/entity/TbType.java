package top.huhuiyu.forum.entity;

import java.io.Serializable;
import java.util.Date;

public class TbType implements Serializable {

  private static final long serialVersionUID = -4007432489586641516L;

  private int tid;
  private String typename;
  private String typeinfo;
  private String isEnable;
  private Date created;

  public int getTid() {
    return tid;
  }

  public void setTid(int tid) {
    this.tid = tid;
  }

  public String getTypename() {
    return typename;
  }

  public void setTypename(String typename) {
    this.typename = typename;
  }

  public String getTypeinfo() {
    return typeinfo;
  }

  public void setTypeinfo(String typeinfo) {
    this.typeinfo = typeinfo;
  }

  public String getIsEnable() {
    return isEnable;
  }

  public void setIsEnable(String isEnable) {
    this.isEnable = isEnable;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  @Override
  public String toString() {
    return "TbType [tid=" + tid + ", typename=" + typename + ", typeinfo=" + typeinfo + ", isEnable=" + isEnable
        + ", created=" + created + "]";
  }

}
