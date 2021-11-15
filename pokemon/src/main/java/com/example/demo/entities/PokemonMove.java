package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class PokemonMove {

    @Id
    @NotEmpty
    private String name;

    public PokemonMove() {

    }

    public PokemonMove(@NotEmpty String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
