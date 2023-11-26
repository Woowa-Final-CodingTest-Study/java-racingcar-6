package racingcar.model;

public class RandomNumberGenerator {
    private final int RANDOM_NUMBER_RANGE_MIN = 0;
    private final int RANDOM_NUMBER_RANGE_MAX = 9;

    private final int min;
    private final int max;

    public RandomNumberGenerator() {
        min = RANDOM_NUMBER_RANGE_MIN;
        max = RANDOM_NUMBER_RANGE_MAX;
    }

    public int next() {
        return camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(min, max);
    }
}
