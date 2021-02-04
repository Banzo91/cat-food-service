package com.banzo.catfood.repository;

import com.banzo.catfood.model.CatFoodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatFoodTypeRepository extends JpaRepository<CatFoodType, Long> {
}
