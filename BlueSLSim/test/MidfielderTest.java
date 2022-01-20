import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MidfielderTest {

    @Test
    void passSuccessful() {
        Defender hans = new Defender("Hans", new Rating(1, 1), "Defender");
        Midfielder eriksen = new Midfielder("Messi", new Rating(10, 10), "Midfielder");
        Assertions.assertTrue(eriksen.pass(hans.getRating()));
    }

    @Test
    void passUnsuccessful() {
        Defender alaba = new Defender("Sommer", new Rating(10, 10), "Goalkeeper");
        Midfielder peter = new Midfielder("Peter", new Rating(1, 1), "Striker");
        Assertions.assertFalse(peter.pass(alaba.getRating()));
    }

}