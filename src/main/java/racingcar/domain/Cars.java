package racingcar.domain;

import static racingcar.utils.NumberConstants.MAXIMUM_RANDOM_NUMBER;
import static racingcar.utils.NumberConstants.MINIMUM_RANDOM_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(MINIMUM_RANDOM_NUMBER.getValue(), MAXIMUM_RANDOM_NUMBER.getValue()));
        }
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition().getPosition() > maxPosition) {
                maxPosition = car.getPosition().getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> getWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition().getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }
}
