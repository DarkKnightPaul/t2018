package top.huhuiyu.forum.entity;

import java.math.BigDecimal;

public class Utils {

  public static final BigDecimal ZERO = new BigDecimal("0");

  public static boolean isInt(String str) {
    if (str == null || str.trim().equals("")) {
      return false;
    }
    try {
      Integer.parseInt(str);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static boolean isNumber(String str) {
    if (str == null || str.trim().equals("")) {
      return false;
    }
    try {
      new BigDecimal(str);
      return true;
    } catch (Exception e) {
      return false;
    }

  }

  public static void main(String[] args) {
    System.out.println(isNumber("dd"));
    System.out.println(isNumber("   "));
    System.out.println(isNumber(null));
    System.out.println(isNumber("-0.9001"));
    System.out.println(isNumber("1111"));
    System.out.println(isNumber("1111.2222"));
    System.out.println("======================================");
    System.out.println(isInt("dd"));
    System.out.println(isInt("   "));
    System.out.println(isInt(null));
    System.out.println(isInt("-1099"));
    System.out.println(isInt("1111"));
    System.out.println(isInt("1111.2222"));
    System.out.println("======================================");
    BigDecimal d1 = new BigDecimal("-100");
    BigDecimal d2 = new BigDecimal("0");
    BigDecimal d3 = new BigDecimal("0.1");
    System.out.println(d1.compareTo(d2));
    System.out.println(d3.compareTo(d2));
    System.out.println(d2.compareTo(new BigDecimal("0")));
  }
}
