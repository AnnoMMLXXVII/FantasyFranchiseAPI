package com.fafr.model.schedule;

import com.fafr.model.team.Team;

import java.util.List;
import java.util.Map;

public class Schedule {

    // Attributes
    private Map<Team, Team> prevMet;

    private Team teamOne;
    private Team teamTwo;

    private int numRegularWeek;
    private int numHomeGames;
    private int numAwayGames;


//    private int numPlayoffWeek;
//    private boolean isPlayoffs;

    // Constructors
    public Schedule() {
    }

    public Schedule(Map<Team, Team> prevMet, Team teamOne, Team teamTwo, int numRegularWeek, int numHomeGames, int numAwayGames) {
        this.prevMet = prevMet;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.numRegularWeek = numRegularWeek;
        this.numHomeGames = numHomeGames;
        this.numAwayGames = numAwayGames;
    }


    // Setters & Getters
    public Map<Team, Team> getPrevMet() {
        return prevMet;
    }

    public void setPrevMet(Map<Team, Team> prevMet) {
        this.prevMet = prevMet;
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }

    public int getNumRegularWeek() {
        return numRegularWeek;
    }

    public void setNumRegularWeek(int numRegularWeek) {
        this.numRegularWeek = numRegularWeek;
    }

    public int getNumHomeGames() {
        return numHomeGames;
    }

    public void setNumHomeGames(int numHomeGames) {
        this.numHomeGames = numHomeGames;
    }

    public int getNumAwayGames() {
        return numAwayGames;
    }

    public void setNumAwayGames(int numAwayGames) {
        this.numAwayGames = numAwayGames;
    }


    // Methods
    public boolean ruleOneFulfilled(Team thisTeam, List<Team> scheduledTeams, List<Character> location) {
        int homeCounter = 0;
        int awayCounter = 0;
        int divCounter = 0;
        boolean sixGamesinDiv = false;
        String teamsDiv = thisTeam.getDivision();

        for (int i = 0; i < scheduledTeams.size(); i++) {

            // Check if not in same division
            Team currTeam = scheduledTeams.get(i);
            if (currTeam.getDivision().equals(teamsDiv)) {
                divCounter += 1;
                if (divCounter == 6) {
                    sixGamesinDiv = true;
                    break;
                }
            }

            // Check if their home or away
            if (location.get(i) == 'H') {
                homeCounter += 1;
            } else if (location.get(i) == 'A') {
                awayCounter += 1;
            }
        } // end for

        return (sixGamesinDiv && homeCounter >= 2 && awayCounter >= 2);
    }

    // Change to object
    public boolean ruleTwoFulfilled(Team thisTeam, List<Team> scheduledTeams, List<Character> location) {
        int homeCounter = 0;
        int awayCounter = 0;
        int conferenceCounter = 0;
        boolean fourGamesInConf = false;
        String teamsConf = thisTeam.getConference();

        for (int i = 0; i < scheduledTeams.size(); i++) {

            // Check if not in same confrence
            Team currTeam = scheduledTeams.get(i);
            if (currTeam.getConference().equals(teamsConf)) {
                conferenceCounter += 1;
                if (conferenceCounter == 4) {
                    fourGamesInConf = true;
                    break;
                }
            }


            // Check if their home or away
            if (location.get(i) == 'H') {
                homeCounter += 1;
            } else if (location.get(i) == 'A') {
                awayCounter += 1;
            }
        } // end for
        return (fourGamesInConf && homeCounter >= 2 && awayCounter >= 2);
    }


    // RAVENSSCHED = [BUCKS, PATS, STEELERS]\
    // RAVENSLOC  =  [H ,    A,     H]
    // Change to object
    public boolean ruleThreeFulfilled(Team thisTeam, List<Team> scheduledTeams, List<Character> location) {
        int homeCounter = 0;
        int awayCounter = 0;
        int conferenceCounter = 0;
        boolean fourGamesInConf = false;
        String teamsConf = thisTeam.getConference();

        for (int i = 0; i < scheduledTeams.size(); i++) {

            // Check if not in same confrence
            Team currTeam = scheduledTeams.get(i);
            if (!currTeam.getConference().equals(teamsConf)) {
                conferenceCounter += 1;
                if (conferenceCounter == 4) {
                    fourGamesInConf = true;
                    break;
                }
            }

            // Check if their home or away
            if (location.get(i) == 'H') {
                homeCounter += 1;
            } else if (location.get(i) == 'A') {
                awayCounter += 1;
            }
        } // end for

        return (fourGamesInConf && homeCounter >= 2 && awayCounter >= 2);
    }
}


