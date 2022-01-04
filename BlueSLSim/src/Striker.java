public class Striker extends Player{
    public Striker(String name, Rating rating) {
        super(name, rating);
    }

    public void shot(Rating rating){
        if(this.getRating().getOffensivRating() > 5){
            System.out.println("Goal");
        }

    }
}
