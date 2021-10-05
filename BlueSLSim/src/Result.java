public class Result {
    int homeGoals;
    int awayGoals;

    Result(){}

    public Result(int homeGoals, int awayGoals) {
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
    }

    @Override
    public String toString() {
        return homeGoals + ":" + awayGoals;
    }
}
