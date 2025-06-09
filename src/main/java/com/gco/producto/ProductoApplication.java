package com.gco.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.gco.producto")
public class ProductoApplication  {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ProductoApplication.class);
        springApplication.setAllowBeanDefinitionOverriding(true);
        springApplication.run(args);
    }
}
