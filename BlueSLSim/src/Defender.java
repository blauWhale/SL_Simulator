/**
 * A Defensive Player, Child of Player Class
 */
public class Defender extends Player{
    RandomHelper randomHelper = new RandomHelper();

    public Defender(String name, Rating rating, String position) {
        super(name, rating, position);
    }

    /**
     * Methode to determin if a tackle was sucessful
     * @return boolean if tackle was success
     */
    public boolean tackle(){
        return this.getRating().getDefensivRating() >= 5;
    }

    /**
     * Methode to determine if a intercept was successful
     * @return boolean if intercept was success
     */
    public boolean intercept(){
        return this.getRating().getDefensivRating() >= 6;
    }
}
