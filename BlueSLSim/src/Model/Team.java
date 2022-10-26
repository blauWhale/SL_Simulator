package Model;

import java.util.ArrayList;

/**
 * Simple Java Object to host all data for a Model.Team
 */
public class Team {

    private int id;
    private String name;
    private Rating rating;
    private Integer points;
    private int goalsScored;
    private int goalsConceded;
    private int wins;
    private int draws;
    private int loses;
    private int games;
    private ArrayList<Player> players;


    public Team(String name, Rating rating) {
        this.name = name;
        this.rating = rating;
        this.points = 0;
        this.goalsScored =0;
        this.goalsConceded = 0;
        this.wins = 0;
        this.draws = 0;
        this.loses = 0;
        this.games = 0;
    }

    public Team(){
        this.points = 0;
        this.goalsScored =0;
        this.goalsConceded = 0;
        this.wins = 0;
        this.draws = 0;
        this.loses = 0;
        this.games = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
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

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    @Override
    public String toString() {
        return name + " |" + "Games: "+games+" | "+"Points: " +points + " | " + goalsScored +":"+goalsConceded + " | " + (goalsScored-goalsConceded) + " | " +  "W"+wins+"D"+draws+"L"+loses;
    }

}
