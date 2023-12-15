package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> cars) {
        List<Car> tempCars = new ArrayList<>();
        for (String car : cars) {
            tempCars.add(new Car(car));
        }
        this.cars = tempCars;
    }
}
