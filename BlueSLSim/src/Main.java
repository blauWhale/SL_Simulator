import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static int counter = 0;

    public static void main(String[] args) {
        LeagueTable leagueTable = new LeagueTable();
        MatchEngine matchEngine = new MatchEngine();


//        ArrayList<Team> superLeagueTeams = leagueTable.createLeague();
//        playRound(matchEngine, superLeagueTeams);
//        playRound(matchEngine, superLeagueTeams);
//        leagueTable.showLeagueTable(leagueTable.sortLeagueTable(superLeagueTeams));
        sim(matchEngine,leagueTable);

    }


    private static void playRound(MatchEngine matchEngine, ArrayList<Team> superLeagueTeams) {
        for (int i = 0; i <= superLeagueTeams.size() - 1; i++) {
            for (int j = 0; j <= superLeagueTeams.size() - 1; j++) {
                if (i == j) {
                    //skip
                } else {
                    matchEngine.calculateMatchDay(superLeagueTeams.get(i), superLeagueTeams.get(j));
                }

            }

        }
    }

    private static void sim(MatchEngine matchEngine, LeagueTable leagueTable){
        for(int i = 0; i < 25; i++){
            ArrayList<Team> superLeagueTeams = leagueTable.createLeague();
            playRound(matchEngine,superLeagueTeams);
            playRound(matchEngine,superLeagueTeams);
            leagueTable.sortLeagueTable(superLeagueTeams);
            System.out.println(superLeagueTeams.get(0).getTeamName());

//            if(superLeagueTeams.get(0).getTeamName().equals("FC Luzern")){
//                leagueTable.showLeagueTable(superLeagueTeams);
//                System.out.println(counter);
//                break;
//            }
//            else{
//                counter++;
//            }
        }

    }
}
