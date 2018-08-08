package com.werewolf.model.roles;

public class Villager implements Role {

    @Override
    public String getName() {
        return "Villager";
    }

    @Override
    public boolean hasSkill() {
        return false;
    }
}
