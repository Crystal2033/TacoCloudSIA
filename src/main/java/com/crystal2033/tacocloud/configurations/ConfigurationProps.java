package com.crystal2033.tacocloud.configurations;

import com.crystal2033.tacocloud.models.OrderControllerProps;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 09/08/2023
 */
@Configuration
public class ConfigurationProps {
    @Bean
    @ConfigurationProperties(prefix = "taco.orders")
    public OrderControllerProps orderControllerProps() {
        return new OrderControllerProps();
    }
}
