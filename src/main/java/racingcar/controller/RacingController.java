package racingcar.controller;

import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    Racing racing;
    int attempts;

    public void run() {
        requestCarName();
        requestAttempts();
//        showResult();
//        showFinalWinner();
    }

    public void requestCarName() {
        OutputView.printRequestCarName();
        racing = new Racing(InputView.readCarName());
    }

    public void requestAttempts() {
        OutputView.printRequestAttempts();
        attempts = InputView.readAttempts();
    }
}
