package com.banzo.catfood.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cat_food")
public class CatFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    @NotNull(message = "is required")
    private CatFoodType type;

    @NotNull(message = "is required")
    @Column(name = "price")
    private BigDecimal price;

    @Min(value = 1, message = "must be greater than or equal to 1")
    @Max(value = 5, message = "must be less than or equal to 5")
    @Column(name = "rating")
    private Integer rating;

    @Column(name = "image")
    private String image;

    @Column(name = "net_mass")
    private BigDecimal netMass;

    @Embedded
    private NutritionalValues nutritionalValues;



}
