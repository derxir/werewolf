package com.werewolf.model;

import com.werewolf.GameState;
import com.werewolf.model.roles.Baichi;
import com.werewolf.model.roles.Role;
import com.werewolf.model.roles.Villager;
import com.werewolf.model.roles.Wolf;

import java.util.LinkedList;
import java.util.List;

public class Game {

    private List<Role> players;

    private int roomId;

    private GameState state;

    public List<Role> getPlayers() {
        return players;
    }

    public int getRoomId() {
        return roomId;
    }

    public GameState getState() {
        return state;
    }

    public int getNightCounter() {
        return nightCounter;
    }

    private int nightCounter;

    public static class Builder {
        private List<Role> players;

        public Builder() {
            players = new LinkedList<>();
        }

        public Builder wolf(int number) {
            for (int i = 0; i < number; i++) {
                players.add(new Wolf());
            }
            return this;
        }

        public Builder villager(int number){
            for (int i = 0; i < number; i++) {
                players.add(new Villager());
            }
            return this;
        }

        public Builder withBaichi(){
            players.add(new Baichi());
            return this;
        }

        public Game build(){
            Game game = new Game();
            game.players = this.players;
            game.state = GameState.NEW;
            game.nightCounter = 0;
            return game;
        }

    }


}
