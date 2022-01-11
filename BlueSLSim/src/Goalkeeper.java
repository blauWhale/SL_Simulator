public class Goalkeeper extends Player{

    public Goalkeeper(String name, Rating rating) {
        super(name, rating);
    }

    public boolean save(){
        return this.getRating().getDefensivRating() >= 5;
    }

    public boolean intercept(){
        return this.getRating().getDefensivRating() >= 6;
    }
}
