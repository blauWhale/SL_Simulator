public class Midfielder extends Player{
    RandomHelper randomHelper = new RandomHelper();

    public Midfielder(String name, Rating rating, String position) {
        super(name, rating, position);
    }

    public boolean pass(Rating opponentRating){
        return randomHelper.getRandomNumberBetween(this.getRating().getOffensivRating(), 10) >= randomHelper.getRandomNumberBetween(opponentRating.getDefensivRating(), 10);
    }

    public boolean tackle(){
        return this.getRating().getDefensivRating() >= 6;
    }
}
