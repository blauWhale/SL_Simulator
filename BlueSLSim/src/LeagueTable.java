import java.util.ArrayList;

public class LeagueTable {
    private ArrayList<Team> listOfTeams = new ArrayList<>();

    public ArrayList<Team> createLeague(){
        listOfTeams.add(new Team("FC Zürich",67,0,0,0,0,0,0,0));
        listOfTeams.add(new Team("Grasshopper Club Zürich",67,0,0,0,0,0,0,0));
        listOfTeams.add(new Team("FC Lugano",66,0,0,0,0,0,0,0));
        listOfTeams.add(new Team("FC Lausanne-Sport",65,0,0,0,0,0,0,0));
        listOfTeams.add(new Team("FC St. Gallen",65,0,0,0,0,0,0,0));
        listOfTeams.add(new Team("Servette FC",68,0,0,0,0,0,0,0));
        listOfTeams.add(new Team("FC Sion",68,0,0,0,0,0,0,0));
        listOfTeams.add(new Team("FC Luzern",69,0,0,0,0,0,0,0));
        listOfTeams.add(new Team("FC Basel 1893",71,0,0,0,0,0,0,0));
        listOfTeams.add(new Team("BSC Young Boys",72,0,0,0,0,0,0,0));
        return listOfTeams;
    }

    public void showLeagueTable(ArrayList<Team> listOfTeams){
        listOfTeams.sort(new Rule());
        for(int i = 0; i<=listOfTeams.size()-1;i++){
            System.out.println(  i+1 + ". " + listOfTeams.get(i));
        }
    }
}
