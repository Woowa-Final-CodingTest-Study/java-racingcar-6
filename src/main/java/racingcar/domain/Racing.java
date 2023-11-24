package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.utils.constants.NUMBER_GOFORWARD_MIN;
import static racingcar.utils.constants.RANDOM_NUMBER_MAX;
import static racingcar.utils.constants.RANDOM_NUMBER_MIN;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Racing {
    private final List<Car> cars;

    public Racing(List<String> carName) {
        cars = new ArrayList<>();

        for (String name : carName) {
            cars.add(new Car(name));
        }
    }

    public void execute() {
        for (Car car : cars) {
            if (getRandomNumber() >= NUMBER_GOFORWARD_MIN) {
                car.goForward();
            }
        }
    }

    private int getRandomNumber() {
        return pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
    }

    public List<String> getResults() {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            results.add(cars.get(i).getResult());
        }
        return results;
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        int maxLocation = getMaxLocation();

        for (Car car : cars) {
            if (maxLocation == car.getLocation()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxLocation() {
        return cars.stream()
                .map(Car::getLocation)
                .max(Comparator.comparingInt(x -> x))
                .orElseThrow(NoSuchElementException::new);
    }
}
