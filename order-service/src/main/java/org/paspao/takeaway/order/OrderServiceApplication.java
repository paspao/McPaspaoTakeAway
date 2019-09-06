package org.paspao.takeaway.order;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Created by <a href="mailto:pasquale.paola@eng.it">Pasquale Paola</a> on 06/09/19.
 */
@EnableSwagger2
@SpringBootApplication
public class OrderServiceApplication {

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).tags(
                new Tag("OrderServices","Order Service")

        )
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.paspao.takeaway.order.api"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Order Service REST API",
                "API ",
                env.getProperty("info.version"),
                null,
                new Contact("Engineering Ingegneria Informatica S.p.A.", "https://paspaola.it", "pasquale.paola@gmail.com"),
                null, null, Collections.emptyList());
    }

    @Bean
    public DozerBeanMapper modelMapper() {
        DozerBeanMapper modelMapper=new DozerBeanMapper();

        return modelMapper;
    }

}
