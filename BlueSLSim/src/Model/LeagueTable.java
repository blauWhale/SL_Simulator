package Model;

import Json.JsonReader;

import java.util.ArrayList;

/**
 * Used for creating, altering and sorting the league table
 */
public class LeagueTable {
    private ArrayList<Team> teams = new ArrayList<>();
    private JsonReader jsonReader = new JsonReader();
    /**
     * Reads a JSON File of Teams and creates a league for them
     * @return Empty Super League Table
     */
    public ArrayList<Team> createLeague(){
        teams.removeAll(teams);
        teams = jsonReader.scanJson();
        return teams;
    }

    /**
     * Used for end of the Season sorting of the Teams in the Table
     * @param listOfTeams to Sort
     * @return sorted Table
     */
    public ArrayList<Team> sortLeagueTable(ArrayList<Team> listOfTeams){
        listOfTeams.sort(new Rule());
        return listOfTeams;
    }

    /**
     * Prints Table of sorted League Table
     *
     * @param listOfTeams
     */
    public void showLeagueTable(ArrayList<Team> listOfTeams){
        sortLeagueTable(listOfTeams);
        for(int i = 0; i<=listOfTeams.size()-1;i++){
            System.out.println(  i+1 + ". " + listOfTeams.get(i));
        }
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }
}
