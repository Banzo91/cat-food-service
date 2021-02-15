package com.banzo.catfood.service;

import com.banzo.catfood.model.CatFood;

import java.util.Optional;

public interface CatFoodService {

    Iterable<CatFood> findAll();
    Optional<CatFood> findById(Long id);
    void save(CatFood catFood);
    void deleteById(Long id);
    Iterable<CatFood> findByTypeId(Long id);
    Iterable<CatFood> findByName(String name);
    Iterable<CatFood> findAllOrderByRating();
}
