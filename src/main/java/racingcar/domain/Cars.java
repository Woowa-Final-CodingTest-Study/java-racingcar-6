package racingcar.domain;

import static java.lang.System.lineSeparator;

import java.util.ArrayList;
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

    // !!!아주 중요!!!
    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public String getRacingStatus(Car car) {
        String carName = car.getName();
        int currentPosition = car.getPosition();
        StringBuilder sb = new StringBuilder();
        sb.append(carName).append(" : ");
        if (currentPosition > 0) {
            sb.append("-".repeat(currentPosition));
        }
        return sb.toString();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> calculateWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
