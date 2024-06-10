package com.curso.android.app.practica.planetsapp;

public class Planet {

// this cla is used as a Model class (blueprint) for the planet.

    //Atributes
    private String planetName;
    private String moonCount;
    private int planetImage;

    //Constructor
    public Planet(String planetName, String moonCount, int planetImage) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.planetImage = planetImage;
    }

    //Getters and setters
    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getMoonCount() {
        return moonCount;
    }

    public void setMoonCount(String moonCount) {
        this.moonCount = moonCount;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }
}
