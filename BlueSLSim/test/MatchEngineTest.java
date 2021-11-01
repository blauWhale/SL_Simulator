import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatchEngineTest {
    MatchEngine matchEngine = new MatchEngine();
    Team blueTeam = new Team("Strong FC",new Rating(7,7));
    Team redTeam = new Team("Weak United",new Rating(2,2));



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