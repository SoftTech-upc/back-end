package com.go2climb.app.activity.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("activityMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ActivityMapper activityMapper() {
        return new ActivityMapper();
    }
}
