package Model;

import Helpers.RandomHelper;

/**
 * A Model.Goalkeeper, Child of Model.Player Class
 */
public class Goalkeeper extends Player{
    RandomHelper randomHelper = new RandomHelper();

    public Goalkeeper(String name, Rating rating, String position) {
        super(name, rating, position);
    }

    public Goalkeeper(){}

    /**
     * Methode to determine if a save was successful
     * @return boolean if save was success
     */
    public boolean save(){
        return this.getRating().getFmRating() >= 5;
    }

    /**
     * Methode to determine if a interception was successful
     * @return boolean if intercept was success
     */
    public boolean intercept(){
        return this.getRating().getFmRating() >= 6;
    }
}
