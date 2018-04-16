package top.huhuiyu.forum.entity;

import java.io.Serializable;
import java.util.Date;

public class TbInfo implements Serializable {

  private static final long serialVersionUID = 7840205435238118342L;

  private int iid;
  private String title;
  private String content;
  private Date created;
  private String isDelete;
  private int uid;
  private int sid;
  public int getIid() {
    return iid;
  }
  public void setIid(int iid) {
    this.iid = iid;
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
  public String getIsDelete() {
    return isDelete;
  }
  public void setIsDelete(String isDelete) {
    this.isDelete = isDelete;
  }
  public int getUid() {
    return uid;
  }
  public void setUid(int uid) {
    this.uid = uid;
  }
  public int getSid() {
    return sid;
  }
  public void setSid(int sid) {
    this.sid = sid;
  }
  @Override
  public String toString() {
    return "TbInfo [iid=" + iid + ", title=" + title + ", content=" + content + ", created=" + created + ", isDelete="
        + isDelete + ", uid=" + uid + ", sid=" + sid + "]";
  }
  
}
