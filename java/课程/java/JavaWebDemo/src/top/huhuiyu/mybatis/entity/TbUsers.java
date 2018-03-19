package top.huhuiyu.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class TbUsers implements Serializable {

  private static final long serialVersionUID = -5015989615807031901L;

  private int uid;
  private String username;
  private String password;
  private String nickname;
  private String phone;
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date regDate;

  public TbUsers() {
  }

  @Override
  public String toString() {
    return "TbUsers [uid=" + uid + ", username=" + username + ", password=" + password + ", nickname=" + nickname
        + ", phone=" + phone + ", regDate=" + regDate + "]";
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

}
