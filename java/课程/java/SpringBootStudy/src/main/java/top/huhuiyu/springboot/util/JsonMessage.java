package top.huhuiyu.springboot.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class JsonMessage implements Serializable {
  private static final long serialVersionUID = 8823355291602843181L;
  private int code = 500;
  private String message = "服务器忙，请稍后重试";
  private Map<String, Object> datas = new HashMap<String, Object>();

  public JsonMessage() {
  }

  public void putData(String key, Object data) {
    datas.put(key, data);
  }

  public void removeAllData() {
    datas.clear();
  }

  public static JsonMessage getFail(String message) {
    return getMessage(500, message);
  }

  public static JsonMessage getSuccess(String message) {
    return getMessage(200, message);
  }

  public static JsonMessage getMessage(int code, String message) {
    JsonMessage json = new JsonMessage();
    json.setCode(code);
    json.setMessage(message);
    return json;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
  
  public Map<String, Object> getDatas() {
    return datas;
  }

  @Override
  public String toString() {
    return "JsonMessage [code=" + code + ", message=" + message + ", datas=" + datas + "]";
  }

}
