package com.github.mithwick93.tutorial.configuration;

import com.github.mithwick93.tutorial.interceptor.TutorialServiceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class TutorialServiceInterceptorAppConfig implements WebMvcConfigurer {
    private TutorialServiceInterceptor tutorialServiceInterceptor;

    @Autowired
    public void setTutorialServiceInterceptor(TutorialServiceInterceptor tutorialServiceInterceptor) {
        this.tutorialServiceInterceptor = tutorialServiceInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tutorialServiceInterceptor);
    }
}