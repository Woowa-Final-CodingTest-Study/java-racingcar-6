package racingcar.constant;

public enum RaceConstant {
    NAME_LENGTH_LIMIT(5),
    MOVING_STANDARD(4),
    MINIMUM_NUMBER(0),
    MAXIMUM_NUMBER(9);

    private final int number;

    RaceConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
