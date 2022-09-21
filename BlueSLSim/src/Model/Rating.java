package Model;

/**
 * A Simple Java Object to persist a team's Model.Rating
 */
public class Rating {
    private int offensivRating;
    private int defensivRating;
    private int elo;

    public Rating(int elo) {
        this.elo = elo;
    }

    public Rating(int offensivRating, int defensivRating) {
        this.offensivRating = offensivRating;
        this.defensivRating = defensivRating;
    }

    public int getOffensivRating() {
        return offensivRating;
    }

    public void setOffensivRating(int offensivRating) {
        this.offensivRating = offensivRating;
    }

    public int getDefensivRating() {
        return defensivRating;
    }

    public void setDefensivRating(int defensivRating) {
        this.defensivRating = defensivRating;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }
}
