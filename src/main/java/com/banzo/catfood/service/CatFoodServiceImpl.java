package com.banzo.catfood.service;

import com.banzo.catfood.model.CatFood;
import com.banzo.catfood.repository.CatFoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CatFoodServiceImpl implements CatFoodService {

    private CatFoodRepository catFoodRepository;

    public CatFoodServiceImpl(CatFoodRepository catFoodRepository) {
        this.catFoodRepository = catFoodRepository;
    }

    @Transactional
    @Override
    public Iterable<CatFood> findAll() {
        return catFoodRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<CatFood> findById(Long id) {
        return catFoodRepository.findById(id);
    }

    @Transactional
    @Override
    public CatFood save(CatFood catFood) {
        return catFoodRepository.save(catFood);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        catFoodRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Iterable<CatFood> findByTypeId(Long id) {
        return catFoodRepository.findByTypeId(id);
    }

    @Transactional
    @Override
    public Iterable<CatFood> findByName(String name) {
        return catFoodRepository.findByNameContainingIgnoreCase(name);
    }

    @Transactional
    @Override
    public Iterable<CatFood> findAllOrderByRating() {
        return catFoodRepository.findByOrderByRatingDesc();
    }
}
