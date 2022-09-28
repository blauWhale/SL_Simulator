package Model;

import Helpers.RandomHelper;

/**
 * A Model.Midfielder, Child of Model.Player Class
 */
public class Midfielder extends Player{
    private RandomHelper randomHelper = new RandomHelper();

    public Midfielder(String name, Rating rating, String position) {
        super(name, rating, position);
    }
    public Midfielder() {
    }

    /**
     * A Methode to determine if a pass was successful
     * @param opponentRating to compare to
     * @return if pass was successful
     */
    public boolean pass(Rating opponentRating){
        return randomHelper.getRandomNumberBetween(this.getRating().getFmRating(), 100) >= randomHelper.getRandomNumberBetween(opponentRating.getFmRating(), 100);
    }

    /**
     * A Methode to determine if a tackle was successful
     * @return if tackle was successful
     */
    public boolean tackle(){
        return this.getRating().getFmRating() >= 6;
    }
}
