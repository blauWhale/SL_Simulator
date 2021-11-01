import dnl.utils.text.table.TextTable;

import java.util.ArrayList;
import java.util.Arrays;

public class LeagueTable {
    ArrayList<Team> listOfTeams = new ArrayList<>();
    public ArrayList<Team> createLeague(){
        listOfTeams.removeAll(listOfTeams);
        listOfTeams.add(new Team("FC Zürich",new Rating(7,5)));
        listOfTeams.add(new Team("Grasshopper Club Zürich",new Rating(5,6)));
        listOfTeams.add(new Team("FC Lugano",new Rating(4,5)));
        listOfTeams.add(new Team("FC Lausanne-Sport",new Rating(3,3)));
        listOfTeams.add(new Team("FC St. Gallen",new Rating(4,4)));
        listOfTeams.add(new Team("Servette FC",new Rating(5,5)));
        listOfTeams.add(new Team("FC Sion",new Rating(4,4)));
        listOfTeams.add(new Team("FC Luzern",new Rating(6,6)));
        listOfTeams.add(new Team("FC Basel 1893",new Rating(7,6)));
        listOfTeams.add(new Team("BSC Young Boys",new Rating(7,7)));
        return listOfTeams;
    }

    public ArrayList<Team> sortLeagueTable(ArrayList<Team> listOfTeams){
        listOfTeams.sort(new Rule());
        return listOfTeams;
    }

    public void showLeagueTable(ArrayList<Team> listOfTeams){
        sortLeagueTable(listOfTeams);
        for(int i = 0; i<=listOfTeams.size()-1;i++){
            System.out.println(  i+1 + ". " + listOfTeams.get(i));
        }
    }

    public ArrayList<Team> getListOfTeams() {
        return listOfTeams;
    }

    public void setListOfTeams(ArrayList<Team> listOfTeams) {
        this.listOfTeams = listOfTeams;
    }
}
