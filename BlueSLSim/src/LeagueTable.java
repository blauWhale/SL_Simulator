import util.RandomHelper;

import java.util.ArrayList;

public class LeagueTable {
    private ArrayList<Team> listOfTeams = new ArrayList<>();
    public ArrayList<Team> createLeague(){
        listOfTeams.add(new Team("FC Zürich",15,12));
        listOfTeams.add(new Team("Grasshopper Club Zürich",11,12));
        listOfTeams.add(new Team("FC Lugano",10,12));
        listOfTeams.add(new Team("FC Lausanne-Sport",9,9));
        listOfTeams.add(new Team("FC St. Gallen",10,10));
        listOfTeams.add(new Team("Servette FC",12,12));
        listOfTeams.add(new Team("FC Sion",10,10));
        listOfTeams.add(new Team("FC Luzern",13,13));
        listOfTeams.add(new Team("FC Basel 1893",17,16));
        listOfTeams.add(new Team("BSC Young Boys",17,17));
        return listOfTeams;
    }

    public void showLeagueTable(ArrayList<Team> listOfTeams){
        listOfTeams.sort(new Rule());
        for(int i = 0; i<=listOfTeams.size()-1;i++){
            System.out.println(  i+1 + ". " + listOfTeams.get(i));
        }
    }
}
