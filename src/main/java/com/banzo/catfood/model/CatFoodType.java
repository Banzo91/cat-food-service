package com.banzo.catfood.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cat_food_type")
public class CatFoodType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    @JsonIgnore
    private Collection<CatFood> catFoodItems;
}
