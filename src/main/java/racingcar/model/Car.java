package racingcar.model;

import java.util.List;
import java.util.NoSuchElementException;

public class Car {
    public static final int NAME_MAX_LENGTH = 5;

    private static final int RANDOM_NUMBER_THRESHOLD = 4;

    private final String name;
    private int moveCount;
    private final int UNIT_DISTANCE = 1;

    public Car(String name) {
        this.name = name;
    }

    public void goForward(int randomValue) {
        if (randomValue >= RANDOM_NUMBER_THRESHOLD)
            moveCount += UNIT_DISTANCE;
    }

    public String roundResult() {
        return name +
                " : " +
                "-".repeat(moveCount);
    }

    public static String getWinnerNames(List<Car> cars) {
        int maxValue = cars.stream()
                .mapToInt(car -> car.moveCount)
                .max()
                .orElseThrow(NoSuchElementException::new);
        List<Car> winners = cars.stream()
                .filter(car -> car.moveCount == maxValue)
                .toList();

        StringBuilder sb = new StringBuilder();
        winners.forEach(winner -> {
            if (!sb.isEmpty())
                sb.append(", ");
            sb.append(winner.name);
        });
        return sb.toString();
    }
}
