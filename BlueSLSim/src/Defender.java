public class Defender extends Player{
    public Defender(String name, Rating rating) {
        super(name, rating);
    }
    public boolean tackle(){
        return this.getRating().getDefensivRating() >= 5;
    }

    public boolean intercept(){
        return this.getRating().getDefensivRating() >= 6;
    }
}
