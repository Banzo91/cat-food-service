package com.banzo.catfood.service;

import com.banzo.catfood.model.CatFoodType;
import com.banzo.catfood.repository.CatFoodTypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatFoodTypeServiceImpl implements CatFoodTypeService {

    private CatFoodTypeRepository catFoodTypeRepository;

    public CatFoodTypeServiceImpl(CatFoodTypeRepository catFoodTypeRepository) {
        this.catFoodTypeRepository = catFoodTypeRepository;
    }

    @Transactional
    @Override
    public Iterable<CatFoodType> findAll() {
        return catFoodTypeRepository.findAll();
    }
}
