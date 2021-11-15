package com.example.demo.model;

public class HeldItem {
    private Species item;
    private VersionDetail[] versionDetails;

    public Species getItem() { return item; }
    public void setItem(Species value) { this.item = value; }

    public VersionDetail[] getVersionDetails() { return versionDetails; }
    public void setVersionDetails(VersionDetail[] value) { this.versionDetails = value; }
}
