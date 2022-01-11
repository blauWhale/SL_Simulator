public class Midfielder extends Player{
    public Midfielder(String name, Rating rating) {
        super(name, rating);
    }
    public boolean pass(){
        return this.getRating().getOffensivRating() >= 5;
    }

    public boolean tackle(){
        return this.getRating().getDefensivRating() >= 6;
    }
}
