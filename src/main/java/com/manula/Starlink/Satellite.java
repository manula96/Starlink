package com.manula.Starlink;

import javax.persistence.Id;

public class Satellite {
    @Id
    private String id;
    private String constellation;
    private String orbit;
    private String health;

    public Satellite(){}


    //Constructor
    public Satellite(String id, String constellation, String orbit, String health) {
        this.id = id;
        this.constellation = constellation;
        this.orbit = orbit;
        this.health = health;
    }


    //Getters and Setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }


}
