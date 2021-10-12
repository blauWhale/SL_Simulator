import java.util.Random;

public class MatchEngine {

    public Result calculateMatchDay(Team home, Team away) {
        int homeOffensiveRatingOnDay = home.getOffensiveRating();
        int homeDefensivRatingOnDay = home.getDefensiveRating();
        int homeGoals = 0;


        int awayOffensiveRatingOnDay = away.getOffensiveRating();
        int awayDefensiveRatingOnDay = away.getDefensiveRating();
        int awayGoals = 0;

        if (0 == getRandomNumberBetween(0, 2)) {
            homeOffensiveRatingOnDay = (home.getOffensiveRating() - getRandomNumberBetween(-2, +2));
            homeDefensivRatingOnDay = (home.getDefensiveRating() - getRandomNumberBetween(-2, +2));

        }
        if (0 == getRandomNumberBetween(0, 2)) {
            awayOffensiveRatingOnDay = (away.getOffensiveRating() - getRandomNumberBetween(-2, +2));
            awayDefensiveRatingOnDay = (away.getDefensiveRating() - getRandomNumberBetween(-2, +2));

        }

        for (int chances = 0; chances < getRandomNumberBetween(1,6); chances++) {
            boolean goalScored = getRandomNumberBetween(homeOffensiveRatingOnDay, 20) > getRandomNumberBetween(awayDefensiveRatingOnDay, 20);
            if (goalScored) {
                homeGoals++;
            }
        }

        for (int chances = 0; chances < getRandomNumberBetween(0,6); chances++) {
            boolean goalScored = getRandomNumberBetween(awayOffensiveRatingOnDay, 20) > getRandomNumberBetween(homeDefensivRatingOnDay, 20);
            if (goalScored) {
                awayGoals++;
            }
        }

        Result result = new Result(homeGoals, awayGoals);
        awardPoints(result, home, away);
        return result;
    }

    public void awardPoints(Result result, Team home, Team away) {
        if (result.homeGoals > result.awayGoals) {
            home.setPoints(home.getPoints() + 3);
            home.setWins(home.getWins() + 1);

            away.setLoses(away.getLoses() + 1);
        }
        if (result.homeGoals == result.awayGoals) {
            home.setPoints(home.getPoints() + 1);
            home.setDraws(home.getDraws() + 1);

            away.setPoints(away.getPoints() + 1);
            away.setDraws(away.getDraws() + 1);
        }
        if (result.homeGoals < result.awayGoals) {
            away.setPoints(away.getPoints() + 3);
            away.setWins(away.getWins() + 1);

            home.setLoses(home.getLoses() + 1);
        }

        home.setGoalsScored(home.getGoalsScored() + result.homeGoals);
        home.setGoalsConceded(home.getGoalsConceded() + result.awayGoals);
        home.setGames(home.getGames() + 1);

        away.setGoalsScored(away.getGoalsScored() + result.awayGoals);
        away.setGoalsConceded(away.getGoalsConceded() + result.homeGoals);
        away.setGames(away.getGames() + 1);


    }

    public int getRandomNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}



