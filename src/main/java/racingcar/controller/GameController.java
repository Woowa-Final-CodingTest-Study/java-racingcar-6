package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {

    private static GameController controller;

    private final InputView inputView;
    private final OutputView outputView;

    private GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static GameController getInstance(InputView inputView, OutputView outputView) {
        if (controller == null) {
            controller = new GameController(inputView, outputView);
        }
        return controller;
    }

    public void start() {
        outputView.notifyInputCarNames();
        List<String> carNames = inputView.readCarNames();

        Cars cars = new Cars(carNames);

        outputView.notifyInputTryCount();
        int tryCount = inputView.readTryCount();

        outputView.printRacingResult();
        for (int i = 0; i < tryCount; i++) {
            cars.goForward();
            outputView.printRoundResult(cars);
        }
    }
}
