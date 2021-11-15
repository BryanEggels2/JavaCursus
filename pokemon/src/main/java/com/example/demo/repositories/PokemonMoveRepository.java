package com.example.demo.repositories;

import com.example.demo.entities.PokemonMove;
import org.springframework.data.repository.CrudRepository;

public interface PokemonMoveRepository extends CrudRepository<PokemonMove, Long> {

}