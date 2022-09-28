package Model;

import Model.Rating;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Parent Class of all Model.Player Positions, used as a template
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "position")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Goalkeeper.class, name = "Goalkeeper"),
        @JsonSubTypes.Type(value = Defender.class, name = "Defender"),
        @JsonSubTypes.Type(value = Midfielder.class, name = "Midfielder"),
        @JsonSubTypes.Type(value = Striker.class, name = "Striker"),
})
public class Player {
    private String name;
    private Rating rating;
    private String position;

    public Player(String name, Rating rating, String position) {
        this.name = name;
        this.rating = rating;
        this.position = position;
    }

    public Player(){

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
