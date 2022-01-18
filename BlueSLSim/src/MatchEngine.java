/**
 * Used to simulate matchdays and award points
 */
public class MatchEngine {
    RandomHelper randomHelper = new RandomHelper();

    /**
     * Calculates a Match between two Teams and returns the result
     * @param home Team
     * @param away Team
     * @return a game Result
     */
    public Result calculateMatchDay(Team home, Team away) {
        Rating homeRatingOnDay = new Rating(home.getRating().getOffensivRating(),home.getRating().getDefensivRating());
        int homeGoals = 0;


        Rating awayRatingOnDay = new Rating(away.getRating().getOffensivRating(),away.getRating().getDefensivRating());
        int awayGoals = 0;

        if (0 == randomHelper.getRandomNumberBetween(0, 2)) {
            homeRatingOnDay.setOffensivRating(homeRatingOnDay.getOffensivRating() - randomHelper.getRandomNumberBetween(-2, +2));
            homeRatingOnDay.setDefensivRating(homeRatingOnDay.getDefensivRating() - randomHelper.getRandomNumberBetween(-2, +2));

        }
        if (0 == randomHelper.getRandomNumberBetween(0, 2)) {
            awayRatingOnDay.setOffensivRating(awayRatingOnDay.getOffensivRating() - randomHelper.getRandomNumberBetween(-2, +2));
            awayRatingOnDay.setDefensivRating(awayRatingOnDay.getDefensivRating() - randomHelper.getRandomNumberBetween(-2, +2));
        }

        //Chances Home Team
        for (int chances = 0; chances < randomHelper.getRandomNumberBetween(1,6); chances++) {
            boolean homeGoalScored = false;
            Midfielder homeMidfielder = (Midfielder) home.getPlayers().get(randomHelper.getRandomNumberBetween(5,8));
            Defender awayDefender = (Defender) away.getPlayers().get(randomHelper.getRandomNumberBetween(1,4));
            Striker homeStriker = (Striker) home.getPlayers().get(randomHelper.getRandomNumberBetween(9,10));
            Goalkeeper awayGoalkeeper = (Goalkeeper) away.getPlayers().get(0);
            if((homeMidfielder.pass(awayDefender.getRating()))){
                homeGoalScored = homeStriker.scoreGoal(awayGoalkeeper.getRating());
            }
            //boolean goalScored = randomHelper.getRandomNumberBetween(homeRatingOnDay.getOffensivRating(), 10) > randomHelper.getRandomNumberBetween(awayRatingOnDay.getDefensivRating(), 10);
            if (homeGoalScored) {
                homeGoals++;
            }
        }

        //Chances Away Team
        for (int chances = 0; chances < randomHelper.getRandomNumberBetween(0,6); chances++) {
            boolean awayGoalScored = false;
            Midfielder awayMidfielder = (Midfielder) away.getPlayers().get(randomHelper.getRandomNumberBetween(5,8));
            Defender homeDefender = (Defender) home.getPlayers().get(randomHelper.getRandomNumberBetween(1,4));
            Striker awayStriker = (Striker) away.getPlayers().get(randomHelper.getRandomNumberBetween(9,10));
            Goalkeeper homeGoalkeeper = (Goalkeeper) home.getPlayers().get(0);
            if((awayMidfielder.pass(homeDefender.getRating()))){
                awayGoalScored = awayStriker.scoreGoal(homeGoalkeeper.getRating());
            }
           // boolean goalScored = randomHelper.getRandomNumberBetween(awayRatingOnDay.getOffensivRating(), 10) > randomHelper.getRandomNumberBetween(homeRatingOnDay.getDefensivRating(), 10);
            if (awayGoalScored) {
                awayGoals++;
            }
        }

        Result result = new Result(homeGoals, awayGoals);
        awardPoints(result, home, away);
        return result;
    }

    /**
     * Awards Points to two Team given a result
     *
     * @param result
     * @param home
     * @param away
     */
    public void awardPoints(Result result, Team home, Team away) {
        if (result.getHomeGoals() > result.getAwayGoals()) {
            home.setPoints(home.getPoints() + 3);
            home.setWins(home.getWins() + 1);

            away.setLoses(away.getLoses() + 1);
        }
        if (result.getHomeGoals() == result.getAwayGoals()) {
            home.setPoints(home.getPoints() + 1);
            home.setDraws(home.getDraws() + 1);

            away.setPoints(away.getPoints() + 1);
            away.setDraws(away.getDraws() + 1);
        }
        if (result.getHomeGoals() < result.getAwayGoals()) {
            away.setPoints(away.getPoints() + 3);
            away.setWins(away.getWins() + 1);

            home.setLoses(home.getLoses() + 1);
        }

        home.setGoalsScored(home.getGoalsScored() + result.getHomeGoals());
        home.setGoalsConceded(home.getGoalsConceded() + result.getAwayGoals());
        home.setGames(home.getGames() + 1);

        away.setGoalsScored(away.getGoalsScored() + result.getAwayGoals());
        away.setGoalsConceded(away.getGoalsConceded() + result.getHomeGoals());
        away.setGames(away.getGames() + 1);


    }


}



