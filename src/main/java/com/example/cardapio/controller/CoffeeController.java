package com.example.cardapio.controller;

import com.example.cardapio.dto.CoffeeRequestDTO;
import com.example.cardapio.dto.CoffeeResponseDTO;
import com.example.cardapio.entities.Coffee;
import com.example.cardapio.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("coffee")
public class CoffeeController {
    @Autowired
    private CoffeeRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "x")
    @GetMapping
    public List<CoffeeResponseDTO> getAll(){
        List<CoffeeResponseDTO> coffees = repository.findAll().stream().map(CoffeeResponseDTO::new).toList();
        return coffees;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "x")
    @PostMapping()
    public void saveCoffee(@RequestBody CoffeeRequestDTO coffee){
        Coffee newCoffee = new Coffee(coffee);
        repository.save(newCoffee);
        return;
    }
}
