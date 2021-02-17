package com.banzo.catfood.controller;

import com.banzo.catfood.model.CatFoodType;
import com.banzo.catfood.service.CatFoodTypeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CatFoodTypeController.class)
@AutoConfigureTestDatabase
class CatFoodTypeControllerTest {

    @MockBean
    CatFoodTypeService catFoodTypeService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @AfterEach
    void tearDown() {
        reset(catFoodTypeService);
    }

    @Test
    void getCatFoodTypes() throws Exception {

        given(catFoodTypeService.findAll()).willReturn(getCatFoodTypeList());

        mockMvc.perform(get("/api/product-types").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    private List<CatFoodType> getCatFoodTypeList() {

        List<CatFoodType> catFoodTypeList = new ArrayList<>();
        catFoodTypeList.add(CatFoodType.builder().id(1L).type("Wet").build());
        catFoodTypeList.add(CatFoodType.builder().id(2L).type("Dry").build());

        return catFoodTypeList;
    }
}