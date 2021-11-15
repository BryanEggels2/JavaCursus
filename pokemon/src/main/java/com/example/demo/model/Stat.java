package com.example.demo.model;

public class Stat {
    private long base_stat;
    private long effort;
    private Species stat;

    public long getBaseStat() { return base_stat; }
    public void setBaseStat(long value) { this.base_stat = value; }

    public long getEffort() { return effort; }
    public void setEffort(long value) { this.effort = value; }

    public Species getStat() { return stat; }
    public void setStat(Species value) { this.stat = value; }
}
