package com.fafr.model.schedule;
import com.fafr.model.team.Team;

import java.util.List;
import java.util.Map;

public class Schedule {

    // Attributes
    private Map<Team,Team> prevMet;

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

    public boolean ruleOneFulfilled(Team thisTeam, List<Team> scheduledTeams, int gamesAtHome, int gamesAway) {
        int divCounter = 0;
        boolean sixGamesInDiv = false;
        String teamsDiv = thisTeam.getDivision();

        for (Team currTeam : scheduledTeams) {
            if (currTeam.getDivision().equals(teamsDiv)) {
                divCounter += 1;
                if (divCounter == 6) {
                    sixGamesInDiv = true;
                    break;
                }
            }
        }

        return (sixGamesInDiv && gamesAtHome >= 1 && gamesAway >= 1);
    }

    public boolean ruleTwoFulfilled(Team thisTeam, List<Team> scheduledTeams, int gamesAtHome, int gamesAway) {
        int conferenceCounter = 0;
        boolean fourGamesInConf = false;
        String teamsConf = thisTeam.getConference();

        for (Team currTeam : scheduledTeams) {
            if (currTeam.getConference().equals(teamsConf)) {
                conferenceCounter += 1;
                if (conferenceCounter == 4) {
                    fourGamesInConf = true;
                    break;
                }
            }
        }

        return (fourGamesInConf && gamesAtHome >= 2 && gamesAway >= 2);  // change away and home counter to find
                                                                        // a way to track which team is home or away
    }

    public boolean ruleThreeFulfilled(Team thisTeam, List<Team> scheduledTeams, int gamesAtHome, int gamesAway) {
        int conferenceCounter = 0;
        boolean fourGamesInConf = false;
        String teamsConf = thisTeam.getConference();

        for (Team currTeam : scheduledTeams) {
            if (!(currTeam.getConference().equals(teamsConf))) {
                conferenceCounter += 1;
                if (conferenceCounter == 4) {
                    fourGamesInConf = true;
                    break;
                }
            }
        }

        return (fourGamesInConf && gamesAtHome >= 2 && gamesAway >= 2);
    }


}


