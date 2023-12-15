package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.OutputView;

public class Service {
    OutputView outputView = new OutputView();

    public void startGame(Cars cars, Rounds rounds) {
        int round = getRound(rounds);
        outputView.printMessage("실행 결과");

        for (int i = 0; i < round; i++) {
            // !!!각각의 car에 무작위 숫자를 대입하기!!!
            playRound(cars);
            printStatus(cars);
            outputView.printEmptyLine();
        }
        printWinners(cars);
    }

    private void playRound(Cars cars) {
        for (Car car : cars.getCars()) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.move();
            }
        }
    }

    public int getRound(Rounds rounds) {
        int round = rounds.getRound();
        return round;
    }

    public void printStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            outputView.printMessage(cars.getRacingStatus(car));
        }
    }

    public void printWinners(Cars cars) {
        List<Car> winners = cars.calculateWinners();
        StringBuilder winnerNames = new StringBuilder();
        for (Car winner : winners) {
            if (winnerNames.length() > 0) {
                winnerNames.append(", ");
            }
            winnerNames.append(winner.getName());
        }
        outputView.printMessage("최종 우승자 : " + winnerNames.toString());
    }
}
