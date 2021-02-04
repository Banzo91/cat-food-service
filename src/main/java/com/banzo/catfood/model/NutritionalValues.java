package com.banzo.catfood.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Data
@Embeddable
public class NutritionalValues {

    @Column(name = "protein")
    private BigDecimal protein;

    @Column(name = "carbohydrates")
    private BigDecimal carbohydrates;

    @Column(name = "fat")
    private BigDecimal fat;
}
