/**
 * A Goalkeeper, Child of Player Class
 */
public class Goalkeeper extends Player{
    RandomHelper randomHelper = new RandomHelper();

    public Goalkeeper(String name, Rating rating, String position) {
        super(name, rating, position);
    }

    /**
     * Methode to determine if a save was successful
     * @return boolean if save was success
     */
    public boolean save(){
        return this.getRating().getDefensivRating() >= 5;
    }

    /**
     * Methode to determine if a interception was successful
     * @return boolean if intercept was success
     */
    public boolean intercept(){
        return this.getRating().getDefensivRating() >= 6;
    }
}
