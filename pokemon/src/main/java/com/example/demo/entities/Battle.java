package com.example.demo.entities;

public class Battle {
    private Player player;
    private Player enemy;

    public Battle(Player player, Player enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getEnemy() {
        return enemy;
    }

    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
}
