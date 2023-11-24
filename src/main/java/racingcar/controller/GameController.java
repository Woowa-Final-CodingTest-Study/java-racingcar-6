package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

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
}
