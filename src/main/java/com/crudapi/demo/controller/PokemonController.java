package com.crudapi.demo.controller;

import com.crudapi.demo.domain.Pokemon;
import com.crudapi.demo.service.IPokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    private IPokemonService service;

    @GetMapping("/pokemon")
    public List<Pokemon> findAllPokemon() {
        return service.findAll();
    }

    @GetMapping("/pokemon/{id}")
    public Pokemon findPokemon(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/pokemon")
    @ResponseStatus(HttpStatus.CREATED)
    public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
        return service.create(pokemon);
    }

    @PutMapping("/pokemon/{id}")
    public Pokemon updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return service.update(id, pokemon);
    }

    @DeleteMapping("/pokemon/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePokemon(@PathVariable Long id) {
        service.delete(id);
    }

}
