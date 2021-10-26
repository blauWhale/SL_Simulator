import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeagueTableTest {
    LeagueTable leagueTable = new LeagueTable();

    @Test
    void createLeague() {
        leagueTable.createLeague();
        for (Team team:leagueTable.getListOfTeams()) {
            Assertions.assertEquals(0,team.getPoints());
        }
    }

    @Test
    void sortByGoalDifference() {
        leagueTable.createLeague();
        leagueTable.getListOfTeams().get(0).setPoints(10);

        leagueTable.getListOfTeams().get(1).setPoints(10);
        leagueTable.getListOfTeams().get(1).setGoalsScored(1);
        Team winner = leagueTable.getListOfTeams().get(1);
        leagueTable.sortLeagueTable(leagueTable.getListOfTeams());
        Assertions.assertEquals(winner, leagueTable.getListOfTeams().get(0));
        leagueTable.showLeagueTable(leagueTable.getListOfTeams());
    }
}