package com.crudapi.demo.service;

import com.crudapi.demo.domain.Pokemon;
import com.crudapi.demo.repository.PokemonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService implements IPokemonService {

    @Autowired
    private PokemonRepository repository;

    @Override
    public List<Pokemon> findAll() {
        return repository.findAllByOrderByIdAsc();
    }

    @Override
    public Pokemon findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Pokemon create(Pokemon pokemon) {
        return repository.save(pokemon);
    }

    @Override
    public Pokemon update(Long id, Pokemon pokemon) {
        return repository.findById(id)
            .map(existingPokemon -> {
                existingPokemon.setName(pokemon.getName());
                existingPokemon.setSpecies(pokemon.getSpecies());
                return repository.save(existingPokemon);
            })
            .orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
