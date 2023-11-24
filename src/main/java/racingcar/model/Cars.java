package racingcar.model;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void goForward() {
        cars.forEach(Car::goForward);
    }

    public List<String> roundResult() {
        return cars.stream()
                .map(Car::roundResult)
                .collect(Collectors.toList());
    }

    public String winnerNames() {
        int maxValue = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElseThrow(NoSuchElementException::new);

        List<Car> winners = cars.stream()
                .filter(car -> car.getMoveCount() == maxValue)
                .toList();

        StringBuilder sb = new StringBuilder();
        winners.forEach(winner -> {
            if (!sb.isEmpty())
                sb.append(", ");
            sb.append(winner.getName());
        });
        return sb.toString();
    }
}
