package top.huhuiyu.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import top.huhuiyu.springboot.util.MyHandlerInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public MyHandlerInterceptor getMyHandlerInterceptor() {
    return new MyHandlerInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(getMyHandlerInterceptor()).addPathPatterns("/**");
    super.addInterceptors(registry);
  }
}
