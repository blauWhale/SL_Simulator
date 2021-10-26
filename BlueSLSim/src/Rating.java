public class Rating {
    private int offensivRating;
    private int defensivRating;

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
}
