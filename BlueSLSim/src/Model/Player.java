package Model;

import Model.Rating;

/**
 * Parent Class of all Model.Player Positions, used as a template
 */
public class Player {
    private String name;
    private Rating rating;
    private String position;

    public Player(String name, Rating rating, String position) {
        this.name = name;
        this.rating = rating;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
