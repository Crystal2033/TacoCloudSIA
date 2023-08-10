package com.crystal2033.tacocloud.repository;

import com.crystal2033.tacocloud.models.Taco;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

/**
 * @project TacoCloud
 * ©Crystal2033
 * @date 10/08/2023
 */
public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {
    Taco save(Taco taco);
    Optional<Taco> findById(Long id);
}
