package racingcar.controller;

import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private Racing racing;
    private int attempts;

    public void run() {
        requestCarName();
        requestAttempts();

        showResult();
        showFinalWinner();
    }

    public void requestCarName() {
        OutputView.printRequestCarName();
        racing = new Racing(InputView.readCarName());
    }

    public void requestAttempts() {
        OutputView.printRequestAttempts();
        attempts = InputView.readAttempts();
    }

    public void showResult() {
        OutputView.printResultTitle();
        for (int i = 0; i < attempts; i++) {
            racing.execute();
            OutputView.printResult(racing.getResults());
        }
    }

    public void showFinalWinner() {
        OutputView.printFinalWinner(racing.getWinner());
    }
}
