import java.util.Comparator;

public class Rule implements Comparator<Team> {
    @Override
    public int compare(Team t1, Team t2) {
        return String.valueOf(t1.getPoints()).compareTo(String.valueOf(t2.getPoints()));
    }
}
