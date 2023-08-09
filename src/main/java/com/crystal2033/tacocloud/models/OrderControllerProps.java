package com.crystal2033.tacocloud.models;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 09/08/2023
 */

@Data
@Component
@ConfigurationProperties(prefix = "taco.orders")
public class OrderControllerProps {
    private int pageSize;
}
