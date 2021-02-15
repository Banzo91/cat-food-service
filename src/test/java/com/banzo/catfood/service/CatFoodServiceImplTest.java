package com.banzo.catfood.service;

import com.banzo.catfood.model.CatFood;
import com.banzo.catfood.repository.CatFoodRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class CatFoodServiceImplTest {

    @Mock
    CatFoodRepository catFoodRepository;

    @InjectMocks
    CatFoodServiceImpl catFoodService;

    @Test
    void findAll() {

        List<CatFood> catFoodList = new ArrayList<>();
        given(catFoodRepository.findAll()).willReturn(catFoodList);

        Iterable<CatFood> catFoodItems = catFoodService.findAll();
        assertThat(catFoodItems).isNotNull();

        then(catFoodRepository).should().findAll();
    }

    @Test
    void findById() {

        CatFood catFood = new CatFood();
        given(catFoodRepository.findById(anyLong())).willReturn(Optional.of(catFood));

        Optional<CatFood> catFoodItem = catFoodService.findById(1L);
        assertThat(catFoodItem).isNotNull();

        then(catFoodRepository).should().findById(1L);
    }

    @Test
    void save() {

        CatFood catFood = new CatFood();
        catFoodService.save(catFood);
        catFoodService.save(catFood);

        then(catFoodRepository).should(times(2)).save(catFood);
    }

    @Test
    void deleteById() {

        catFoodService.deleteById(1L);
        catFoodService.deleteById(1L);

        then(catFoodRepository).should(times(2)).deleteById(1L);
    }

    @Test
    void findByTypeId() {

        List<CatFood> catFoodList = new ArrayList<>();
        given(catFoodRepository.findByTypeId(anyLong())).willReturn(catFoodList);

        Iterable<CatFood> catFoodItems = catFoodService.findByTypeId(1L);
        assertThat(catFoodItems).isNotNull();

        then(catFoodRepository).should().findByTypeId(1L);
    }

    @Test
    void findByName() {

        List<CatFood> catFoodList = new ArrayList<>();
        given(catFoodRepository.findByNameContainingIgnoreCase(anyString())).willReturn(catFoodList);

        Iterable<CatFood> catFoodItems = catFoodService.findByName("test");
        assertThat(catFoodItems).isNotNull();

        then(catFoodRepository).should().findByNameContainingIgnoreCase("test");
    }
}