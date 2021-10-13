import java.util.ArrayList;

public class LeagueTable {
    ArrayList<Team> listOfTeams = new ArrayList<>();
    public ArrayList<Team> createLeague(){
        listOfTeams.removeAll(listOfTeams);
        listOfTeams.add(new Team("FC Zürich",7,5));
        listOfTeams.add(new Team("Grasshopper Club Zürich",5,6));
        listOfTeams.add(new Team("FC Lugano",4,5));
        listOfTeams.add(new Team("FC Lausanne-Sport",3,3));
        listOfTeams.add(new Team("FC St. Gallen",4,4));
        listOfTeams.add(new Team("Servette FC",5,5));
        listOfTeams.add(new Team("FC Sion",4,4));
        listOfTeams.add(new Team("FC Luzern",6,6));
        listOfTeams.add(new Team("FC Basel 1893",7,6));
        listOfTeams.add(new Team("BSC Young Boys",7,7));
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
