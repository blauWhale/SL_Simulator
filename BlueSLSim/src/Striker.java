public class Striker extends Player {
    RandomHelper randomHelper = new RandomHelper();

    public Striker(String name, Rating rating, String position) {
        super(name, rating, position);
    }

    public boolean scoreGoal(Rating opponentRating) {
        return randomHelper.getRandomNumberBetween(this.getRating().getOffensivRating(), 10) >= randomHelper.getRandomNumberBetween(opponentRating.getDefensivRating(), 10);

    }

    public boolean dribbel() {
        return this.getRating().getOffensivRating() >= 6;
    }
}
