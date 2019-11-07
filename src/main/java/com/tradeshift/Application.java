package com.tradeshift;

import com.tradeshift.business.matcher.triangle.EquilateralTriangleMatcher;
import com.tradeshift.business.matcher.triangle.IsoscelesTriangleMatcher;
import com.tradeshift.business.matcher.triangle.ScaleneTriangleMatcher;
import com.tradeshift.business.triangle.PreferredTriangleMatcherContainer;
import com.tradeshift.business.triangle.PreferredTriangleMatcherContainerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    EquilateralTriangleMatcher equilateralTriangleMatcher;

    @Autowired
    IsoscelesTriangleMatcher isoscelesTriangleMatcher;

    @Autowired
    ScaleneTriangleMatcher scaleneTriangleMatcher;

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.tradeshift.controller.rest")).build();
    }

    @Bean
    public PreferredTriangleMatcherContainer preferredTriangleMatcherContainer() {
        logger.debug("preferredTriangleMatchers are selected.");
        return new PreferredTriangleMatcherContainerBuilder()
                .add(equilateralTriangleMatcher)
                .add(isoscelesTriangleMatcher)
                .add(scaleneTriangleMatcher)
                .build();
    }
}
