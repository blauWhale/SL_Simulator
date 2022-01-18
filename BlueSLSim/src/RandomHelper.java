import java.util.Random;

public class RandomHelper {

    /**
     * @param min lowest Number possible
     * @param max highest Number possible
     * @return Random nummber
     */
    public int getRandomNumberBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

}
