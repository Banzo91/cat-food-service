package com.banzo.catfood.controller;

import com.banzo.catfood.model.CatFood;
import com.banzo.catfood.service.CatFoodService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CatFoodController {

    private CatFoodService catFoodService;

    public CatFoodController(CatFoodService catFoodService) {
        this.catFoodService = catFoodService;
    }

    @GetMapping("/products")
    public Iterable<CatFood> getCatFoodItems() {

        Iterable<CatFood> catFoodItems = catFoodService.findAll();

        return catFoodItems;
    }

    @GetMapping("/products/{id}")
    public CatFood getCatFood(@PathVariable Long id) {

        Optional<CatFood> catFood = catFoodService.findById(id);

        if (catFood.isEmpty()) {
            throw new RuntimeException("Product with id of " + id + " not found.");
        }

        return catFood.get();
    }

    @PostMapping("/products")
    public CatFood addCatFood(@RequestBody CatFood catFood) {

        catFood.setId(0L);
        CatFood savedCatFood = catFoodService.save(catFood);

        return savedCatFood;
    }

    @PutMapping("/products/{id}")
    public CatFood updateCatFood(@RequestBody CatFood catFood, @PathVariable Long id) {

        Optional<CatFood> foundCatFood = catFoodService.findById(id);

        if (foundCatFood.isEmpty()) {
            throw new RuntimeException("Product with id of " + id + " not found.");
        } else {
            catFood.setId(id);
            catFoodService.save(catFood);
        }

        return catFood;
    }

    @DeleteMapping("/products/{id}")
    public void deleteCatFood(@PathVariable Long id) {

        catFoodService.deleteById(id);
    }

    @GetMapping("/products/search/findByTypeId")
    public Iterable<CatFood> getCatFoodItemsOfType(@RequestParam("id") Long typeId) {

        Iterable<CatFood> catFoodItemsOfType = catFoodService.findByTypeId(typeId);

        return catFoodItemsOfType;
    }

    @GetMapping("/products/search/findByName")
    public Iterable<CatFood> getCatFoodItemsByName(@RequestParam("name") String name) {

        Iterable<CatFood> foundCatFoodItems = catFoodService.findByName(name);

        return foundCatFoodItems;
    }

    @GetMapping("/products/search/findByRating")
    public Iterable<CatFood> getCatFoodItemsOrderedByRating() {

        Iterable<CatFood> catFoodItems = catFoodService.findAllOrderByRating();

        return catFoodItems;
    }
}
