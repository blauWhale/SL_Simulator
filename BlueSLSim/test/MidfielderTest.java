import Model.Defender;
import Model.Midfielder;
import Model.Rating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MidfielderTest {

    @Test
    void passSuccessful() {
        Defender hans = new Defender("Hans", new Rating(1, 1), "Model.Defender");
        Midfielder eriksen = new Midfielder("Messi", new Rating(10, 10), "Model.Midfielder");
        Assertions.assertTrue(eriksen.pass(hans.getRating()));
    }

    @Test
    void passUnsuccessful() {
        Defender alaba = new Defender("Sommer", new Rating(10, 10), "Model.Goalkeeper");
        Midfielder peter = new Midfielder("Peter", new Rating(1, 1), "Model.Striker");
        Assertions.assertFalse(peter.pass(alaba.getRating()));
    }

}