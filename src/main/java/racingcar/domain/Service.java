package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.OutputView;

public class Service {
    OutputView outputView = new OutputView();

    public void startGame(Cars cars, Rounds rounds) {
        int round = getRound(rounds);
        for (int i = 0; i < round; i++) {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if (randomNumber >= 4) {
                cars.moveAll();
            }
            printStatus(cars);
        }
        // 우승자
    }

    public int getRound(Rounds rounds) {
        int round = rounds.getRound();
        return round;
    }

    public void printStatus(Cars cars) {
        for (Car car : cars.getCars())
        outputView.printMessage(cars.getRacingStatus(car));
    }


}
