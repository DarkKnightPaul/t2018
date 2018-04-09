package top.huhuiyu.entity;

import java.io.Serializable;
import java.util.Date;

public class TbUser implements Serializable {

  private static final long serialVersionUID = 8889764330063501178L;
  private int uid;
  private String username;
  private String password;
  private String nickname;
  private String isEnable;
  private Date regDate;

  public TbUser() {
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

  public String getIsEnable() {
    return isEnable;
  }

  public void setIsEnable(String isEnable) {
    this.isEnable = isEnable;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

  @Override
  public String toString() {
    return "TbUser [uid=" + uid + ", username=" + username + ", password=" + password + ", nickname=" + nickname
        + ", isEnable=" + isEnable + ", regDate=" + regDate + "]";
  }

}
