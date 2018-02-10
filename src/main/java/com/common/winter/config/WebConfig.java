package com.common.winter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired private LoginInterceptor loginInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/jdy/**")
                .excludePathPatterns("/login");
                //.excludePathPatterns("/users/login"); //로그인 쪽은 예외처리를 한다.
    }


    @Bean

    public ViewResolver getViewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/jsp/");

        viewResolver.setSuffix(".jsp");

        return viewResolver;

    }


}
