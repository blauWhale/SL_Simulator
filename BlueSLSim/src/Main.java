import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LeagueTable leagueTable = new LeagueTable();
        MatchEngine matchEngine = new MatchEngine();
        ArrayList<Team> superLeagueTeams = leagueTable.createLeague();

        //Result result =  matchEngine.calculateMatchDay(superLeagueTeams.get(0),superLeagueTeams.get(1));
        //System.out.println(result);


        for(int i = 0;i<superLeagueTeams.size()-1;i++) {
            for(int j=1;j<=superLeagueTeams.size()-1;j++){
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
