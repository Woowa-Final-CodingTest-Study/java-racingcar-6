package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

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

    public int getMaxLocation() {
        return cars.stream()
                .map(Car::getLocation)
                .max(Comparator.comparingInt(x -> x))
                .orElseThrow(NoSuchElementException::new);
    }
}
