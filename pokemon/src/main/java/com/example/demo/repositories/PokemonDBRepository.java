package com.example.demo.repositories;

import com.example.demo.entities.PokemonDB;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonDBRepository extends CrudRepository<PokemonDB, Long> {

}
