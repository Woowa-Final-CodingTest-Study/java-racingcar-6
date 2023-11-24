package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

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

    public void execute() {
        for (Car car : cars) {
            if (getRandomNumber() >= 4) {
                car.goForward();
            }
        }
    }

    public int getRandomNumber() {
        return pickNumberInRange(0, 9);
    }

    public void getResults() {

    }
}
