public class Striker extends Player {
    public Striker(String name, Rating rating) {
        super(name, rating);
    }

    public boolean shot() {
        return this.getRating().getOffensivRating() >= 5;
    }

    public boolean dribbel() {
        return this.getRating().getOffensivRating() >= 6;
    }
}
