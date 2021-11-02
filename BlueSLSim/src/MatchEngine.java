import java.util.Random;

/**
 * Used to simulate matchdays and award points
 */
public class MatchEngine {

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

        if (0 == getRandomNumberBetween(0, 2)) {
            homeRatingOnDay.setOffensivRating(homeRatingOnDay.getOffensivRating() - getRandomNumberBetween(-2, +2));
            homeRatingOnDay.setDefensivRating(homeRatingOnDay.getDefensivRating() - getRandomNumberBetween(-2, +2));

        }
        if (0 == getRandomNumberBetween(0, 2)) {
            awayRatingOnDay.setOffensivRating(awayRatingOnDay.getOffensivRating() - getRandomNumberBetween(-2, +2));
            awayRatingOnDay.setDefensivRating(awayRatingOnDay.getDefensivRating() - getRandomNumberBetween(-2, +2));
        }

        for (int chances = 0; chances < getRandomNumberBetween(1,6); chances++) {
            boolean goalScored = getRandomNumberBetween(homeRatingOnDay.getOffensivRating(), 10) > getRandomNumberBetween(awayRatingOnDay.getDefensivRating(), 10);
            if (goalScored) {
                homeGoals++;
            }
        }

        for (int chances = 0; chances < getRandomNumberBetween(0,6); chances++) {
            boolean goalScored = getRandomNumberBetween(awayRatingOnDay.getOffensivRating(), 10) > getRandomNumberBetween(homeRatingOnDay.getDefensivRating(), 10);
            if (goalScored) {
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

    /**
     * @param min lowest Number possible
     * @param max highest Number possible
     * @return Random nummber
     */
    public int getRandomNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}



