package top.huhuiyu.forum.entity;

import java.io.Serializable;
import java.util.Date;

public class TbSubject implements Serializable {

  private static final long serialVersionUID = 1502416452382539739L;

  private int sid;
  private String sname;
  private String sinfo;
  private int tid;
  private Date created;

  public int getSid() {
    return sid;
  }

  public void setSid(int sid) {
    this.sid = sid;
  }

  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }

  public String getSinfo() {
    return sinfo;
  }

  public void setSinfo(String sinfo) {
    this.sinfo = sinfo;
  }

  public int getTid() {
    return tid;
  }

  public void setTid(int tid) {
    this.tid = tid;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  @Override
  public String toString() {
    return "TbSubject [sid=" + sid + ", sname=" + sname + ", sinfo=" + sinfo + ", tid=" + tid + ", created=" + created
        + "]";
  }

}
