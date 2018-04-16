package top.huhuiyu.forum.entity;

import java.io.Serializable;
import java.util.Date;

public class TbRetruns implements Serializable {

  private static final long serialVersionUID = -3615279536967433213L;
  private int rid;
  private String content;
  private Date created;
  private int iid;
  private int uid;

  public int getRid() {
    return rid;
  }

  public void setRid(int rid) {
    this.rid = rid;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public int getIid() {
    return iid;
  }

  public void setIid(int iid) {
    this.iid = iid;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  @Override
  public String toString() {
    return "TbRetruns [rid=" + rid + ", content=" + content + ", created=" + created + ", iid=" + iid + ", uid=" + uid
        + "]";
  }

}
