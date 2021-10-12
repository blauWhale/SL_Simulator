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
    private int offensiveRating;
    private int defensiveRating;
    private Integer points;
    private int goalsScored;
    private int goalsConceded;
    private int wins;
    private int draws;
    private int loses;
    private int games;


    public Team(String teamName, int offensiveRating, int defensiveRating) {
        this.teamName = teamName;
        this.offensiveRating = offensiveRating;
        this.defensiveRating = defensiveRating;
        this.points = 0;
        this.goalsScored =0;
        this.goalsConceded = 0;
        this.wins = 0;
        this.draws = 0;
        this.loses = 0;
        this.games = 0;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getOffensiveRating() {
        return offensiveRating;
    }

    public void setOffensiveRating(int offensiveRating) {
        this.offensiveRating = offensiveRating;
    }

    public int getDefensiveRating() {
        return defensiveRating;
    }

    public void setDefensiveRating(int defensiveRating) {
        this.defensiveRating = defensiveRating;
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
