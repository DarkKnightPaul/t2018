package top.huhuiyu.springboot.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class ImageCode {

  /**
   * 随机字符取值范围
   */
  private final static String CODES = "ABCDEFGHIJKMNOPQRSTUVWXYZ0123456789";
  /**
   * 随机数生成器
   */
  private final static Random RAND = new Random();
  /**
   * 随机数长度
   */
  private final static int LENGTH = 5;

  /**
   * 字体
   */
  private final static Font FONT = new Font(null, Font.BOLD, 18);

  /**
   * 干扰线数量
   */
  private final static int LINES = 10;

  /**
   * 产生一个随机字符串
   * 
   * @return 随机字符串
   */
  public static String makeCode() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < LENGTH; i++) {
      builder.append(CODES.charAt(RAND.nextInt(CODES.length())));

    }
    return builder.toString();
  }

  /**
   * 将code字符串生成为图片
   * 
   * @param code
   * @return 图片
   */
  public static BufferedImage makeImage(String code) {
    BufferedImage image = new BufferedImage(70, 26, BufferedImage.TYPE_INT_BGR);
    Graphics graphics = image.getGraphics();
    graphics.setFont(FONT);
    graphics.setColor(Color.YELLOW);
    // 绘制背景色
    graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
    // 绘制文字
    graphics.setColor(Color.BLUE);
    graphics.drawString(code, 0, 19);
    // 绘制干扰线
    for (int i = 0; i < LINES; i++) {
      int x1 = RAND.nextInt(image.getWidth());
      int x2 = RAND.nextInt(image.getWidth());
      int y1 = RAND.nextInt(image.getHeight());
      int y2 = RAND.nextInt(image.getHeight());
      graphics.drawLine(x1, y1, x2, y2);
    }
    return image;
  }

  public static void main(String[] args) {
    System.out.println(makeCode());

    try {
      ImageIO.write(makeImage(makeCode()), "jpeg", new File("code.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("图片输出完毕。。。");
  }

}
