package com.crudapi.demo.repository;

import com.crudapi.demo.domain.Pokemon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

    List<Pokemon> findAllByOrderByIdAsc();

}
