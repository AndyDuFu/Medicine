package com.medicine.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Component
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    @Value("${web.img-path}")
    private String imgPath;

    @Value("${web.file-dowload}")
    private String filePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //addResourceHandler是指你想在url请求的路径

        //addResourceLocations是图片存放的真实路径
        // file:/home/web/img/file/

        registry.addResourceHandler("/file/**").addResourceLocations("file:" + filePath);
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + imgPath);
        super.addResourceHandlers(registry);
    }
}
