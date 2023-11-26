package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import javax.sql.rowset.CachedRowSet;
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

        outputView.notifyInputRoundCount();
        int roundCount = inputView.readRoundCount();

        outputView.printStartRacing();
        RandomNumberGenerator rnd = new RandomNumberGenerator();
        for (int i = 0; i < roundCount; i++) {
            cars.goForward(rnd);
            outputView.printRoundResult(cars);
        }

        outputView.printWinner(cars);
    }
}
