package com.example.cardapio.entities;

import com.example.cardapio.dto.CoffeeRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "coffees")
@Table(name = "coffees")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Double price;

    public Coffee(CoffeeRequestDTO data){
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
    }
}
