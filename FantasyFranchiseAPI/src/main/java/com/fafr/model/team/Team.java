package com.fafr.model.team;

import com.fafr.model.schedule.Schedule;

import java.util.Map;

public class Team {

    // Attributes
    private String name;             // Set list
    private String city;
    private String division;       // Set list
    private String conference;    // Set list
    private String abbreviation; // Set list

    private Map<Integer,Integer> record;

    private int numPlayers;
    private Schedule schedule;


    // Constructors
    public Team(String name, String city, String division, String conference, String abbreviation,
                                  int numPlayers, Schedule schedule, Map<Integer,Integer> record) {
        this.name = name;
        this.city = city;
        this.division = division;
        this.conference = conference;
        this.abbreviation = abbreviation;
        this.numPlayers = numPlayers;
        this.schedule = schedule;
        this.record = record;
    }

    public Team(){

    }


    // Setters & Getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
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

    public Map<Integer, Integer> getRecord() {
        return record;
    }

    public void setRecord(Map<Integer, Integer> record) {
        this.record = record;
    }


    // Methods
}
