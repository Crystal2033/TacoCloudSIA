package com.crystal2033.tacocloud.repository;

import com.crystal2033.tacocloud.models.TacoOrder;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 22/07/2023
 */
public interface OrderRepository {
    TacoOrder save(TacoOrder order);
}
