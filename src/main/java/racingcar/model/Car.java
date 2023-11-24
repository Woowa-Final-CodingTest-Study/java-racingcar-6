package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
    }

    public void goForward() {
        int i = Randoms.pickNumberInRange(0, 9);
        if (i >= 4)
            moveCount++;
    }

    public String roundResult() {
        return name +
                " : " +
                "-".repeat(moveCount);
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
