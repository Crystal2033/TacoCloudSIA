package com.crystal2033.tacocloud.repository;

import com.crystal2033.tacocloud.models.TacoOrder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.crystal2033.tacocloud.models.User;

import java.util.List;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 22/07/2023
 */
public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
