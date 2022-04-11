package org.michisoft.backendclassroom.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean("subjectMapper")
    public ModelMapper subjectMapper() {
        return new ModelMapper();
    }
}
