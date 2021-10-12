import java.util.ArrayList;

public class LeagueTable {

    public ArrayList<Team> createLeague(){
        ArrayList<Team> listOfTeams = new ArrayList<>();
        listOfTeams.add(new Team("FC Zürich",16,14));
        listOfTeams.add(new Team("Grasshopper Club Zürich",13,14));
        listOfTeams.add(new Team("FC Lugano",12,14));
        listOfTeams.add(new Team("FC Lausanne-Sport",11,11));
        listOfTeams.add(new Team("FC St. Gallen",12,12));
        listOfTeams.add(new Team("Servette FC",13,13));
        listOfTeams.add(new Team("FC Sion",12,12));
        listOfTeams.add(new Team("FC Luzern",14,14));
        listOfTeams.add(new Team("FC Basel 1893",17,16));
        listOfTeams.add(new Team("BSC Young Boys",17,17));
        return listOfTeams;
    }

    public ArrayList<Team> sortLeagueTable(ArrayList<Team> listOfTeams){
        listOfTeams.sort(new Rule());
        return listOfTeams;
    }

    public void showLeagueTable(ArrayList<Team> listOfTeams){
        for(int i = 0; i<=listOfTeams.size()-1;i++){
            System.out.println(  i+1 + ". " + listOfTeams.get(i));
        }
    }
}
