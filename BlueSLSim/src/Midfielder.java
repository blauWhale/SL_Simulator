/**
 * A Midfielder, Child of Player Class
 */
public class Midfielder extends Player{
    RandomHelper randomHelper = new RandomHelper();

    public Midfielder(String name, Rating rating, String position) {
        super(name, rating, position);
    }

    /**
     * A Methode to determine if a pass was successful
     * @param opponentRating to compare to
     * @return if pass was successful
     */
    public boolean pass(Rating opponentRating){
        return randomHelper.getRandomNumberBetween(this.getRating().getOffensivRating(), 10) >= randomHelper.getRandomNumberBetween(opponentRating.getDefensivRating(), 10);
    }

    /**
     * A Methode to determine if a tackle was successful
     * @return if tackle was successful
     */
    public boolean tackle(){
        return this.getRating().getDefensivRating() >= 6;
    }
}
