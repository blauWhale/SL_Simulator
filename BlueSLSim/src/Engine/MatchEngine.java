package Engine;

import Helpers.RandomHelper;
import Model.*;

import java.util.ArrayList;

/**
 * Used to simulate matchdays and award points
 */
public class MatchEngine {
    RandomHelper randomHelper = new RandomHelper();

    /**
     * Calculates a Match between two Teams and returns the result
     * @param home Model.Team
     * @param away Model.Team
     * @return a game Model.Result
     */
    public Result calculateMatchDay(Team home, Team away) {
        ArrayList<Player> homeTeamOnDay = new ArrayList<>();
        for(Player homePlayer: home.getPlayers()){
            homeTeamOnDay.add(new Player(homePlayer.getName(),homePlayer.getRating(),homePlayer.getPosition()));
        }
        int homeGoals = 0;


        ArrayList<Player> awayTeamOnDay = new ArrayList<>();
        for(Player awayPlayer: away.getPlayers()){
            awayTeamOnDay.add(new Player(awayPlayer.getName(),awayPlayer.getRating(),awayPlayer.getPosition()));
        }int awayGoals = 0;



        for(Player playerOnDay: homeTeamOnDay){
            if (0 == randomHelper.getRandomNumberBetween(0, 2)) {
                playerOnDay.setRating(new Rating (playerOnDay.getRating().getOffensivRating() - randomHelper.getRandomNumberBetween(-2, +2), playerOnDay.getRating().getDefensivRating() - randomHelper.getRandomNumberBetween(-2, +2)));
            }
        }

        for(Player playerOnDay: awayTeamOnDay){
            if (0 == randomHelper.getRandomNumberBetween(0, 2)) {
                playerOnDay.setRating(new Rating(playerOnDay.getRating().getOffensivRating() - randomHelper.getRandomNumberBetween(-2, +2), playerOnDay.getRating().getDefensivRating() - randomHelper.getRandomNumberBetween(-2, +2)));
            }
        }

        //Chances Home Model.Team
        for (int chances = 0; chances < randomHelper.getRandomNumberBetween(1,6); chances++) {
            boolean homeGoalScored = false;
            Midfielder homeMidfielder = (Midfielder) home.getPlayers().get(randomHelper.getRandomNumberBetween(5,8));
            Defender awayDefender = (Defender) away.getPlayers().get(randomHelper.getRandomNumberBetween(1,4));
            Striker homeStriker = (Striker) home.getPlayers().get(randomHelper.getRandomNumberBetween(9,10));
            Goalkeeper awayGoalkeeper = (Goalkeeper) away.getPlayers().get(0);
            if((homeMidfielder.pass(awayDefender.getRating()))){
                homeGoalScored = homeStriker.scoreGoal(awayGoalkeeper.getRating());
            }
            if (homeGoalScored) {
                homeGoals++;
            }
        }

        //Chances Away Model.Team
        for (int chances = 0; chances < randomHelper.getRandomNumberBetween(0,6); chances++) {
            boolean awayGoalScored = false;
            Midfielder awayMidfielder = (Midfielder) away.getPlayers().get(randomHelper.getRandomNumberBetween(5,8));
            Defender homeDefender = (Defender) home.getPlayers().get(randomHelper.getRandomNumberBetween(1,4));
            Striker awayStriker = (Striker) away.getPlayers().get(randomHelper.getRandomNumberBetween(9,10));
            Goalkeeper homeGoalkeeper = (Goalkeeper) home.getPlayers().get(0);
            if((awayMidfielder.pass(homeDefender.getRating()))){
                awayGoalScored = awayStriker.scoreGoal(homeGoalkeeper.getRating());
            }
            if (awayGoalScored) {
                awayGoals++;
            }
        }

        Result result = new Result(homeGoals, awayGoals);
        awardPoints(result, home, away);
        return result;
    }

    /**
     * Awards Points to two Model.Team given a result
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



