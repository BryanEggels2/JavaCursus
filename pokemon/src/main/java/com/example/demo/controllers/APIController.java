package com.example.demo.controllers;

import com.example.demo.entities.Pokemon;
import com.example.demo.entities.PokemonDB;
import com.example.demo.repositories.PokemonRepository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class APIController {

    public static JSONObject getHttpRequest(URL url) throws IOException, ParseException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        Scanner scanner = new Scanner(url.openStream());
        String response = scanner.useDelimiter("\\Z").next();

        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(response);
    }

    public static List<PokemonDB> getAllPokemon(JSONObject json){
        JSONArray object = (JSONArray) json.get("results");
        Type listType = new TypeToken<List<PokemonDB>>() {}.getType();
        return new Gson().fromJson(object.toJSONString(), listType);

    }

}
