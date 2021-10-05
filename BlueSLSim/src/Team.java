/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author win7
 */
public class Team {

    private String teamName;
    private int teamRating;
    private Integer points;
    private int goalsScored;
    private int goalsConceded;
    private int wins;
    private int draws;
    private int loses;
    private int games;

    public Team(String teamName, int teamRating){
        this.teamName=teamName;
        this.teamRating=teamRating;
    }

    public Team(String teamName, int teamRating, Integer points, int goalsScored, int goalsConceded, int wins, int draws, int loses, int games) {
        this.teamName = teamName;
        this.teamRating = teamRating;
        this.points = points;
        this.goalsScored = goalsScored;
        this.goalsConceded = goalsConceded;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
        this.games = games;
    }

    public String getTeamName(){
        return this.teamName;
    }
    
    public int getTeamRating(){
        return this.teamRating;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return teamName + " | " + "Games: "+games+" | "+"Points: " +points + " | " + goalsScored +":"+goalsConceded + " | " + "W"+wins+"D"+draws+"L"+loses;
    }
}
