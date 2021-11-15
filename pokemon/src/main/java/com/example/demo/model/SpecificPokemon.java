package com.example.demo.model;

public class SpecificPokemon {
    private long id;
    private String name;
    private long baseExperience;
    private long height;
    private boolean isDefault;
    private long order;
    private long weight;
    private Ability[] abilities;
    private Species[] forms;
    private GameIndex[] gameIndices;
    private HeldItem[] heldItems;
    private String locationAreaEncounters;
    private Move[] moves;
    private Species species;
    private Sprites sprites;
    private Stat[] stats;
    private Type[] types;

    public SpecificPokemon(long id, String name, long baseExperience, long height, boolean isDefault, long order,
                           long weight, Ability[] abilities, Species[] forms, GameIndex[] gameIndices, HeldItem[] heldItems,
                           String locationAreaEncounters, Move[] moves, Species species, Sprites sprites, Stat[] stats, Type[] types) {
        this.id = id;
        this.name = name;
        this.baseExperience = baseExperience;
        this.height = height;
        this.isDefault = isDefault;
        this.order = order;
        this.weight = weight;
        this.abilities = abilities;
        this.forms = forms;
        this.gameIndices = gameIndices;
        this.heldItems = heldItems;
        this.locationAreaEncounters = locationAreaEncounters;
        this.moves = moves;
        this.species = species;
        this.sprites = sprites;
        this.stats = stats;
        this.types = types;
    }

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getBaseExperience() { return baseExperience; }
    public void setBaseExperience(long value) { this.baseExperience = value; }

    public long getHeight() { return height; }
    public void setHeight(long value) { this.height = value; }

    public boolean getIsDefault() { return isDefault; }
    public void setIsDefault(boolean value) { this.isDefault = value; }

    public long getOrder() { return order; }
    public void setOrder(long value) { this.order = value; }

    public long getWeight() { return weight; }
    public void setWeight(long value) { this.weight = value; }

    public Ability[] getAbilities() { return abilities; }
    public void setAbilities(Ability[] value) { this.abilities = value; }

    public Species[] getForms() { return forms; }
    public void setForms(Species[] value) { this.forms = value; }

    public GameIndex[] getGameIndices() { return gameIndices; }
    public void setGameIndices(GameIndex[] value) { this.gameIndices = value; }

    public HeldItem[] getHeldItems() { return heldItems; }
    public void setHeldItems(HeldItem[] value) { this.heldItems = value; }

    public String getLocationAreaEncounters() { return locationAreaEncounters; }
    public void setLocationAreaEncounters(String value) { this.locationAreaEncounters = value; }

    public Move[] getMoves() { return moves; }
    public void setMoves(Move[] value) { this.moves = value; }

    public Species getSpecies() { return species; }
    public void setSpecies(Species value) { this.species = value; }

    public Sprites getSprites() { return sprites; }
    public void setSprites(Sprites value) { this.sprites = value; }

    public Stat[] getStats() { return stats; }
    public void setStats(Stat[] value) { this.stats = value; }

    public Type[] getTypes() { return types; }
    public void setTypes(Type[] value) { this.types = value; }
}
