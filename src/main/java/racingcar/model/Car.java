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
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
        sb.append("-".repeat(moveCount));
        return sb.toString();
    }
}
