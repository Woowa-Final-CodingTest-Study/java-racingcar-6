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

        outputView.printStartRacing();
        for (int i = 0; i < tryCount; i++) { // TODO: 함수로 한 번 감싸도 괜찮을 듯?
            cars.goForward(); // TODO: 난수를 밖에서 제공하도록 리팩토링
            outputView.printRoundResult(cars);
        }

        outputView.printWinner(cars);
    }
}
