package com.example.demo.entities;

import java.util.List;

public class Player {
    private Pokemon pokemon;

    public Player(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
