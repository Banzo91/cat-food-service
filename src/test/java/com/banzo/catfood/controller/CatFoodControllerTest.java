package com.banzo.catfood.controller;

import com.banzo.catfood.model.CatFood;
import com.banzo.catfood.model.CatFoodType;
import com.banzo.catfood.service.CatFoodService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CatFoodController.class)
@AutoConfigureTestDatabase
class CatFoodControllerTest {

    @MockBean
    CatFoodService catFoodService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @AfterEach
    void tearDown() {
        reset(catFoodService);
    }

    @Test
    void getCatFoodItems() throws Exception {

        given(catFoodService.findAll()).willReturn(getCatFoodList());

        mockMvc.perform(get("/api/products").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCatFood() throws Exception {

        given(catFoodService.findById(anyLong())).willReturn(Optional.of(getCatFoodItem()));
        Random random = new Random();

        mockMvc.perform(get("/api/products/" + random.nextInt(10)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void addCatFood() throws Exception {

        CatFood catFood = getCatFoodItem();
        String catFoodJson = objectMapper.writeValueAsString(catFood);

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(catFoodJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateCatFood() throws Exception {

        given(catFoodService.findById(anyLong())).willReturn(Optional.of(getCatFoodItem()));
        CatFood catFood = getCatFoodItem();
        String catFoodJson = objectMapper.writeValueAsString(catFood);
        Random random = new Random();

        mockMvc.perform(put("/api/products/" + random.nextInt(10))
                .contentType(MediaType.APPLICATION_JSON)
                .content(catFoodJson))
                .andExpect(status().isOk());
    }

    @Test
    void deleteCatFood() throws Exception {

        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getCatFoodItemsOfType() throws Exception {

        given(catFoodService.findByTypeId(anyLong())).willReturn(getCatFoodList());
        Random random = new Random();

        mockMvc.perform(get("/api/products/search/findByTypeId?id=" + random.nextInt(10))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getCatFoodItemsByName() throws Exception {

        given(catFoodService.findByName(anyString())).willReturn(getCatFoodList());

        mockMvc.perform(get("/api/products/search/findByName?name=test")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    private CatFood getCatFoodItem() {
        return CatFood.builder()
                .name("Feringa")
                .netMass(BigDecimal.valueOf(200))
                .type(CatFoodType.builder().id(1L).type("Wet").build())
                .price(BigDecimal.valueOf(4.50))
                .build();
    }

    private List<CatFood> getCatFoodList() {

        List<CatFood> catFoodList = new ArrayList<>();
        catFoodList.add(CatFood.builder().id(1L).name("Macs").build());
        catFoodList.add(CatFood.builder().id(2L).name("Applaws").build());

        return catFoodList;
    }
}