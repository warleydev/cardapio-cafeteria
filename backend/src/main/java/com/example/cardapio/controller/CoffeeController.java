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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveCoffee(@RequestBody CoffeeRequestDTO coffee){
        Coffee newCoffee = new Coffee(coffee);
        repository.save(newCoffee);
        return;
    }

    @PutMapping(value="/{id}")
    public Coffee update(@PathVariable Long id, @RequestBody Coffee coffee){
        try {
            Coffee entity = repository.getReferenceById(id);
            updateData(entity, coffee);
            return repository.save(entity);
        } catch(RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    private void updateData(Coffee coffee, Coffee newData) {
        coffee.setPrice(newData.getPrice());
        coffee.setTitle(newData.getTitle());
        coffee.setImage(newData.getImage());
    }
}
