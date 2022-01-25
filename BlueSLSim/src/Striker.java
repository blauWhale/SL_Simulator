/**
 * A Striker, Child of Player Class
 */
public class Striker extends Player {
    private RandomHelper randomHelper = new RandomHelper();

    public Striker(String name, Rating rating, String position) {
        super(name, rating, position);
    }

    /**
     * A Methode to determine if a Goal was scored
     * @param opponentRating to compare to
     * @return if goal was scored
     */
    public boolean scoreGoal(Rating opponentRating) {
        return randomHelper.getRandomNumberBetween(this.getRating().getOffensivRating(), 10) >= randomHelper.getRandomNumberBetween(opponentRating.getDefensivRating(), 10);

    }
    /**
     * A Methode to determine if a dribble was successful
     * @return if dribble was successful
     */
    public boolean dribble() {
        return this.getRating().getOffensivRating() >= 6;
    }
}
