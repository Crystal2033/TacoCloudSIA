package com.crystal2033.tacocloud.repository;

import com.crystal2033.tacocloud.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 01/08/2023
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
