import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LeagueTable leagueTable = new LeagueTable();
        MatchEngine matchEngine = new MatchEngine();
        ArrayList<Team> superLeagueTeams = leagueTable.createLeague();



        for(int i = 0;i<=superLeagueTeams.size()-1;i++) {
            for(int j=0;j<=superLeagueTeams.size()-1;j++){
                if(i==j){
                   //skip
                }
                else {
                    matchEngine.calculateMatchDay(superLeagueTeams.get(i),superLeagueTeams.get(j));
                }

            }

        }
       leagueTable.showLeagueTable(superLeagueTeams);




    }
}
