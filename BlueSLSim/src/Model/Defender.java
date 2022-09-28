package Model;

import Helpers.RandomHelper;

/**
 * A Defensive Model.Player, Child of Model.Player Class
 */
public class Defender extends Player{
    RandomHelper randomHelper = new RandomHelper();

    public Defender(String name, Rating rating, String position) {
        super(name, rating, position);
    }
    public Defender() {
    }

    /**
     * Methode to determin if a tackle was sucessful
     * @return boolean if tackle was success
     */
    public boolean tackle(){
        return this.getRating().getFmRating() >= 5;
    }

    /**
     * Methode to determine if a intercept was successful
     * @return boolean if intercept was success
     */
    public boolean intercept(){
        return this.getRating().getFmRating() >= 6;
    }
}
