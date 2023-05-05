package com.example.cardapio.dto;

import com.example.cardapio.entities.Coffee;

public record CoffeeResponseDTO(Long id, String title, String image, Double price) {
    public CoffeeResponseDTO(Coffee coffee){
        this(coffee.getId(), coffee.getTitle(), coffee.getImage(), coffee.getPrice());
    }
}
