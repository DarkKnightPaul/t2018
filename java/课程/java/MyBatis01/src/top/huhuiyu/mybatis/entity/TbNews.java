package top.huhuiyu.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

public class TbNews implements Serializable {

  private static final long serialVersionUID = -5427119707129484119L;
  private int nid;
  private String title;
  private String content;
  private Date created;

  @Override
  public String toString() {
    return "TbNews [nid=" + nid + ", title=" + title + ", content=" + content + ", created=" + created + "]";
  }

  public TbNews() {
  }

  public int getNid() {
    return nid;
  }

  public void setNid(int nid) {
    this.nid = nid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

}
