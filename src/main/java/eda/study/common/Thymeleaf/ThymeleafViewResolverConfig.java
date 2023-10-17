package eda.study.common.Thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * Thymeleaf 설정 config
 * html 경로, 인코딩 등을 설정 가능함.
 */
public class ThymeleafViewResolverConfig {
  
  @Bean
  public ViewResolver thymeleafViewResolver() {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(thymeleafTemplateEngine());
    viewResolver.setCharacterEncoding("UTF-8");
    viewResolver.setOrder(0);
    // Important!!
    // th_page1.html, th_page2.html, ...
    viewResolver.setViewNames(new String[] { "th_*" });
    return viewResolver;
  }
  
  // Thymeleaf template engine with Spring integration
  @Bean
  public SpringTemplateEngine thymeleafTemplateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(thymeleafTemplateResolver());
    templateEngine.setEnableSpringELCompiler(true);
    return templateEngine;
  }
  
  @Bean
  public SpringResourceTemplateResolver springResourceTemplateResolver() {
    return new SpringResourceTemplateResolver();
  }
  
  // Thymeleaf template resolver serving HTML 5
  @Bean
  public ITemplateResolver thymeleafTemplateResolver() {
    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
    templateResolver.setPrefix("templates/thymeleaf/");
    templateResolver.setCacheable(false);
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setCharacterEncoding("UTF-8");
    return templateResolver;
  }
  
}
