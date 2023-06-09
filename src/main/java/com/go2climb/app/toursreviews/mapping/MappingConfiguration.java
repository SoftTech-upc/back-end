package com.go2climb.app.toursreviews.mapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration("learningMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ToursReviewsMapper toursReviewsMapper(){
        return new ToursReviewsMapper();
    }

}
