package com.go2climb.app.toursreviews.mapping;
import com.go2climb.app.toursreviews.mapping.ToursReviewsMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration("ToursReviewMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ToursReviewsMapper toursReviewsMapper(){
        return new ToursReviewsMapper();
    }

}
