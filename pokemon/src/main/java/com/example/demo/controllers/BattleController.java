package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class BattleController {

    @GetMapping("/battle")
    public String getBattler1(){
        return "Hello :D";
    }
}
