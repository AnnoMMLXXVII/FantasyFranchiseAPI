package com.fafr.model;

public class Team {
    private String name;             // Set list
    private String city;
    private String division;       // Set list
    private String conference;    // Set list
    private String abbreviation; // Set list

    private int numPlayers;
    // Private Schedule schedule;


    public Team(String name, String city, String division, String conference, String abbreviation, int numPlayers) {
        this.name = name;
        this.city = city;
        this.division = division;
        this.conference = conference;
        this.abbreviation = abbreviation;
        this.numPlayers = numPlayers;
    }

    public Team(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }
}
