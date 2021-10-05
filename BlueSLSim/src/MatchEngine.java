import java.util.Random;

public class MatchEngine {



    public Result calculateMatchDay(Team home, Team away) {
        int homeOnDay = home.getTeamRating();
        int awayOnDay = away.getTeamRating();
        int homeGoals = 0;
        int awayGoals = 0;

        boolean OneToThreeRatio = 0 == getRandomNumberBetween(0, 2);

        if (OneToThreeRatio) {
            homeOnDay = (home.getTeamRating()- getRandomNumberBetween(-3, +3));

        }
        if (OneToThreeRatio) {
            awayOnDay = (away.getTeamRating() - getRandomNumberBetween(-3, +3));

        }

        for(int chances = 0; chances < 3; chances ++){
            boolean goalScored = homeOnDay > getRandomNumberBetween(0,100);
            if(goalScored){
                homeGoals++;
            }
        }

        for(int chances = 0; chances < 3; chances ++){
            boolean goalScored = awayOnDay > getRandomNumberBetween(0,100);
            if(goalScored){
                awayGoals++;
            }
        }

        if (homeOnDay > awayOnDay) {
            Result result = new Result(homeGoals, awayGoals);
            awardPoints(result, home, away);
            return result;
        }
        if (homeOnDay == awayOnDay) {
            Result result = new Result(homeGoals, awayGoals);
            awardPoints(result, home, away);
            return result;
        } else {
            Result result = new Result(homeGoals, awayGoals);
            awardPoints(result, home, away);
            return result;
        }
    }

    public int getRandomNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
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
            away.setPoints(away.getDraws() + 1);
        } else {
            away.setPoints(away.getPoints() + 3);
            away.setWins(home.getWins() + 1);

            home.setLoses(home.getLoses() + 1);
        }
    }

    }

