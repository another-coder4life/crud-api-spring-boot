package com.crudapi.demo.service;

import com.crudapi.demo.domain.Pokemon;

import java.util.List;

public interface IPokemonService {

    List<Pokemon> findAll();
    Pokemon findById(Long id);
    Pokemon create(Pokemon pokemon);
    Pokemon update(Long id, Pokemon pokemon);
    void delete(Long id);

}
