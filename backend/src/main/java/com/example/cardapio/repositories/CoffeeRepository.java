package com.example.cardapio.repositories;

import com.example.cardapio.entities.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
