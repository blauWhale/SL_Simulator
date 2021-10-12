import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LeagueTable leagueTable = new LeagueTable();
        MatchEngine matchEngine = new MatchEngine();
        boolean rareCase =true;
        int counter = 0;

        ArrayList<Team> superLeagueTeams = leagueTable.createLeague();
        playRound(matchEngine, superLeagueTeams);
        playRound(matchEngine, superLeagueTeams);
        leagueTable.showLeagueTable(leagueTable.sortLeagueTable(superLeagueTeams));


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
}
