package com.banzo.catfood.service;

import com.banzo.catfood.model.CatFoodType;
import com.banzo.catfood.repository.CatFoodTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class CatFoodTypeServiceImplTest {

    @Mock
    CatFoodTypeRepository catFoodTypeRepository;

    @InjectMocks
    CatFoodTypeServiceImpl catFoodTypeService;

    @Test
    void findAll() {

        List<CatFoodType> catFoodTypeList = new ArrayList<>();
        given(catFoodTypeRepository.findAll()).willReturn(catFoodTypeList);

        Iterable<CatFoodType> catFoodTypes = catFoodTypeService.findAll();
        assertThat(catFoodTypes).isNotNull();

        then(catFoodTypeRepository).should().findAll();
    }
}