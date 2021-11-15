package com.example.demo.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.awt.*;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Level is mandatory")
    private Integer level;

    @NotNull(message = "Health is mandatory")
    private long health;

    @NotNull(message = "Attack is mandatory")
    private Integer attack;

    @NotNull(message = "Defense is mandatory")
    private Integer defense;

    @NotNull(message = "Sp. Attack is mandatory")
    private Integer spAttack;

    @NotNull(message = "Sp. Defense is mandatory")
    private Integer spDefense;

    @NotNull(message = "Speed is mandatory")
    private Integer speed;

    @NotNull(message = "Type is mandatory")
    private String type;

    private String move1;

    private String move2;

    private String move3;

    private String move4;


//    @NotNull(message = "At least one type is mandatory")
//    private Type type1;
//    private Type type2;

    private String sprite;
    private String backsprite;

    public Pokemon() {

    }

    public Pokemon(long id, 
    @NotEmpty(message = "Name is mandatory") String name, 
    @NotNull(message = "Level is mandatory") Integer level, 
    @NotNull(message = "Health is mandatory") long health, 
    @NotNull(message = "Attack is mandatory") Integer attack, 
    @NotNull(message = "Defense is mandatory") Integer defense, 
    @NotNull(message = "Sp. Attack is mandatory") Integer spAttack, 
    @NotNull(message = "Sp. Defense is mandatory") Integer spDefense,
    @NotNull(message = "Speed is mandatory") Integer speed, 
    @NotNull(message = "Type is mandatory") String type,
    ArrayList<PokemonMove> moves)
    {
        this.id = id;
        this.name = name;
        this.level = level;
        this.health = health;
        this.sprite = name + ".gif";
        this.backsprite = name + "_back.gif";
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.type = type;

        this.moves = moves;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getLevel() {
        return level;
    }
    public void setLevel(Integer level) {
        this.level = level;
    }

    private ArrayList<PokemonMove> moves = new ArrayList<PokemonMove>();
    public ArrayList<PokemonMove> getMoves() { return moves; }
    //Adds a move if there are empty moves left.
    public void addMove(PokemonMove moveToAdd) {
        moves.add(moveToAdd);

    }
//    public void overwriteMove(PokeMove moveToAdd, int index){ moves.get(index) = moveToAdd; }



    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getBacksprite() {
        return backsprite;
    }

    public void setBacksprite(String backsprite) {
        this.backsprite = backsprite;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getSpAttack() {
        return spAttack;
    }

    public void setSpAttack(Integer spAttack) {
        this.spAttack = spAttack;
    }

    public Integer getSpDefense() {
        return spDefense;
    }

    public void setSpDefense(Integer spDefense) {
        this.spDefense = spDefense;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

//    public Type getType1() {
//        return type1;
//    }
//
//    public void setType1(Type type1) {
//        this.type1 = type1;
//    }
//
//    public Type getType2() {
//        return type2;
//    }
//
//    public void setType2(Type type2) {
//        this.type2 = type2;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
