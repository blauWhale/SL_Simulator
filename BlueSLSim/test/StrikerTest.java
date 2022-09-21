import Model.Goalkeeper;
import Model.Rating;
import Model.Striker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StrikerTest {
    @Test
    void scoreGoalSuccessful() {
        Goalkeeper hans = new Goalkeeper("Hans", new Rating(1, 1), "Model.Goalkeeper");
        Striker messi = new Striker("Messi", new Rating(10, 10), "Model.Striker");
        Assertions.assertTrue(messi.scoreGoal(hans.getRating()));
    }

    @Test
    void scoreGoalUnsuccessful() {
        Goalkeeper sommer = new Goalkeeper("Sommer", new Rating(10, 10), "Model.Goalkeeper");
        Striker peter = new Striker("Peter", new Rating(1, 1), "Model.Striker");
        Assertions.assertFalse(peter.scoreGoal(sommer.getRating()));
    }

}