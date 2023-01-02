package kata.spring_security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import kata.spring_security.dao.RoleDaoImp;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/**").setViewName("user");
        registry.addViewController("/admin/**").setViewName("admin");
    }
}
