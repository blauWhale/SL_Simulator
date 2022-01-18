import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatchEngineTest {
    MatchEngine matchEngine = new MatchEngine();
    Team blueTeam = new Team("Strong FC",new Rating(7,7));
    Team redTeam = new Team("Weak United",new Rating(2,2));
    Midfielder blueMidfielder = new Midfielder("Jack Blue", new Rating(9,9),"Midfielder");
    Striker blueStriker = new Striker("John Blue", new Rating(9,9),"Striker");
    Defender redDefender = new Defender("Garry Red", new Rating (2,2),"Defender");
    Goalkeeper redGoalkeeper = new Goalkeeper("Tyler Red", new Rating(2,2),"Goalkeeper");



    @Test
    void calculateMatchDayStrongerTeam() {
        Result result = matchEngine.calculateMatchDay(blueTeam, redTeam);
        Assertions.assertTrue(result.getHomeGoals() > result.getAwayGoals());
    }


    @Test
    void awardPointsHomeTeamWon() {
        Result result = new Result(1,0);
        matchEngine.awardPoints(result, blueTeam, redTeam);
        Assertions.assertEquals(3,blueTeam.getPoints());
        Assertions.assertEquals(0,redTeam.getPoints());
    }
    @Test
    void awardPointsDraw() {
        Result result = new Result(1,1);
        matchEngine.awardPoints(result, blueTeam, redTeam);
        Assertions.assertEquals(1,blueTeam.getPoints());
        Assertions.assertEquals(1,redTeam.getPoints());
    }

    @Test
    void awardPointsAwayTeamWon() {
        Result result = new Result(0,1);
        matchEngine.awardPoints(result, blueTeam, redTeam);
        Assertions.assertEquals(3,redTeam.getPoints());
        Assertions.assertEquals(0,blueTeam.getPoints());
    }

}