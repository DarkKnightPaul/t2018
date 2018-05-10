package top.huhuiyu.springboot.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.huhuiyu.springboot.util.ImageCode;

@RestController
@RequestMapping("/util")
public class UtilController {

  @RequestMapping("/code.jpg")
  public void codeImage(HttpServletResponse response) throws Exception {
    String code = ImageCode.makeCode();
    BufferedImage image = ImageCode.makeImage(code);
    ImageIO.write(image, "jpeg", response.getOutputStream());
  }
  
}
