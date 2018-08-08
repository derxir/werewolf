package com.werewolf.model.request;

public class NewGameRequest extends RequestContext{

    private int WolfQuantity;

    private int VillagerQuantity;

    private int[] otherRoles;

    private int totalNumberOfRoles;

    public int getWolfQuantity() {
        return WolfQuantity;
    }

    public void setWolfQuantity(int wolfQuantity) {
        WolfQuantity = wolfQuantity;
    }

    public int getVillagerQuantity() {
        return VillagerQuantity;
    }

    public void setVillagerQuantity(int villagerQuantity) {
        VillagerQuantity = villagerQuantity;
    }

    public int[] getOtherRoles() {
        return otherRoles;
    }

    public void setOtherRoles(int[] otherRoles) {
        this.otherRoles = otherRoles;
    }

    public int getTotalNumberOfRoles() {
        return totalNumberOfRoles;
    }

    public void setTotalNumberOfRoles(int totalNumberOfRoles) {
        this.totalNumberOfRoles = totalNumberOfRoles;
    }
}
