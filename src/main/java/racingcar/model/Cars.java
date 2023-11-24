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
}
