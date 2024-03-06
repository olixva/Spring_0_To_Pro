package com.curso.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.curso.spring.config.AppConfig;

public class MovieAdvisorApp {

    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MovieAdvisorRunApp app = appContext.getBean(MovieAdvisorRunApp.class);
        app.run(args);

        ((AnnotationConfigApplicationContext) appContext).close();
    }
}
