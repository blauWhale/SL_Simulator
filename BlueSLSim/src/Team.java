import java.util.ArrayList;

/**
 * Simple Java Object to host all data for a Team
 */
public class Team {

    private String teamName;
    private Rating rating;
    private Integer points;
    private int goalsScored;
    private int goalsConceded;
    private int wins;
    private int draws;
    private int loses;
    private int games;
    private ArrayList<Player> players;


    public Team(String teamName, Rating rating) {
        this.teamName = teamName;
        this.rating = rating;
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
        return teamName + " |" + "Games: "+games+" | "+"Points: " +points + " | " + goalsScored +":"+goalsConceded + " | " + (goalsScored-goalsConceded) + " | " +  "W"+wins+"D"+draws+"L"+loses;
    }

}
