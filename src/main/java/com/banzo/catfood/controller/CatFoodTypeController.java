package com.banzo.catfood.controller;

import com.banzo.catfood.model.CatFoodType;
import com.banzo.catfood.service.CatFoodTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CatFoodTypeController {

    CatFoodTypeService catFoodTypeService;

    public CatFoodTypeController(CatFoodTypeService catFoodTypeService) {
        this.catFoodTypeService = catFoodTypeService;
    }

    @GetMapping("/product-types")
    public ResponseEntity<Iterable<CatFoodType>> getCatFoodTypes() {

        Iterable<CatFoodType> catFoodTypes = catFoodTypeService.findAll();

        return new ResponseEntity<>(catFoodTypes, HttpStatus.OK);
    }
}
