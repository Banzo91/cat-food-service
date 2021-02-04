package com.banzo.catfood.repository;

import com.banzo.catfood.model.CatFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface CatFoodRepository extends JpaRepository<CatFood, Long> {

    Iterable<CatFood> findByTypeId(@RequestParam("id") Long id);

    Iterable<CatFood> findByNameContainingIgnoreCase(@RequestParam("name") String name);

    Iterable<CatFood> findByOrderByRatingDesc();
}
