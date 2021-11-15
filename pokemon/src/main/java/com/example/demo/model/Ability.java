package com.example.demo.model;

public class Ability {
    private boolean isHidden;
    private long slot;
    private Species ability;

    public boolean getIsHidden() { return isHidden; }
    public void setIsHidden(boolean value) { this.isHidden = value; }

    public long getSlot() { return slot; }
    public void setSlot(long value) { this.slot = value; }

    public Species getAbility() { return ability; }
    public void setAbility(Species value) { this.ability = value; }
}
