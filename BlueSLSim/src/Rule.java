import java.util.Comparator;

public class Rule implements Comparator<Team> {
    @Override
    public int compare(Team t1, Team t2) {
        return t2.getPoints().compareTo(t1.getPoints());
    }
}
