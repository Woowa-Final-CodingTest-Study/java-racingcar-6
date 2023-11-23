package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    List<Car> cars;

    public Racing(List<String> carName) {
        cars = new ArrayList<>();

        for (String name : carName) {
            cars.add(new Car(name));
        }
    }
}
