import java.util.Comparator;

public class Rule implements Comparator<Team> {
    @Override
    public int compare(Team t1, Team t2) {
        if(t2.getPoints().equals(t1.getPoints())){
            Integer t2GoalDiff = t2.getGoalsScored() - t2.getGoalsConceded();
            Integer t1GoalDiff = t1.getGoalsScored() - t1.getGoalsConceded();
            return t2GoalDiff.compareTo(t1GoalDiff);
        }
        return t2.getPoints().compareTo(t1.getPoints());
    }
}
