package com.example.demo.controllers;

import com.example.demo.entities.*;
import com.example.demo.model.SpecificPokemon;
import com.example.demo.model.Type;
import com.example.demo.repositories.PokemonMoveRepository;
import com.example.demo.repositories.PokemonDBRepository;
import com.example.demo.repositories.PokemonRepository;
import com.google.gson.Gson;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

@Controller
public class PokemonController {
    private final PokemonRepository pokemonRepository;
    private final PokemonMoveRepository pokemonMoveRepository;
    private final PokemonDBRepository pokemonDBRepository;

    @Autowired
    public PokemonController(PokemonRepository pokemonRepository, PokemonDBRepository pokemonDBRepository,
                             PokemonMoveRepository pokemonMoveRepository) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonDBRepository = pokemonDBRepository;
        this.pokemonMoveRepository = pokemonMoveRepository;
    }

    @GetMapping("/index")
    public String showPokemonList(Model model) throws IOException, ParseException {
        JSONObject json = APIController.getHttpRequest(new URL("https://pokeapi.co/api/v2/pokemon?limit=151"));
        List<Pokemon> pokemons2 = new ArrayList<>();
        List<PokemonDB> pokemons = APIController.getAllPokemon(json);
        pokemonDBRepository.saveAll(pokemons);

        model.addAttribute("pokemons", pokemons2);

        specificPokemons();

        model.addAttribute("pokemons", pokemonRepository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Pokemon pokemon) {
        return "add-pokemon";
    }

    @PostMapping("/addpokemon")
    public String addPokemon(@Valid Pokemon pokemon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-pokemon";
        }

        pokemonRepository.save(pokemon);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid pokemon Id:" + id));
        model.addAttribute("pokemon", pokemon);

        return "update-pokemon";
    }

    @PostMapping("/update/{id}")
    public String updatePokemon(@PathVariable("id") long id, @Valid Pokemon pokemon, BindingResult result, Model model) {
        if (result.hasErrors()) {
            pokemon.setId(id);
            return "update-pokemon";
        }

        pokemonRepository.save(pokemon);

        return "redirect:/index";
    }

    @GetMapping("/battle")
    public String attack(Model model, Battle battle){
        battle.getEnemy().getPokemon().setHealth(battle.getEnemy().getPokemon().getHealth() - battle.getPlayer().getPokemon().getAttack());
        model.addAttribute("battle", battle);

        return "battle";
    }

    @GetMapping("/delete/{id}")
    public String deletePokemon(@PathVariable("id") long id, Model model) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid pokemon Id:" + id));
        pokemonRepository.delete(pokemon);

        return "redirect:/index";
    }

    @GetMapping("/startBattle")
    public String startBattle(Model model) throws IOException, ParseException {

        Random random = new Random();
        Player player = new Player(specificPokemon(random.nextInt(151) + 1));
        Player enemy = new Player(specificPokemon(random.nextInt(151) + 1));

        Battle battle = new Battle(player, enemy);

        model.addAttribute("battle", battle);

        System.out.println("Testing Combat Info");

        return "battle";
    }
    /**
     * Get Specific pokemon
     * @throws IOException
     * @throws ParseException
     */
    public Pokemon specificPokemon(int id) throws IOException, ParseException {

//        for (int j = 1; j < 151; j++) {
            JSONObject json = APIController.getHttpRequest(new URL("https://pokeapi.co/api/v2/pokemon/" + id));

            SpecificPokemon specificPokemon = new Gson().fromJson(String.valueOf(json), SpecificPokemon.class);

            String name = specificPokemon.getName();
            String type = specificPokemon.getTypes()[0].getType().getName();
            Integer level = 100;
            int health = (int)specificPokemon.getStats()[0].getBaseStat();
            int attack = (int)specificPokemon.getStats()[1].getBaseStat();
            int defense = (int)specificPokemon.getStats()[2].getBaseStat();
            int spAttack = (int)specificPokemon.getStats()[3].getBaseStat();
            int spDefense = (int)specificPokemon.getStats()[4].getBaseStat();
            int speed = (int)specificPokemon.getStats()[5].getBaseStat();

            ArrayList<PokemonMove> pokemonMoveArrayList = new ArrayList<>();

            //Get 4 random moves from the specific pokemon
            for (int i = 0; i < 4; i++) {
                Random ran = new Random();
                int x = ran.nextInt(specificPokemon.getMoves().length);

                PokemonMove pokemonMove = new PokemonMove(specificPokemon.getMoves()[x].getMove().getName());

                System.out.println("base stat: " + specificPokemon.getStats()[i].getBaseStat());

                System.out.println("name stat: "  + specificPokemon.getStats()[i].getStat().getName());

                pokemonMoveArrayList.add(pokemonMove);
            }

            Pokemon pokemon = new Pokemon(id, name, level, health, attack, defense, spAttack, spDefense,
                speed, type, pokemonMoveArrayList);

//            pokemonMoveRepository.saveAll(pokemonMoveArrayList);
//
//            pokemonRepository.save(pokemon);

            return pokemon;


//        }
    }
    public void specificPokemons() throws IOException, ParseException {

        for (int j = 1; j < 151; j++) {
            JSONObject json = APIController.getHttpRequest(new URL("https://pokeapi.co/api/v2/pokemon/" + j));

            SpecificPokemon specificPokemon = new Gson().fromJson(String.valueOf(json), SpecificPokemon.class);

            String name = specificPokemon.getName();
            String type = specificPokemon.getTypes()[0].getType().getName();
            Integer level = 100;
            int health = (int)specificPokemon.getStats()[0].getBaseStat();
            int attack = (int)specificPokemon.getStats()[1].getBaseStat();
            int defense = (int)specificPokemon.getStats()[2].getBaseStat();
            int spAttack = (int)specificPokemon.getStats()[3].getBaseStat();
            int spDefense = (int)specificPokemon.getStats()[4].getBaseStat();
            int speed = (int)specificPokemon.getStats()[5].getBaseStat();

            ArrayList<PokemonMove> pokemonMoveArrayList = new ArrayList<>();

            //Get 4 random moves from the specific pokemon
//            for (int i = 0; i < 4; i++) {
//                Random ran = new Random();
//                int x = ran.nextInt(specificPokemon.getMoves().length);
//
////                PokemonMove pokemonMove = new PokemonMove(specificPokemon.getMoves()[x].getMove().getName());
//
//                System.out.println("base stat: " + specificPokemon.getStats()[i].getBaseStat());
//
//                System.out.println("name stat: "  + specificPokemon.getStats()[i].getStat().getName());
//
//                pokemonMoveArrayList.add(pokemonMove);
//            }

            Pokemon pokemon = new Pokemon(j, name, level, health, attack, defense, spAttack, spDefense,
                    speed, type, pokemonMoveArrayList);

//            pokemonMoveRepository.saveAll(pokemonMoveArrayList);
//
            pokemonRepository.save(pokemon);
        }
    }
}
