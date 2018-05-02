package top.huhuiyu.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @RequestMapping("/")
  public String Index() {
    return "SpringBoot你好！";
  }

  @RequestMapping("/echo")
  public String echo(String info) {
    return "springboot:" + info;
  }
  
}
