import Engine.MatchEngine;
import Model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MatchEngineTest {
    MatchEngine matchEngine;
    Team blueTeam;
    Team redTeam;
    @BeforeEach
    void setUp() {

        this.matchEngine = new MatchEngine();
        blueTeam = new Team("Strong FC", new Rating(7, 7));
        redTeam = new Team("Weak United", new Rating(2, 2));

        Midfielder blueMidfielder1 = new Midfielder("Jack Blue", new Rating(9, 9), "Model.Midfielder");
        Midfielder blueMidfielder2 = new Midfielder("Jack Blue", new Rating(9, 9), "Model.Midfielder");
        Midfielder blueMidfielder3 = new Midfielder("Jack Blue", new Rating(9, 9), "Model.Midfielder");
        Midfielder blueMidfielder4 = new Midfielder("Jack Blue", new Rating(9, 9), "Model.Midfielder");
        Striker blueStriker1 = new Striker("John Blue", new Rating(9, 9), "Model.Striker");
        Striker blueStriker2 = new Striker("John Blue", new Rating(9, 9), "Model.Striker");
        Defender blueDefender1 = new Defender("Garry Red", new Rating(9, 9), "Model.Defender");
        Defender blueDefender2 = new Defender("Garry Red", new Rating(9, 9), "Model.Defender");
        Defender blueDefender3 = new Defender("Garry Red", new Rating(9, 9), "Model.Defender");
        Defender blueDefender4 = new Defender("Garry Red", new Rating(9, 9), "Model.Defender");
        Goalkeeper blueGoalKeeper1 = new Goalkeeper("Tyler Red", new Rating(9, 9), "Model.Goalkeeper");

        Midfielder redMidfielder1 = new Midfielder("Jack Blue", new Rating(2, 2), "Model.Midfielder");
        Midfielder redMidfielder2 = new Midfielder("Jack Blue", new Rating(2, 2), "Model.Midfielder");
        Midfielder redMidfielder3 = new Midfielder("Jack Blue", new Rating(2, 2), "Model.Midfielder");
        Midfielder redMidfielder4 = new Midfielder("Jack Blue", new Rating(2, 2), "Model.Midfielder");
        Striker redStriker1 = new Striker("John Blue", new Rating(2, 2), "Model.Striker");
        Striker redStriker2 = new Striker("John Blue", new Rating(2, 2), "Model.Striker");
        Defender redDefender1 = new Defender("Garry Red", new Rating(2, 2), "Model.Defender");
        Defender redDefender2 = new Defender("Garry Red", new Rating(2, 2), "Model.Defender");
        Defender redDefender3 = new Defender("Garry Red", new Rating(2, 2), "Model.Defender");
        Defender redDefender4 = new Defender("Garry Red", new Rating(2, 2), "Model.Defender");
        Goalkeeper redGoalKeeper1 = new Goalkeeper("Tyler Red", new Rating(2, 2), "Model.Goalkeeper");
        ArrayList<Player> blueTeamPlayers = new ArrayList<>();
        ArrayList<Player> redTeamPlayers = new ArrayList<>();

        blueTeam.setPlayers(blueTeamPlayers);
        redTeam.setPlayers(redTeamPlayers);

        blueTeam.addPlayer(blueGoalKeeper1);
        blueTeam.addPlayer(blueDefender1);
        blueTeam.addPlayer(blueDefender2);
        blueTeam.addPlayer(blueDefender3);
        blueTeam.addPlayer(blueDefender4);
        blueTeam.addPlayer(blueMidfielder1);
        blueTeam.addPlayer(blueMidfielder2);
        blueTeam.addPlayer(blueMidfielder3);
        blueTeam.addPlayer(blueMidfielder4);
        blueTeam.addPlayer(blueStriker1);
        blueTeam.addPlayer(blueStriker2);

        redTeam.addPlayer(redGoalKeeper1);
        redTeam.addPlayer(redDefender1);
        redTeam.addPlayer(redDefender2);
        redTeam.addPlayer(redDefender3);
        redTeam.addPlayer(redDefender4);
        redTeam.addPlayer(redMidfielder1);
        redTeam.addPlayer(redMidfielder2);
        redTeam.addPlayer(redMidfielder3);
        redTeam.addPlayer(redMidfielder4);
        redTeam.addPlayer(redStriker1);
        redTeam.addPlayer(redStriker2);

    }


    @Test
    void calculateMatchDayStrongerTeam() {
        Result result = matchEngine.calculateMatchDay(blueTeam, redTeam);
        Assertions.assertTrue(result.getHomeGoals() > result.getAwayGoals());
    }


    @Test
    void awardPointsHomeTeamWon() {
        Result result = new Result(1, 0);
        matchEngine.awardPoints(result, blueTeam, redTeam);
        Assertions.assertEquals(3, blueTeam.getPoints());
        Assertions.assertEquals(0, redTeam.getPoints());
    }

    @Test
    void awardPointsDraw() {
        Result result = new Result(1, 1);
        matchEngine.awardPoints(result, blueTeam, redTeam);
        Assertions.assertEquals(1, blueTeam.getPoints());
        Assertions.assertEquals(1, redTeam.getPoints());
    }

    @Test
    void awardPointsAwayTeamWon() {
        Result result = new Result(0, 1);
        matchEngine.awardPoints(result, blueTeam, redTeam);
        Assertions.assertEquals(3, redTeam.getPoints());
        Assertions.assertEquals(0, blueTeam.getPoints());
    }

}