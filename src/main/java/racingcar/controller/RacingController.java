package racingcar.controller;

import java.util.List;
import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    Racing racing;

    public void run() {
        requestCarName();
//        requestAttempts();
//        showResult();
//        showFinalWinner();
    }

    public void requestCarName() {
        OutputView.printRequestCarName();
        List<String> cars = InputView.readCarName();
    }
}
