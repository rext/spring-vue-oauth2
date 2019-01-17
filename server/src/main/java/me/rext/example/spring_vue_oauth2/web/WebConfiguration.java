package me.rext.example.spring_vue_oauth2.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
                .resourceChain(false)
                .addResolver(new SpaWebJarResourceResolver("index.html"));
    }

    @Bean
    FilterRegistrationBean uiFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new UiFilter());
        bean.addUrlPatterns("/ui", "/ui/*");
        return bean;
    }

}
