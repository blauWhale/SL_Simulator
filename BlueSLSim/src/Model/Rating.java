package Model;

/**
 * A Simple Java Object to persist a team's Model.Rating
 */
public class Rating {
    private int fmRating;
    private int elo;

    public Rating(int fmRating) {
        this.fmRating = fmRating;
    }

    public Rating() {
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public int getFmRating() {
        return fmRating;
    }

    public void setFmRating(int fmRating) {
        this.fmRating = fmRating;
    }
}
