import java.util.Comparator;

public class Rule implements Comparator<Team> {
    /** Used to compare to teams and sort them by:
     * 1.Points
     * 2.Goal Difference
     * @param t1 first Team to compare
     * @param t2 second Team to compate
     * @return outcome of comparison
     */
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
