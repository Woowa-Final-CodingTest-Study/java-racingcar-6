package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void goForward(RandomNumberGenerator rnd) {
        cars.forEach(car -> car.goForward(rnd.next()));
    }

    public List<String> roundResult() {
        return cars.stream()
                .map(Car::roundResult)
                .collect(Collectors.toList());
    }

    public String winnerNames() {
        return Car.getWinnerNames(cars);
    }
}
