package com.banzo.catfood.service;

import com.banzo.catfood.model.CatFoodType;

public interface CatFoodTypeService {

    Iterable<CatFoodType> findAll();
}
